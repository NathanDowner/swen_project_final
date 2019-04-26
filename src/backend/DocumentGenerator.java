/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import backend.utils.DateUtil;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 * The Document Generator facilitates reading a word document with variables formatted as ${varname} and creates another document with the variables replaced with actual values.
 * All functionality of this class is accessed via the static generateDoc() method
 * @author Nathaniel
 * 
 */
public class DocumentGenerator {
    String tempfilename,docfilename;
    XWPFDocument template, doc;
    
    /**
     * This method prompts the user to select a template docx on the system, the desired name of the new document, and attempts to generate a document with variables in the template docx filled out with client data.
     * @param c a Client object with a case.
     * @throws IOException
     * @throws InvalidFormatException
     */
    public static void generateDoc(Client c) throws IOException, InvalidFormatException{
        String tempfilename = null,docfilename = null;
        XWPFDocument template, doc;
        JFileChooser window = new JFileChooser();
        int returnValue = window.showOpenDialog(null);
        
        if(returnValue == JFileChooser.APPROVE_OPTION) {
            tempfilename = window.getSelectedFile().getAbsolutePath();            
        }
        
        docfilename = JOptionPane.showInputDialog("Enter New Document Filename:") + ".docx";
        
        doc = new XWPFDocument(OPCPackage.open(tempfilename));
        
        for (XWPFParagraph p : doc.getParagraphs()){
            for (XWPFRun r : p.getRuns()){
                String text = r.getText(0);
                String search = "${date}";
                if (text != null && text.contains(search)){
                    text = text.replace(search,DateUtil.today());
                    r.setText(text, 0);
                }
                search = "${firstname}";
                if (text != null && text.contains(search)){
                    text = text.replace(search,c.getFname());
                    r.setText(text, 0);
                }
                search = "${lastname}";
                if (text != null && text.contains(search)){
                    text = text.replace(search,c.getLname());                    
                    r.setText(text, 0);
                }
                search = "${casetype}";
                if (text != null && text.contains(search)){
                    text = text.replace(search,c.getCases().get(0).getCaseType().toString());
                    //text = text.replace(search,"Conveyancing");
                    r.setText(text, 0);
                }
                search = "${caseSdate}";
                if (text != null && text.contains(search)){
                    text = text.replace(search,c.getCases().get(0).getStartDate().toString());
                    //text = text.replace(search,"[need date fam]");
                    r.setText(text, 0);
                }
                search = "${occupation}";
                if (text != null && text.contains(search)){
                    text = text.replace(search,c.getOccupation());                    
                    r.setText(text, 0);
                }
                search = "${email}";
                if (text != null && text.contains(search)){
                    text = text.replace(search,c.getEmail());
                    r.setText(text, 0);
                }
            }
        }
        
        doc.write(new FileOutputStream(docfilename));
    }
}
