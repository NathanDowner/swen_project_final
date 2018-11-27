
import java.util.*;

/**
 * 
 */
public class Cost {

    private String costName;
    private double cost;
    private Date dateIncurred;

    public Cost(String costName, double cost, Date dateIncurred) {
        this.costName = costName;
        this.cost = cost;
        this.dateIncurred = dateIncurred;
    }

    public Cost() {
    }

    public String getCostName() {
        return costName;
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

    public Date getDateIncurred() {
        return dateIncurred;
    }

    public void setDateIncurred(Date dateIncurred) {
        this.dateIncurred = dateIncurred;
    }

    public String toString() {
        return "Cost{" +
                "costName='" + costName + '\'' +
                ", cost=" + cost +
                ", dateIncurred=" + dateIncurred +
                '}';
    }
}