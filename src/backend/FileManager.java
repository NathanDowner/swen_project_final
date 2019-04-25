/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.io.*;
import java.util.*;

/**
 * The FileManager class is used to load or save case and client data to specified files.
 * @author Nathaniel
 */
public class FileManager {
    private ArrayList<Case> caseData = new ArrayList<Case>();
    private ArrayList<Client> clientData = new ArrayList<Client>();
    
    /**
     * Creating a new FileManager loads all relevant data from files into the File Manager Object. This information can
     * be returned using the various getter methods;
     */
    public FileManager(){
        //loadData();
    }
    
    /**
     * This method saves case and client data to two text files. The method can be called without instantiating the class
     * @param caseList This is an ArrayList of cases to be saved to the cases file.
     * @param clientList This is an ArrayList of cases to be saved to the client file.
     * @return The function returns true if the lists were successfully saved, false otherwise.
     */
    public static boolean saveData(ArrayList<Case> caseList, ArrayList<Client> clientList){
    	System.out.println("Calling save data");
        try{
            FileOutputStream fos;
            ObjectOutputStream oos;
            String fileName;
            //Saving the ABMCard List
            
            //Saving the Personal Client List
            try{
                fileName = "cases.txt";
                fos = new FileOutputStream(fileName);
                oos = new ObjectOutputStream(fos);
                oos.writeObject(caseList);
                oos.close();
            } catch(Exception e) {System.out.println("Case List not saved");}
            
            //Saving the Business Client List
            try{
                fileName = "clients.txt";
                fos = new FileOutputStream(fileName);
                oos = new ObjectOutputStream(fos);
                oos.writeObject(clientList);
                oos.close();
            } catch(Exception e) {System.out.println("Client List not saved");}            
            return true;
        } catch (Exception ex) {
            System.out.println("Data Not Saved");
            return false;
        }
    }
    
    /**
     * Calling this method causes the File Manager to load case and client data from 
     * the file and store it within the File Manager object list.
     * @return Returns true if the data was successfully loaded, false otherwise.
     */
    public boolean loadData(){
        try{
            ObjectInputStream ois;
            FileInputStream fin;
            String fileName;
            
            //Loading the Case List
            try{
                fileName = "cases.txt";
                fin = new FileInputStream(fileName);
                ois = new ObjectInputStream(fin);
                caseData = (ArrayList<Case>) ois.readObject();
                ois.close();
            } catch (Exception e){
            	System.out.println("Could not load Case List");
            	return false;
            }
            
            //Loading the Client List
            try{
                fileName = "clients.txt";
                fin = new FileInputStream(fileName);
                ois = new ObjectInputStream(fin);
                clientData = (ArrayList<Client>) ois.readObject();
                ois.close();
            } catch (Exception e){System.out.println("Could not load Client List");}
            
            return true;
        } catch (Exception ex) {
            System.out.println("Failed to load Data");
            return false;
        }
    }
    
    /**
     * This function returns the case list stored in the file manager. Note, the
     * loadData() method must be called first for the file manager to have data.
     * @return Returns the list of cases stored in the file manager.
     */
    public ArrayList<Case> getCases(){
        return caseData;
    }
    
    /**
     * This function returns the client list stored in the file manager. Note, the
     * loadData() method must be called first for the file manager to have data.
     * @return Returns the list of clients stored in the file manager.
     */
    public ArrayList<Client> getClients(){
        return clientData;
    }
}
