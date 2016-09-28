/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 *
 * @author raul.aguiar
 */
public class ExportQuery {
    
    private File file = null;
    private FileOutputStream fos = null;
        
    public String GravarQuery(String Query){
        String texto = "";
        FileWriter csvArquivo = null;
   
        try {
            // Gravando no arquivo
            File arquivo;
            
            arquivo = new File("C:/Users/RaulFreire/Desktop/query.txt");
            FileOutputStream fos = new FileOutputStream(arquivo,true);
            csvArquivo = new FileWriter(arquivo,true);
            csvArquivo.write(UTF8toISO(Query.toString()) +"\n");
            csvArquivo.flush();
            
            csvArquivo.close();
            fos.close();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    
        return texto;
    }
    
    public static String UTF8toISO(String str){
        Charset utf8charset = Charset.forName("UTF-8");
        Charset iso88591charset = Charset.forName("UTF-8");

        ByteBuffer inputBuffer = ByteBuffer.wrap(str.getBytes());

        // decode UTF-8
        CharBuffer data = utf8charset.decode(inputBuffer);

        // encode ISO-8859-1
        ByteBuffer outputBuffer = iso88591charset.encode(data);
        
        byte[] outputData = outputBuffer.array();

        return new String(outputData);
    }
   
}
    

