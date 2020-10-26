/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeetardiness;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author AndrewYang
 */
public class TimeManager {
    
    private Date d1;
    private Date d2;
    private static final String LOGIN_TIME = "09:00:00";
    
    /**
     * Calculates the difference of time in 2 timestamps, as the conversion 
     * between hours and minutes does not change, it can be hard-coded
     * @param in
     * @param out
     * @return
     * @throws Exception 
     */
    public String calcDiff(String in, String out) throws Exception{
        
        d1 = new SimpleDateFormat("HH:mm:ss").parse(in);
        d2 = new SimpleDateFormat("HH:mm:ss").parse(out);
        
        long diff = d2.getTime() - d1.getTime();
        
        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / 60000 % 60;
        long diffHours = diff / 3600000 % 24;
        
        if (diffSeconds >= 0 || diffMinutes >= 0 || diffHours >=0){
        return diffHours + " Hours " + diffMinutes + " Minutes " + diffSeconds + " Seconds";
        } else {
            return " 0 Hours 0 Minutes 0 Seconds";
        }
    }
    
    //The standard login time must be protected
    public String getLoginTime() { return LOGIN_TIME; }
    
}
