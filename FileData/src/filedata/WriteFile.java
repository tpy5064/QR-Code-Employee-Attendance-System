/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filedata;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 *
 * @author AndrewYang
 */
public class WriteFile {
    
    private String path;
    private boolean appendToFile = false;
    
    public WriteFile(String filePath) {
        path = filePath;
    }
    
    public WriteFile(String filePath, boolean appendValue) {
        path = filePath;
        appendToFile = appendValue;
    }
    
    public void writeToFile(String textLine) throws IOException {
        
        FileWriter write = new FileWriter(path, appendToFile);
        PrintWriter printLine = new PrintWriter(write);
        
        printLine.printf("\n" + textLine);
        
        printLine.close();
    }
    
}
