
import java.util.*;

/**
 * 
 */
public class Template {

    private String title;
    private String filePath;
    private ArrayList<String> caseTypes;

    public Template(String title, String filePath, ArrayList<String> caseTypes) {
        this.title = title;
        this.filePath = filePath;
        this.caseTypes = caseTypes;
    }

    public Template() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<String> getCaseTypes() {
        return caseTypes;
    }

    public void setCaseTypes(ArrayList<String> caseTypes) {
        this.caseTypes = caseTypes;
    }
}