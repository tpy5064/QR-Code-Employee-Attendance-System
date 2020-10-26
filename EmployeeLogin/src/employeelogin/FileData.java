/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeelogin;

import java.io.File;

/**
 *
 * @author AndrewYang
 */
public class FileData {
    
    private static final String FILE_NAME = "./";

    
    /**
     * Checks if an employee with the same ID as the one inputted exists
     * @param ID The ID in the form of a 6 digit number (String)
     * @return a boolean that determines whether the ID already exists
     */
    public boolean employeeExists(String ID) {
        File[] f = new File(FILE_NAME).listFiles();

        for (int i = 0; i < f.length; i++) {
            String fileName = f[i].getName();
            if (fileName.contains(ID)) {
                return true;
            }
        }
        return false;
    }
    
    public String getFolder() { return FILE_NAME; }
    
}
