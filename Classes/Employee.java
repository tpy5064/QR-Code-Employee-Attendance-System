import java.util.HashMap;

/**
 * Write a description of class Employee here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Employee
{
    // instance variables - replace the example below with your own
    private HashMap<String, String> employees;
    private String name;
    private String position;
    

    /**
     * Constructor for objects of class Employee
     */
    public Employee(String name, String position)
    {
        // initialise instance variables
        this.name = name;
        this.position = position;
        employees = new HashMap<String, String>();
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public String getEmployeeName()
    {
        for (String eName : employees.keySet()) {
            name = eName;
        }
        return name;
    }
    
    public String getEmployeePosition() {
        return position;
    }
}
