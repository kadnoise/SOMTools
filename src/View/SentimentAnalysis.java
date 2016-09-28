/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Model.*;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class SentimentAnalysis extends javax.swing.JFrame {
      
    SWN3 s = new SWN3();
    
    
    public SentimentAnalysis() {
        initComponents();
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupSW = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        PanelPrincipal = new javax.swing.JPanel();
        labelScore = new javax.swing.JLabel();
        bottonQuery = new javax.swing.JButton();
        labelTitle4 = new javax.swing.JLabel();
        labelTitleTweet4 = new javax.swing.JLabel();
        labelTitleScore4 = new javax.swing.JLabel();
        labelPrincipal4 = new javax.swing.JLabel();
        labelSentiment = new javax.swing.JLabel();
        twitText = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        TextTimeline = new javax.swing.JTextField();
        ButtonTimeline = new javax.swing.JButton();
        labelTitleTweet5 = new javax.swing.JLabel();
        labelTitle7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Arquivo = new javax.swing.JLabel();
        bottonQueryA = new javax.swing.JButton();
        buttonSelecione = new javax.swing.JButton();
        labelCaminho = new javax.swing.JLabel();
        RadioComSW = new javax.swing.JRadioButton();
        RadioSemSW = new javax.swing.JRadioButton();
        labelTitle8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ASTool - Sentiment Analysis");
        setBounds(new java.awt.Rectangle(0, 0, 885, 260));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);
        setName("framePrincipal"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PanelPrincipal.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        PanelPrincipal.setDoubleBuffered(false);
        PanelPrincipal.setEnabled(false);
        PanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PanelPrincipal.add(labelScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 170, 20));

        bottonQuery.setText("Query");
        bottonQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bottonQueryActionPerformed(evt);
            }
        });
        PanelPrincipal.add(bottonQuery, new org.netbeans.lib.awtextra.AbsoluteConstraints(458, 162, 75, -1));

        labelTitle4.setFont(new java.awt.Font("Segoe Script", 1, 24)); // NOI18N
        labelTitle4.setText("SOMTool : Sentiment Analysis");
        PanelPrincipal.add(labelTitle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        labelTitleTweet4.setText("Tweet or RT:");
        PanelPrincipal.add(labelTitleTweet4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 166, 85, -1));

        labelTitleScore4.setText("Score:");
        PanelPrincipal.add(labelTitleScore4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 40, -1));

        labelPrincipal4.setText("Sentiment:");
        PanelPrincipal.add(labelPrincipal4, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 223, -1, 25));
        PanelPrincipal.add(labelSentiment, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 223, 99, 25));

        twitText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twitTextActionPerformed(evt);
            }
        });
        PanelPrincipal.add(twitText, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 163, 336, -1));

        jTabbedPane2.addTab("Tweet", PanelPrincipal);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TextTimeline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextTimelineActionPerformed(evt);
            }
        });
        jPanel4.add(TextTimeline, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 207, -1));

        ButtonTimeline.setText("Query");
        ButtonTimeline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonTimelineActionPerformed(evt);
            }
        });
        jPanel4.add(ButtonTimeline, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 202, -1, -1));

        labelTitleTweet5.setText("Timeline:");
        jPanel4.add(labelTitleTweet5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 166, 85, -1));

        labelTitle7.setFont(new java.awt.Font("Segoe Script", 1, 24)); // NOI18N
        labelTitle7.setText("SOMTool : Sentiment Analysis");
        jPanel4.add(labelTitle7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        jTabbedPane2.addTab("Query U", jPanel4);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Arquivo.setText("Archive:");
        jPanel1.add(Arquivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 175, -1, -1));

        bottonQueryA.setText("Query");
        bottonQueryA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bottonQueryAActionPerformed(evt);
            }
        });
        jPanel1.add(bottonQueryA, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, -1, -1));

        buttonSelecione.setText("Select...");
        buttonSelecione.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSelecioneActionPerformed(evt);
            }
        });
        jPanel1.add(buttonSelecione, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 100, -1));
        jPanel1.add(labelCaminho, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 224, 390, -1));

        buttonGroupSW.add(RadioComSW);
        RadioComSW.setText("Com SW");
        jPanel1.add(RadioComSW, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, -1, -1));

        buttonGroupSW.add(RadioSemSW);
        RadioSemSW.setText("Sem SW");
        jPanel1.add(RadioSemSW, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, -1, -1));

        labelTitle8.setFont(new java.awt.Font("Segoe Script", 1, 24)); // NOI18N
        labelTitle8.setText("SOMTool : Sentiment Analysis");
        jPanel1.add(labelTitle8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        jTabbedPane2.addTab("Archive", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Orientadora: Leila Weitzel");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Orientando: Raul Freire e Fernando G. Rodriguez");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel3.setText("Ferramenta para Análise de Sentimento");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/sobre.png"))); // NOI18N
        jLabel4.setText("dddd");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 250));

        jTabbedPane2.addTab("About", jPanel2);

        jPanel3.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 280));
        jTabbedPane2.getAccessibleContext().setAccessibleName("Tweet");

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bottonQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bottonQueryActionPerformed
        
        Result r = s.classifytweet(s.StopWordsRemoval(twitText.getText().toLowerCase()));
        labelSentiment.setText(r.getSentimet());
        labelScore.setText(String.valueOf(r.getScore()));

        System.out.println(String.valueOf(r.getScore()));
        
    }//GEN-LAST:event_bottonQueryActionPerformed

    private void twitTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twitTextActionPerformed
    bottonQueryActionPerformed(null);
    }//GEN-LAST:event_twitTextActionPerformed

    private void bottonQueryAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bottonQueryAActionPerformed
    String destino = "";
    destino = SetDestino(); 
        if(RadioSemSW.isSelected()){
        String sw = "";
        String rt, tweet ="";
        
          String pathToWAY = labelCaminho.getText();           
          try{ 
          BufferedReader csv = new
          BufferedReader(new FileReader(pathToWAY));
          String line=""; 
          
          while ((line = csv.readLine()) != null) {
              if(line.contains("RT @")){
                  rt = line;
                  continue;                  
              }else{
                  tweet = line;
              }
           
          line.split("\t");
    
        sw = s.StopWordsRemoval(tweet.toLowerCase().toString());
        Result r = s.classifytweet(sw.toString());      

        ExportResult exp = new ExportResult();
        exp.GravarSentiment(destino, sw.toString(), r.getSentimet(), String.valueOf(r.getScore()));

        System.out.println(String.valueOf(r.getScore()));
          }
          }catch(Exception e){
        }  
  }
    if(RadioComSW.isSelected()){        
        String rt, tweet ="";
          String pathToWAY = labelCaminho.getText(); 
          
          try{ 
          BufferedReader csv = new
          BufferedReader(new FileReader(pathToWAY)); String line=""; 
          
          while ((line = csv.readLine()) != null) {
              if(line.contains("RT @")){
                  rt = line;
                  continue;                  
              }else{
                  tweet = line;
              }
           
          line.split("\t");
            
        Result r = s.classifytweet(tweet.toLowerCase());      

        ExportResult exp = new ExportResult();
        exp.GravarSentiment(destino, tweet.toString(), r.getSentimet(), String.valueOf(r.getScore()));

        System.out.println(String.valueOf(r.getScore()));
          } 
          }catch(Exception e){
        }  
      }
    else{
        JOptionPane.showMessageDialog(null, "Selecione");
    }
                  
    }//GEN-LAST:event_bottonQueryAActionPerformed

    private void buttonSelecioneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSelecioneActionPerformed
    
        String caminho="";
        
        JFileChooser arquivo = new JFileChooser();
        int retorno = arquivo.showOpenDialog(null);
        if(retorno == JFileChooser.APPROVE_OPTION)
        caminho = arquivo.getSelectedFile().getAbsolutePath();
        labelCaminho.setText(caminho);
        
    }//GEN-LAST:event_buttonSelecioneActionPerformed

    private void ButtonTimelineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonTimelineActionPerformed
    
   TwitterUserTimeline tw = new TwitterUserTimeline();
   
   try{
   tw.GetUser(String.valueOf(TextTimeline.getText()));
   
   } catch (Exception e) {    
       e.printStackTrace();
            System.out.println("Failed to get timeline: " + e.getMessage());
            System.exit(-1);   
   }
  TextTimeline.setText("");
    }//GEN-LAST:event_ButtonTimelineActionPerformed

    private void TextTimelineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextTimelineActionPerformed
        ButtonTimelineActionPerformed(null);
    }//GEN-LAST:event_TextTimelineActionPerformed

   public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SentimentAnalysis().setVisible(true);
                
            }
        });
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Arquivo;
    private javax.swing.JButton ButtonTimeline;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JRadioButton RadioComSW;
    private javax.swing.JRadioButton RadioSemSW;
    private javax.swing.JTextField TextTimeline;
    private javax.swing.JButton bottonQuery;
    private javax.swing.JButton bottonQueryA;
    private javax.swing.ButtonGroup buttonGroupSW;
    private javax.swing.JButton buttonSelecione;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel labelCaminho;
    private javax.swing.JLabel labelPrincipal4;
    private javax.swing.JLabel labelScore;
    private javax.swing.JLabel labelSentiment;
    private javax.swing.JLabel labelTitle4;
    private javax.swing.JLabel labelTitle7;
    private javax.swing.JLabel labelTitle8;
    private javax.swing.JLabel labelTitleScore4;
    private javax.swing.JLabel labelTitleTweet4;
    private javax.swing.JLabel labelTitleTweet5;
    private javax.swing.JTextField twitText;
    // End of variables declaration//GEN-END:variables

    public String SetDestino(){
        String caminho="";
        
        JFileChooser arquivo = new JFileChooser();
        int retorno = arquivo.showSaveDialog(null);
        if(retorno == JFileChooser.APPROVE_OPTION)
        caminho = arquivo.getSelectedFile().getAbsolutePath();
            
        return caminho;
}
}
