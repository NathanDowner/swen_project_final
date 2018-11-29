package backend;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * 
 */
public class Cost implements Serializable{

    private String costName;
    private double cost;
    private LocalDateTime dateIncurred;
    private static String dtfString = "dd/MM/yyyy HH:mm:ss";

    public Cost(String costName, double cost) {
        this.costName = costName;
        this.cost = cost;
        this.dateIncurred = LocalDateTime.now();
    }

    public Cost() {
    }

    public String getCostName() {
        return costName;
    }
    
    public String getDateIncurredAsString() {
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dtfString);
    	return dtf.format(dateIncurred);
    }

    public void setCostName(String costName) {
        this.costName = costName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public LocalDateTime getDateIncurred() {
        return dateIncurred;
    }

    public String toString() {
        return getDateIncurredAsString()+
                "	"+costName + "	"+ cost;
    }
}