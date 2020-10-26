/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeetardiness;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
    
    
    /**
     * Creates a new employee file if there are no ID 
     * @param textLine
     * @throws IOException 
     */
    public void writeToFile(String textLine) throws IOException {
        
        FileWriter write = new FileWriter(path, appendToFile);
        PrintWriter printLine = new PrintWriter(write);
        
        printLine.printf(textLine + "\n");
        
        printLine.close();
    }
}
