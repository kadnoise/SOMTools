package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class SWN3 {

    private String pathToSWN = "C:/Users/RaulFreire/Documents/SentiWord/src/Synsets/Senti2.txt";
    private HashMap<String, Double> _dict;

    public SWN3() {

        _dict = new HashMap<String, Double>();
        HashMap<String, Vector<Double>> _temp = new HashMap<String, Vector<Double>>();
        try {
            BufferedReader csv = new BufferedReader(new FileReader(pathToSWN));
            String line = "";
            while ((line = csv.readLine()) != null) {
                String[] data = line.split("\t");
                Double score = Double.parseDouble(data[2]) - Double.parseDouble(data[3]);
                String[] words = data[4].split(" ");
                for (String w : words) {
                    String[] w_n = w.split("#");
                    w_n[0] += "#" + data[0];
                    int index = Integer.parseInt(w_n[1]) - 1;
                    if (_temp.containsKey(w_n[0])) {
                        Vector<Double> v = _temp.get(w_n[0]);
                        if (index > v.size()) {
                            for (int i = v.size(); i < index; i++) {
                                v.add(0.0);
                            }
                        }
                        v.add(index, score);
                        _temp.put(w_n[0], v);
                    } else {
                        Vector<Double> v = new Vector<Double>();
                        for (int i = 0; i < index; i++) {
                            v.add(0.0);
                        }
                        v.add(index, score);
                        _temp.put(w_n[0], v);
                    }
                }
            }
            Set<String> temp = _temp.keySet();
            for (Iterator<String> iterator = temp.iterator(); iterator.hasNext();) {
                String word = (String) iterator.next();
                Vector<Double> v = _temp.get(word);
                double score = 0.0;
                double sum = 0.0;
                for (int i = 0; i < v.size(); i++) {
                    score += ((double) 1 / (double) (i + 1)) * v.get(i);
                }
                for (int i = 1; i <= v.size(); i++) {
                    sum += (double) 1 / (double) i;
                }
                score /= sum;

                _dict.put(word, score);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Double extract(String word) {
        Double total = new Double(0);
        if (_dict.get(word + "#n") != null) {
            total = _dict.get(word + "#n") + total;
        }
        if (_dict.get(word + "#a") != null) {
            total = _dict.get(word + "#a") + total;
        }
        if (_dict.get(word + "#r") != null) {
            total = _dict.get(word + "#r") + total;
        }
        if (_dict.get(word + "#v") != null) {
            total = _dict.get(word + "#v") + total;
        }

        return total;
    }

    public String StopWordsRemoval(String text) {
        StopWords sw = new StopWords();
        text = text.replaceAll("([^a-zA-Z0-9@'#\\s])", "");
        String[] termos = text.split(" ");
        List<String> stopWords = sw.getStopWords();
        String retorno = "";

        for (int i = 0; i < termos.length; i++) {
            for (int j = 0; j < stopWords.size(); j++) {
                if (termos[i].equals(stopWords.get(j))) {
                    termos[i] = "";
                }
            }
        }
        for (int i = 0; i < termos.length; i++) {
            retorno += termos[i] + " ";
        }
        return retorno.trim();
    }

    public Result classifytweet(String twit) {
        Result result = new Result();
        SWN3 _sw = new SWN3();
        String[] words = twit.split("\\s+");
        System.out.println(twit);
        double totalScore = 0, averageScore;
        for (String word : words) {

            if (_sw.extract(word) == null) {
                continue;
            }
            totalScore += _sw.extract(word);
        }

        averageScore = totalScore;
        result.setScore(averageScore);

        if (averageScore >= 0.75) {
            result.setSentimet("very positive");
        } else if (averageScore > 0.25 && averageScore <= 0.5) {
            result.setSentimet("positive");
        } else if (averageScore > 0 && averageScore >= 0.25) {
            result.setSentimet("weak positive");
        } else if (averageScore < 0 && averageScore >= -0.25) {
            result.setSentimet("weak negative");
        } else if (averageScore < -0.25 && averageScore >= -0.5) {
            result.setSentimet("negative");
        } else if (averageScore <= -0.75) {
            result.setSentimet("very negative");
        } else {
            result.setSentimet("neutral");
        }

        return result;
    }
}