/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeetardiness;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author AndrewYang
 */
public class FileData {

    private static final String FILE_NAME = "./";

    public FileData() {
        // TODO code application logic here

    }

    public void readFile(String filename) throws IOException {
        try {
            ReadFile file = new ReadFile(filename);
            String[] aryLines = file.OpenFile();

            int i;
            for (i = 0; i < aryLines.length; i++) {
                System.out.println(aryLines[i]);
            }
        } catch (IOException e) {
            showMessage("IO Error!");
        }
    }
    /**
     * Creates new Employee file with the naming format: "Name_ID"
     * @param filename path of folder to write to
     * @param employeeID 
     * @param employeeName
     * @throws IOException for non-existent folders 
     */
    public void writeEmployeeDetails(String directory, String employeeID, String employeeName) throws IOException {

        try {
            String outputPath = directory;
            WriteFile data = new WriteFile(outputPath, true);
            data.writeToFile(employeeID + "\t" + employeeName + "\n");

        } catch (IOException e) {

            showMessage("IO Error!");
        }

    }
    
    /**
     * Deletes an employee at a given file directory
     * @param directory
     * @return
     * @throws FileNotFoundException 
     */
    public boolean delEmployee(String directory) throws FileNotFoundException {

        try {
            File file = new File(directory);

            if (file.delete()) {
                System.out.println("File has been deleted!");
                return true;

            } else {
                showMessage("This employee does not exist! Make sure you had entered "
                        + "his/her name and ID correctly!");

            }

        } catch (Exception e) {
            showMessage("Error deleting file!");
        }
        return false;
    }

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

    private void showMessage(String text) {
        JOptionPane.showMessageDialog(null, text);
    }
    
    
}
