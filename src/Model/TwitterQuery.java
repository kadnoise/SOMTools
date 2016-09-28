package Model;

/**
 *
 * @author RaulFreire
 */
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import twitter4j.*;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterQuery {

    private static Twitter twitter;
    private static int cont = 0;
    private static final String ACCESS_TOKEN = "1222694389-*************************";
    private static final String ACCESS_TOKEN_SECRET = "***************************";

    public static void main(String[] args) {


        Pesquisa();

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

    public static void Pesquisa() {
        System.out.println("Entrou");

        try {
            Query query = new Query("#sarcasmprofile");
            query.count(10000);
            //query.setSince("2012-07-01");
            Imprime(query);
            System.exit(0);
        } catch (TwitterException e) {
            e.printStackTrace();
            System.out.println("Failed to search tweets: " + e.getMessage());
            System.exit(-1);
        }
    }

    public static void Imprime(Query query) throws TwitterException {
        Twitter twitter = getTweeter();
        QueryResult result;
        result = twitter.search(query);
        List<Status> tweets = result.getTweets();
        for (Status tweet : tweets) {
            boolean retweet = isRetweet(tweet.getText());
            if (!retweet) {
                cont++;
                //String target = getTarget(tweet.getText());
                System.out.println(cont + " - @" + tweet.getUser().getScreenName() + " - " + tweet.getText());
                //String text = tweet.getText().replaceAll("([^a-zA-Z0-9';:()/.#@\\s])", "");
                ExportQuery qy = new ExportQuery();
                qy.GravarQuery("@" + tweet.getUser().getScreenName() + " " + tweet.getText());

                //String text = tweet.getText().replaceAll("([^a-zA-Z0-9';/.#@\\s])", ""); //add para parser
            /*
                 * if (tweet.getText().contains("RT")) { //add para coletar
                 * apenas RT's ExportQuery qy = new ExportQuery();
                 * qy.GravarQuery("@" + tweet.getUser().getScreenName() + "; RT
                 * " + target + ";" + getHash(text) + ";" +
                 * tweet.getRetweetCount() + ";" + tweet.getId()); }
                 *
                 */
            }
        }

        if (result.hasNext()) {
            Imprime(result.nextQuery());
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

    //Método que retorna todas as hashtags presentes no texto
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
