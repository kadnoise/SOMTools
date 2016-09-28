package Model;

/**
 *
 * @author RaulFreire
 */
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import twitter4j.*;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.examples.tweets.RetweetStatus;
import java.util.StringTokenizer;
import java.util.logging.Level;

public class TwitterQueryRT {

    private static Twitter twitter;
    private static int cont = 0;
    private static final String ACCESS_TOKEN = "1222694389-**************************";
    private static final String ACCESS_TOKEN_SECRET = "****************************************";

    public static void main(String[] args) throws HeadlessException, FileNotFoundException, IOException {


        SearchRt("lawyer");

    }

    public static Twitter getTweeter() {

        if (twitter != null) {
            return twitter;
        }

        Credenciais c = new Credenciais();

        String CONSUMER_KEY = c.getCONSUMER_KEY();
        String CONSUMER_SECRET = c.getCONSUMER_SECRET();

        ConfigurationBuilder builder = new ConfigurationBuilder();

        builder.setOAuthAccessToken(ACCESS_TOKEN);

        builder.setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);

        builder.setOAuthConsumerKey(CONSUMER_KEY);

        builder.setOAuthConsumerSecret(CONSUMER_SECRET);

        OAuthAuthorization auth = new OAuthAuthorization(builder.build());

        Twitter twitter = new TwitterFactory().getInstance(auth);


        return twitter;
    }
    public static String absolutePath = null;

    private static void SearchRt(String buscarText) throws HeadlessException, FileNotFoundException, IOException {
        //cra a caixa de dialogo para salvar o arquivo       

        StringBuffer dados = new StringBuffer();
        List<Status> lt = busca("RT #" + buscarText);
        int id = 0;
        for (Status t : lt) {
            id++;
            System.out.println("Source: " + t.getSource());
            System.out.println("Tweet by: @" + t.getUser().getScreenName() + " " + t.getText());
            System.out.println("Source Id: " + t.getId());
            System.out.println("RT Count:" + t.getRetweetCount());
//          System.out.println("RT?:" + t.isRetweet());
            String target = getTarget(t.getText());
            //Filtra apenas retuites
            boolean retweet = isRetweet(t.getText());
            String text = t.getText().replaceAll("([^a-zA-Z0-9';/.#@\\s])", "");
            System.out.println("-------------");

            ExportQuery qy = new ExportQuery();
            qy.GravarQuery("@" + t.getUser().getScreenName() + ";" + " RT " + "@" + target + ";" + getHash(text) + ";" + t.getRetweetCount() + ";" + text);
        }
        JOptionPane.showMessageDialog(null, "Arquivo gravado com sucesso!!!");
    }

    /*
     * public static void Pesquisa() { System.out.println("Entrou");
     *
     * try { Query query = new Query("#sarcasm"); query.count(10000);
     * //query.setSince("2012-07-01"); Imprime(query); System.exit(0); } catch
     * (TwitterException e) { e.printStackTrace(); System.out.println("Failed to
     * search tweets: " + e.getMessage()); System.exit(-1); } }
     *
     * public static void Imprime(Query query) throws TwitterException { Twitter
     * twitter = getTweeter(); QueryResult result; result =
     * twitter.search(query); List<Status> tweets = result.getTweets(); for
     * (Status tweet : tweets) { cont++; System.out.println(cont + " - @" +
     * tweet.getUser().getScreenName() + " - " + tweet.getText());
     *
     * ExportQuery qy = new ExportQuery(); qy.GravarQuery("@" +
     * tweet.getUser().getScreenName() + " - " + tweet.getText()); } if
     * (result.hasNext()) { Imprime(result.nextQuery()); } }
     *
     */
    public static List<Status> busca(String busca) {
        Twitter twit = getTweeter();
        QueryResult result = null;
        Query q = new Query(busca);
        //q.setSince("2001-01-03");       
        q.count(10000);
        try {
            result = twit.search(q);
        } catch (TwitterException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        }
        
        return result.getTweets();
    }

    public static String getTarget(String text) {
        String target = null;
        int begin = text.indexOf("@");
        String b = text.substring(begin + 1);
        System.out.println(b);
        int c = b.indexOf(" ");
        //verifica se o target está no final do tweet;
        if (c != -1) {
            //se nao tiver no final trata para exibir apenas o nome;
            String d = b.substring(0, c);
            int e = d.indexOf(":");
            //verifica se apos o target tem : ou " ";
            if (e != -1) {
                //se encontrar ":" exibe o usuario sem ele;
                target = d.substring(0, e);
                return target;
            } else {
                //senao encontrar é pq tem " " do que ":";
                return d;
            }
        } else {
            //se o nome do target estiver no final do tweet exibe o nome;
            return b;
        }
    }

    public static boolean isRetweet(String tweet) {
        int begin = tweet.indexOf("RT");
        if (begin == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static String getHash(String twit) {
        List<String> token = new ArrayList<String>();
        String hash = "";

        StringTokenizer line = new StringTokenizer(twit); //tokeniza toda a linha

        while (line.hasMoreTokens()) {  //enquanto estiver palavras
            token.add(line.nextToken()); //adiciona palavra por palavra no List
        }

        //condição que verifica se palavra tem como indice '#'
        for (int i = 0; i < token.size(); i++) {
            if (token.get(i).contains("#")) {
                hash += token.get(i) + " ";
            }
        }
        return hash;
    }
}
