package JDBackend;

import java.util.*;
import java.io.*;

public class User implements Comparable{
    
    private String username, password, fName, lName;
    
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    public User(String username, String password, String fName, String lName){
        this.username = username;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public String getFullName() {
    	return this.fName + " " + this.lName;
    }
    
    public String getFName() {
    	return this.fName;
    }
    
    @Override
    public int compareTo(Object o){
        if(username.equals(((User)o).getUsername()) && password.equals(((User)o).getPassword())){
            return 0;
        }
        else if(username.equals(((User)o).getUsername())){
            return 1;
        }
        else{
            return -1;
        }
    }
}