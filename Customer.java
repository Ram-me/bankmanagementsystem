package backend;
import java.util.*;

/**
 * 
 */
public class Customer extends Person {

    private Checking checkingaccount;
    private Saving savingaccount;
    private ArrayList managedBy;
    private Locker locker;

    public Customer(Checking checkingaccount,Saving savingaccount, ArrayList managedBy, Locker locker, String cnic, String name, String email, String currentaddress, String residentialaddress, String mobilenumber, String telephonenumber) {
        super(cnic, name, email, currentaddress, residentialaddress, mobilenumber, telephonenumber);
        this.checkingaccount = checkingaccount;
        this.savingaccount = savingaccount;
        this.managedBy = managedBy;
        this.locker = locker;
    }

    public Checking getCheckingaccount() {
        return checkingaccount;
    }

    public void setCheckingaccount(Checking checkingaccount) {
        this.checkingaccount = checkingaccount;
    }

    public Saving getSavingaccount() {
        return savingaccount;
    }

    public void setSavingaccount(Saving savingaccount) {
        this.savingaccount = savingaccount;
    }



    public ArrayList getManagedBy() {
        return managedBy;
    }

    public void setManagedBy(ArrayList managedBy) {
        this.managedBy = managedBy;
    }

    public Locker getLocker() {
        return locker;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
    }


 
    /**
     * 
     */
    public void requestbankstatement() {
        // TODO implement here
    }

    /**
     * 
     */
    public void requestatmcard() {
        // TODO implement here
    }

    /**
     * 
     */
    public void requestcreditcard() {
        // TODO implement here
    }

    /**
     * 
     */
    public void requestlocker() {
        // TODO implement here
    }

    /**
     * 
     */
    public void requestcardextension() {
        // TODO implement here
    }

    /**
     * 
     */
    public void checkbalance() {
        // TODO implement here
    }

    /**
     * 
     */
    public void requestaccounttermination() {
        // TODO implement here
    }

    /**
     * 
     */
    public void requestloan() {
        // TODO implement here
    }

    /**
     * 
     */
    public void requestdirectdeposit() {
        // TODO implement here
    }

    /**
     * 
     */
    public void requestselfcheque() {
        // TODO implement here
    }

    /**
     * 
     */
    public void requestcrosscheque() {
        // TODO implement here
    }
}