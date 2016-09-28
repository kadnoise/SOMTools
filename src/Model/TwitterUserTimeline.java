package Model;

import twitter4j.auth.OAuthAuthorization;
import twitter4j.conf.ConfigurationBuilder;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import twitter4j.*;
import view.SentimentAnalysis;


public class TwitterUserTimeline {
    
    public static void main(String[] args) {


        GetUser("@SarcasmBeatsAll");

    }

 public static void GetUser(String User) {
        
        Credenciais c = new Credenciais();
        
        String CONSUMER_KEY = c.getCONSUMER_KEY();
        String CONSUMER_SECRET = c.getCONSUMER_SECRET();

        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.setOAuthAccessToken(c.getACCESS_TOKEN());
        builder.setOAuthAccessTokenSecret(c.getACCESS_TOKEN_SECRET());
        builder.setOAuthConsumerKey(CONSUMER_KEY);
        builder.setOAuthConsumerSecret(CONSUMER_SECRET);
        OAuthAuthorization auth = new OAuthAuthorization(builder.build());

        Twitter twitter = new TwitterFactory().getInstance(auth);
               
        
        try {

            //twitter.updateStatus("..");
            
            //List<Status> statuses = twitter.getUserTimeline(new Paging(1,3200));
            List<Status> statuses = twitter.getUserTimeline(User, new Paging(1, 250));
            System.out.println("Showing User timeline.");
            
                for (Status status : statuses) {
                    System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText() +" - "+ status.getCreatedAt().toString());  
            
            ExportTimeline time = new ExportTimeline();
            time.GravarTimeline("@" + status.getUser().getScreenName() + " - " + status.getText());
            }

        } catch (TwitterException e) {
            
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
            System.out.println("Failed to get timeline: " + e.getMessage());
            System.clearProperty(User);

            return;

        }

        System.out.println("Successfully updated the status.");

}
 

}


