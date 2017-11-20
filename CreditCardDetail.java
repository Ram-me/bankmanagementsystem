/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;
import java.util.*;
/**
 *
 * @author Hammad
 */
public class CreditCardDetail extends CardDetail {


    /**
     * 
     */
    private double creditlimit;

    /**
     * 
     */
    private double currentcredit;

    /**
     * @param cardType 
     * @param issueDate 
     * @param expiryDate 
     * @param CAC 
     * @param cardNumber 
     * @param creditlimit 
     * @param currentcredit
     * @param OwnedBy
     */
    public CreditCardDetail(double creditlimit, double currentcredit, String cardType, Date issueDate, Date expiryDate, String CAC, String cardNumber, Customer ownedBy) {
        super(cardType, issueDate, expiryDate, CAC, cardNumber, ownedBy);
        this.creditlimit = creditlimit;
        this.currentcredit = currentcredit;
    }

    /**
     * @return
     */
    public double getCreditlimit() {
        // TODO implement here
        return creditlimit;
    }

    /**
     * @return
     */
    public double getCurrentcredit() {
        // TODO implement here
        return currentcredit;
    }

    /**
     * @param value 
     * @param requester
     */
    public void setCurrentcredit(double value) {
        // TODO implement here
        this.currentcredit = currentcredit + value;
    }
}