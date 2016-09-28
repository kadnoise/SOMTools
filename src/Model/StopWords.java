/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.util.ArrayList;
import java.util.List;

public class StopWords {   
        
        private String Arquivo = "C:/stopWords.txt";        
        
        private FileInputStream file = null;  
        private BufferedReader in = null;  
        private String words = null; 

    public List<String> getStopWords() {
        
        List<String> stopWords = new ArrayList<String>(); 
        
        try {  
  
            file = new FileInputStream(Arquivo);  
  
            in = new BufferedReader(new InputStreamReader(file));  
  
            // IOException  
            while (in.ready()) {  
                // IOException  
                words = in.readLine();  
  
                if (words == null) {  
                    break;  
                }  
  
                words = words.trim();  
  
                if (words.length() != 0) {
                   stopWords.add(words);
                 }    
            }                   
            // IOException  
            file.close();  
  
            // IOException  
            in.close();   
        }
            catch (IOException e) {  
            System.out.println("Erro durante a leitura do arquivo ...");  
            System.exit(1);  
        }         
        return stopWords;
    }   
}
 
    
  
