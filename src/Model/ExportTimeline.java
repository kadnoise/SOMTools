package Model;
import java.awt.HeadlessException;
import java.awt.Label;
import java.io.*;
import java.util.List;
import javax.swing.JFileChooser;
/**
 *
 * @author SentiWord
 */
public class ExportTimeline {
    private File file = null;
    private FileOutputStream fos = null;
        
    public String GravarTimeline(String Timeline){
        String texto = "";
        FileWriter csvArquivo = null;
   
        try {
            // Gravando no arquivo
            File arquivo;
            
            arquivo = new File("C:/Users/RaulFreire/Desktop/Timeline.txt");
            FileOutputStream fos = new FileOutputStream(arquivo,true);
            csvArquivo = new FileWriter(arquivo,true);
            csvArquivo.write(Timeline.toString()+"\n");
            csvArquivo.flush();
            
            csvArquivo.close();
            fos.close();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    
        return texto;
    }
   
}