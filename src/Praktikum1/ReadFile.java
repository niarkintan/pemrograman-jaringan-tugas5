package Praktikum1;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class ReadFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int desimal;
             char ascii = 0;

          try {

            System.out.println("Masukkan file: ");
            String namaFile = sc.nextLine(); 
            
            File file = new File(namaFile);
            
            if(file.exists()) {
                LineNumberReader inputStream = new LineNumberReader(new FileReader(file));
             while ((desimal = inputStream.read()) != -1) {
                 ascii = (char) desimal;
                 System.out.println("" + ascii + " at line " + inputStream.getLineNumber());
                 
             }
            } else {
                System.out.println("File tidak ada");
            }
 
                 BufferedReader reader = new BufferedReader(new FileReader(file));
                 LineNumberReader inputStream = new LineNumberReader(new FileReader(file));
                    int lines = 0;
                    while (reader.readLine() != null) lines++;
                    reader.close();
                        System.out.println("\nJumlah Baris: " + lines); 
                
            
            System.out.println("Masukkan karakter: ");
            String kar= sc.nextLine(); 
            
              System.out.println("karakter " + kar + " ada di baris :" + inputStream.getLineNumber());
         } 

          catch (FileNotFoundException ex) {
             Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}

    

