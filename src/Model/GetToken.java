/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;
import Model.Credenciais;
import twitter4j.auth.AccessToken;
import twitter4j.examples.oauth.GetAccessToken;
/**
 *
 * @author RaulFreire
 */
public class GetToken {
    

public static void main (String[] args) throws Exception{        

        Credenciais c = new Credenciais();
    
        Twitter twitter = new TwitterFactory().getInstance();
        twitter.setOAuthConsumer(c.getCONSUMER_KEY(), c.getCONSUMER_SECRET());
        
        
        //twitter.getAuthorization();
        
        RequestToken requestToken = twitter.getOAuthRequestToken();
        AccessToken accessToken = null;
        

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (null == accessToken) {
            System.out.println("Abra o seguinte URL para conceder acesso a sua conta:");
            System.out.println(requestToken.getAuthorizationURL());
            System.out.print("Digite o numero PIN (se disponível) ou simplesmente pressione Enter [PIN]:");

            String pin = br.readLine();

            try {

                if (pin.length() > 0) {
                    accessToken = twitter.getOAuthAccessToken(requestToken, pin);
                } else {
                    accessToken = twitter.getOAuthAccessToken();
                }

            } catch (TwitterException e) {
                if (401 == e.getStatusCode()) {
                    System.err.println("Não foi possível obter o token de acesso.");

                } else {
                    e.printStackTrace();
                }
            }
        } 

        System.out.println("Token de acesso: " + accessToken.getToken());
        System.out.println("Token secreto de acesso: " + accessToken.getTokenSecret());
    }
}
