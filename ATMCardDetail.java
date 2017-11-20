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
public class ATMCardDetail extends CardDetail {


    /**
     * 
     */
    private int pincode;

    /**
     * 
     */



    /**
     * @param cardType 
     * @param issueDate 
     * @param expiryDate 
     * @param CAC 
     * @param cardNumber 
     * @param pincode
     */
    public ATMCardDetail(int pincode, String cardType, Date issueDate, Date expiryDate, String CAC, String cardNumber, Customer ownedBy) {
        super(cardType, issueDate, expiryDate, CAC, cardNumber, ownedBy);
        this.pincode = pincode;
    }

    /**
     * @return
     */
    public int getPincode() {
        // TODO implement here
        return pincode;
    }

    /**
     * @param value 
     * @param requester
     */
    public void setPincode(int value) {
        // TODO implement here
        this.pincode = value;
    }
}