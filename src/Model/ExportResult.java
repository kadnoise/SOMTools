package Model;
import java.awt.HeadlessException;
import java.awt.Label;
import java.io.*;
import java.util.List;
import javax.swing.JFileChooser;
import view.SentimentAnalysis;
/**
 *
 * @author SentiWord
 */
public class ExportResult {
    private File file = null;
    private FileOutputStream fos = null;
        
    
    public void GravarSentiment(String destino, String text, String twit, String score){
        FileWriter csvArquivo = null;
        try {
            // Gravando no arquivo
            File arquivo;

            arquivo = new File(destino);
            FileOutputStream fos = new FileOutputStream(arquivo,true);
            csvArquivo = new FileWriter(arquivo,true);
            csvArquivo.write(text.toString()+";"+twit.toString()+";"+score.toString()+"\n");
            csvArquivo.flush();
            csvArquivo.close();
            fos.close();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    
        //return texto;
    }
   

}