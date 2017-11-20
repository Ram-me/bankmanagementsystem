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
public abstract class CardDetail {

  

    /**
     * 
     */
    protected String cardType;

    /**
     * 
     */
    protected Date issueDate;

    /**
     * 
     */
    protected Date expiryDate;

    /**
     * 
     */
    protected String CAC;

    /**
     * 
     */
    protected String cardNumber;
    
    protected Customer ownedBy;



    /**
     * @param cardType 
     * @param issueDate 
     * @param expiryDate 
     * @param CAC 
     * @param cardNumber
     */
    public CardDetail(String cardType, Date issueDate, Date expiryDate, String CAC, String cardNumber, Customer ownedBy) {    
        this.cardType = cardType;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
        this.CAC = CAC;
        this.cardNumber = cardNumber;
        this.ownedBy = ownedBy;
    }

    public Customer getOwnedBy() {
        return ownedBy;
    }

    public void setOwnedBy(Customer ownedBy) {
        this.ownedBy = ownedBy;
    }
    
    /**
     * @return
     */
    public String getCardType() {
        // TODO implement here
        return cardType;
    }

    /**
     * @return
     */
    public Date getIssueDate() {
        // TODO implement here
        return issueDate;
    }

    /**
     * @return
     */
    public Date getExpiryDate() {
        // TODO implement here
        return expiryDate;
    }

    /**
     * @return
     */
    public String getCAC() {
        // TODO implement here
        return CAC;
    }

    /**
     * @return
     */
    public String getCardNumber() {
        // TODO implement here
        return cardNumber;
    }

    /**
     * @param val
     */
    public void setcardType(String val) {
        // TODO implement here
        this.cardType = val;
    }

    /**
     * @param val
     */
    public void setissueDate(Date val) {
        // TODO implement here
        this.issueDate = val;
    }

    /**
     * @param val
     */
    public void setexpiryDate(Date val) {
        // TODO implement here
        this.expiryDate = val;
    }

    /**
     * @param val
     */
    public void setCAC(String val) {
        // TODO implement here
        this.CAC = val;
    }

    /**
     * @param val
     */
    public void setcardNo(String val) {
        // TODO implement here
        this.cardNumber = val;
    }
}
