/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeelogin;

import javax.swing.SwingUtilities;

/**
 *
 * @author AndrewYang
 */
public class EmployeeLogin implements Runnable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new EmployeeLogin());
        
        
    }

    @Override
    public void run() {
        new employeeLoginGUI().setVisible(true);
    }
    
}
