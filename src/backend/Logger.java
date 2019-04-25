/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import backend.utils.DateUtil;
import backend.User;

/**
 *
 * @author Nathaniel
 * Logger is a singleton class that allows for event history to be written to a txt file.
 * 
 */
public class Logger {
    
    private final String filename = "JDActivityLog.txt";
    private static Logger log = new Logger();
    
    /**
     * Since Logger is a singleton class, the constructor is private. 
     * To get an instance of this class, use the getInstance() method
     */
    private Logger(){
    }

    public static Logger getInstance() {
        return log;
    }

    public void recordActivity(String info){
        info = DateUtil.today() + " " + info;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename,true));
            writer.append(info);
            writer.newLine();
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    public void recordActivity(User u, String info) {
        info = u.getUsername() + " " + info;
        recordActivity(info);
    }
    
    public ArrayList<String> getActivityLog(){
        ArrayList<String> actlog = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String data;
            while((data = reader.readLine()) != null){
                actlog.add(data);
            }
        } catch (Exception e) {
            System.out.println(e);
            actlog.add("File not found");
        }
        return actlog;
    }
    
    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//        Logger tester = Logger.getInstance();
//        tester.recordActivity("It's hot out here");
//        tester.recordActivity("I hope the breeze will pick up");
//        
//        for (String p :tester.getActivityLog()){
//            System.out.println(p);
//        }
//    }
    
}
