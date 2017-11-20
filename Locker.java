package backend;
import java.util.*;
/**
 * 
 */
public class Locker {

    private String lockernumber;
    private Boolean isoccupied;
    private double length;
    private double width;
    private double height;
    private int floornumber;
    private String wingnumber;
    private double lockerfee;
    public Branch FoundIn;

    public Locker(String lockernumber, Boolean isoccupied, double length, double width, double height, int floornumber, String wingnumber, double lockerfee, Branch FoundIn) {
        this.lockernumber = lockernumber;
        this.isoccupied = isoccupied;
        this.length = length;
        this.width = width;
        this.height = height;
        this.floornumber = floornumber;
        this.wingnumber = wingnumber;
        this.lockerfee = lockerfee;
        this.FoundIn = FoundIn;
    }


    /**
     * @return
     */
    public double computeLockerFee() {
        return length*width*height*lockerfee;
    }

    public String getLockernumber() {
        return lockernumber;
    }

    public void setLockernumber(String lockernumber) {
        this.lockernumber = lockernumber;
    }

    public Boolean getIsoccupied() {
        return isoccupied;
    }

    public void setIsoccupied(Boolean isoccupied) {
        this.isoccupied = isoccupied;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getFloornumber() {
        return floornumber;
    }

    public void setFloornumber(int floornumber) {
        this.floornumber = floornumber;
    }

    public String getWingnumber() {
        return wingnumber;
    }

    public void setWingnumber(String wingnumber) {
        this.wingnumber = wingnumber;
    }

    public double getLockerfee() {
        return lockerfee;
    }

    public void setLockerfee(double lockerfee) {
        this.lockerfee = lockerfee;
    }

    public Branch getFoundIn() {
        return FoundIn;
    }

    public void setFoundIn(Branch FoundIn) {
        this.FoundIn = FoundIn;
    }



}