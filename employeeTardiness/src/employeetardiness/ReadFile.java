/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeetardiness;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author AndrewYang
 */
public class ReadFile {

    private String path;

    public ReadFile(String filePath) {
        path = filePath;
    }

    public String[] OpenFile() throws IOException {
        FileReader fr = new FileReader(path);
        BufferedReader textReader = new BufferedReader(fr);

        int numberOfLines = readLines();
        String[] textData = new String[numberOfLines];

        int i;

        for (i = 0; i < numberOfLines; i++) {
            textData[i] = textReader.readLine();
        }

        textReader.close();
        return textData;
    }

    int readLines() throws IOException {
        FileReader fileToRead = new FileReader(path);
        BufferedReader br = new BufferedReader(fileToRead);

        String aLine;
        int numberOfLines = 0;

        while ((aLine = br.readLine()) != null) {
            numberOfLines++;
        }
        br.close();

        return numberOfLines;
    }
    
    
}
