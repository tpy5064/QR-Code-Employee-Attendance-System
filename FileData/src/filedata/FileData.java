/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filedata;

import java.io.IOException;

/**
 *
 * @author AndrewYang
 */
public class FileData {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        String fileName = "/Users/AndrewYang/Desktop/Andrew's Mess/test.txt";

        try {
            ReadFile file = new ReadFile(fileName);
            String[] aryLines = file.OpenFile();

            int i;
            for (i = 0; i < aryLines.length; i++) {
                System.out.println(aryLines[i]);
            }
        } catch (IOException e) {
            System.out.println("Sorry, there's a file format error!");
        }

        //Write to a File below:
        try {
            
            WriteFile data = new WriteFile(fileName, true);
            data.writeToFile("test1" + "\t" + "test 2");
            
        } catch (IOException e) {
            
            System.out.println("Text file written to.");
        }
    }

}
