package tugas5;

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Asus
 */
public class Tugas5Controller  {
    private Tugas5 view;
     private List<Integer> list = new ArrayList<>();

     public Tugas5Controller(Tugas5 view) {
         this.view = view;
         this.view.getBtBaca().addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 proses();
             }
         });
          this.view.getBtSimpan().addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 save();
             }
         });
     }
     private void proses() {
         JFileChooser loadFile = view.getLoadFile();
         StyledDocument doc = view.getTxtPane().getStyledDocument();
         if (JFileChooser.APPROVE_OPTION == loadFile.showOpenDialog(view)) {
             BufferedReader reader = null;
            try{
                    int desimal; 
                    char ascii;
                    String line = null;

                    int wordCount = 0;
                    int charCount = 0;
                    
                    LineNumberReader numReader = new LineNumberReader(new FileReader(loadFile.getSelectedFile()));
                    LineNumberReader inputStream = new LineNumberReader(new FileReader(loadFile.getSelectedFile()));
                    
                    reader = new BufferedReader(new FileReader(loadFile.getSelectedFile()));
                    
                    String data = null;
                    doc.insertString(0, "", null);
                    while((data = reader.readLine()) != null){
                        doc.insertString(doc.getLength(), data, null);
                        doc.insertString(doc.getLength(), "\n", null);
                    }

                    while((desimal = inputStream.read()) != -1){
                        ascii = (char) desimal;
                    }

                    while((line = numReader.readLine()) != null){
                        String[] wordList = line.split("\\s");
                        wordCount += wordList.length;
                        charCount += line.length();
                    }

                    JOptionPane.showMessageDialog(view, "Data berhasil dibaca" +
                            "\nJumlah baris     :" + (inputStream.getLineNumber() + 1) +
                            "\nJumlah kata      :" + (wordCount) +
                            "\nJumlah karakter  :" + (charCount), "Informasi", JOptionPane.INFORMATION_MESSAGE);

             } catch (FileNotFoundException ex) {
                 Logger.getLogger(Tugas5Controller.class.getName()).log(Level.SEVERE, null, ex);
             } catch (IOException | BadLocationException ex) {
                 Logger.getLogger(Tugas5Controller.class.getName()).log(Level.SEVERE, null, ex);
             } finally {
                 if (reader != null) {
                     try {
                         reader.close();
                     } catch (IOException ex) {
                         Logger.getLogger(Tugas5Controller.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
             }
         }
        
     }
     private void save() {
         JFileChooser loadFile = view.getLoadFile();
         if (JFileChooser.APPROVE_OPTION == loadFile.showSaveDialog(view)) {
             BufferedWriter writer = null;
             try {
                 String contents = view.getTxtPane().getText();
                 if (contents != null && !contents.isEmpty()) {
                     writer = new BufferedWriter(new FileWriter(loadFile.getSelectedFile()));
                     writer.write(contents);
                 }

             } catch (FileNotFoundException ex) {
                 Logger.getLogger(Tugas5Controller.class.getName()).log(Level.SEVERE, null, ex);
             } catch (IOException ex) {
                 Logger.getLogger(Tugas5Controller.class.getName()).log(Level.SEVERE, null, ex);
             } finally {
                 if (writer != null) {
                     try {
                         writer.flush();
                         writer.close();
                         view.getTxtPane().setText("");
                     } catch (IOException ex) {
                         Logger.getLogger(Tugas5Controller.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
             }
         }
         JOptionPane.showMessageDialog(null, "Data Anda Berhasil Disimpan");
     }
     
     }
     


