package backend;
import java.util.*;

/**
 * 
 */
public class Cashier extends Employee {

    public ArrayList ApprovedBy;

    public Cashier(int ssn, String designation, DepartmentType department, Double salary, LoginDetail credentials, Branch worksIn, String cnic, String name, String email, String currentaddress, String residentialaddress, String mobilenumber, String telephonenumber) {
        super(ssn, designation, department, salary, credentials, worksIn, cnic, name, email, currentaddress, residentialaddress, mobilenumber, telephonenumber);
    }

    /**
     * @param accountnumber 
     * @param deposit 
     * @return
     */
    public Boolean aprrovedirectdeposit(String accountnumber, DirectDeposit deposit) {
        // TODO implement here
        return null;
    }

    /**
     * @param accountnumber 
     * @param enter 
     * @return
     */
    public Boolean approveselfcheque(String accountnumber, SelfCheque enter) {
        // TODO implement here
        return null;
    }

    /**
     * @param ammount 
     * @param currencybought 
     * @param currencysold 
     * @return
     */
    public Boolean convertcurrencyt(double ammount, String currencybought, String currencysold) {
        // TODO implement here
        return null;
    }

    /**
     * @param sender 
     * @param receiver 
     * @param enter 
     * @return
     */
    public Boolean approvecrosscheque(String sender, String receiver, CrossCheque enter) {
        // TODO implement here
        return null;
    }

    /**
     * @param accountnumber 
     * @return
     */
    public double checkbalance(String accountnumber) {
        // TODO implement here
        return 0.0d;
    }

    /**
     * @param accountnumber 
     * @param cnic 
     * @param start 
     * @param last 
     * @return
     */
    public ArrayList getBankStatement(String accountnumber, String cnic, Date start, Date last) {
        // TODO implement here
        return null;
    }

}