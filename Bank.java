/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author Hammad
 */

import java.util.*;

/**
 * 
 */
public class Bank {

    /**
     * Default constructor
     */
    public Bank() {
    }

    /**
     * 
     */
    private ArrayList creditCardRequests;

    /**
     * 
     */
    private ArrayList ATMCardRequests;

    /**
     * 
     */
    private ArrayList creditCardExtensionRequests;

    /**
     * 
     */
    private ArrayList ATMCardExtensionRequests;

    /**
     * 
     */
    private ArrayList customerList;

    /**
     * 
     */
    private ArrayList branchList;

    /**
     * 
     */
    private ArrayList accountList;

    /**
     * 
     */
    private int creditCardDuration;

    /**
     * 
     */
    private int atmCardDuration;

    /**
     * 
     */
    private SuspicionMeter suspicious;

    /**
     * 
     */
    private int suspicionThresholdPerDay;

    /**
     * 
     */
    private String exchangeRates;



    /**
     * @param creditCardRequests 
     * @param ATMCardRequests 
     * @param ArrayList 
     * @param creditCardExtensionRequests 
     * @param ATMCardExtensionRequests 
     * @param customer 
     * @param branchList 
     * @param accountList 
     * @param creditCardDuration 
     * @param ATMCardDuration 
     * @param suspicious 
     * @param suspicionThresholdPerDay 
     * @param exchangeRates
     */
    public Bank(ArrayList creditCardRequests, ArrayList ATMCardRequests, ArrayList creditCardExtensionRequests, ArrayList ATMCardExtensionRequests, ArrayList customerList, ArrayList branchList, ArrayList accountList, int creditCardDuration, int atmCardDuration, SuspicionMeter suspicious, int suspicionThresholdPerDay, String exchangeRates) {    
        this.creditCardRequests = creditCardRequests;
        this.ATMCardRequests = ATMCardRequests;
        this.creditCardExtensionRequests = creditCardExtensionRequests;
        this.ATMCardExtensionRequests = ATMCardExtensionRequests;
        this.customerList = customerList;
        this.branchList = branchList;
        this.accountList = accountList;
        this.creditCardDuration = creditCardDuration;
        this.atmCardDuration = atmCardDuration;
        this.suspicious = suspicious;
        this.suspicionThresholdPerDay = suspicionThresholdPerDay;
        this.exchangeRates = exchangeRates;
        //this.index = index;
    }

    /**
     * @return
     */
    public ArrayList getCreditCardRequests() {
        // TODO implement here
        return creditCardRequests;
    }

    /**
     * @param index 
     * @return
     */
    public Boolean deleteCreditCardRequest(int index) {
        // TODO implement here
        if (index >= 0 && index < creditCardRequests.size()) {
            //Legal Index
            creditCardRequests.remove(index);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * @param value 
     * @return
     */
    public Boolean addCreditCardRequest(String value) {
        // TODO implement here
        if (value != null) {
            creditCardRequests.add(value);
            return true;
        }
        else {
            return false;
        }
    }
    /**
     * @return
     */
    public ArrayList getATMCardRequests() {
        // TODO implement here
        return ATMCardRequests;
    }

    /**
     * @param index 
     * @return
     */
    public Boolean deleteATMCardRequest(int index) {
        // TODO implement here
        if (index >= 0 && index < ATMCardRequests.size()) {
            //Legal Index
            ATMCardRequests.remove(index);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * @param value 
     * @return
     */
    public Boolean addATMCardRequest(String accountno) {
        // TODO implement here
         if (accountno != null) {
            ATMCardRequests.add(accountno);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * @return
     */
    public ArrayList getCreditCardExtensionRequests() {
        // TODO implement here
        return creditCardExtensionRequests;
    }

    /**
     * @param index 
     * @return
     */
    public Boolean deleteCreditCardExtensionRequest(int index) {
        // TODO implement here
        if (index >= 0 && index < creditCardExtensionRequests.size()) {
            //Legal Index
            creditCardExtensionRequests.remove(index);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * @param value 
     * @return
     */
    public Boolean addCreditCardExtensionRequest(String value) {
        // TODO implement here
        if (value != null) {
            creditCardExtensionRequests.add(value);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * @return
     */
    public ArrayList getATMCardExtensionRequests() {
        // TODO implement here
        return ATMCardExtensionRequests;
    }

    /**
     * @param index 
     * @return
     */
    public Boolean deleteATMCardExtensionRequest(int index) {
        // TODO implement here
        if (index >= 0 && index < ATMCardExtensionRequests.size()) {
            //Legal Index
            ATMCardExtensionRequests.remove(index);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * @param value 
     * @return
     */
    public Boolean addATMCardExtensionRequest(String value) {
        // TODO implement here
        if (value != null) {
            ATMCardExtensionRequests.add(value);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * @return
     */
    public ArrayList getCustomerList() {
        // TODO implement here
        return customerList;
    }

    /**
     * @param int index 
     * @return
     */
    public Boolean deleteCustomer(int index) {
        // TODO implement here
        if (index >= 0 && index < customerList.size()) {
            //Legal Index
            customerList.remove(index);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * @param value 
     * @return
     */
    public Boolean addCustomer(Customer value) {
        // TODO implement here
        if (value != null) {
            customerList.add(value);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * @param index 
     * @param value 
     * @return
     */
    public Boolean updateCustomer(int index, Customer value) {
        // TODO implement here
        if (index >= 0 && index < customerList.size() && value != null) {
            customerList.add(index, value);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * @return
     */
    public ArrayList getBranchlist() {
        // TODO implement here
        return branchList;
    }

    /**
     * @param value 
     * @return
     */
    public void setBranchlist(ArrayList value) {
        // TODO implement here
        this.branchList = value;
    }

    /**
     * @return
     */
    public ArrayList getAccountList() {
        // TODO implement here
        return accountList;
    }

    /**
     * @param index 
     * @param value 
     * @return
     */
    public Boolean updateAccount(int index, Account value) {
        // TODO implement here
        if (index >= 0 && index < accountList.size() && value != null) {
            accountList.add(index, value);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * @param value 
     * @return
     */
    public Boolean addAccount(Account value) {
        // TODO implement here
        if (value != null) {
            accountList.add(value);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * @return
     */
    public int getCreditcardduration() {
        // TODO implement here
        return creditCardDuration;
    }

    /**
     * @param value 
     * @return
     */
    public void setCreditCardDuration(int value) {
        // TODO implement here
        this.creditCardDuration = value;
    }

    /**
     * @return
     */
    public int getATMCardDuration() {
        // TODO implement here
        return atmCardDuration;
    }

    /**
     * @param value 
     * @return
     */
    public void setATMCardDuration(int value) {
        // TODO implement here
        this.atmCardDuration = value;
    }

    /**
     * @return
     */
    public SuspicionMeter getSuspicious() {
        // TODO implement here
        return suspicious;
    }

    /**
     * @return
     */
    public int getSuspicionThresholdPerDay() {
        // TODO implement here
        return suspicionThresholdPerDay;
    }

    /**
     * @param value 
     * @return
     */
    public void setSuspicionThresholdPerDay(int value) {
        // TODO implement here
        this.suspicionThresholdPerDay = value;
    }

    /**
     * @return
     */
    public String getExchangerates() {
        // TODO implement here
        return exchangeRates;
    }

    /**
     * @param value
     */
    public void setExchangerates(String value) {
        // TODO implement here
        this.exchangeRates = value;
    }

    /**
     * @param val
     */
    public void setcreditCardRequests(ArrayList val) {
        // TODO implement here
        this.creditCardRequests = val;
    }

    /**
     * @param val
     */
    public void setATMCardRequests(ArrayList val) {
        // TODO implement here
        this.ATMCardRequests = val; 
    }

    /**
     * @param val
     */
    public void setcreditCardExtensionRequests(ArrayList val) {
        // TODO implement here
        this.creditCardExtensionRequests = val;
    }

    /**
     * @param val
     */
    public void setATMcardExtensionsRequest(ArrayList val) {
        // TODO implement here
        this.ATMCardExtensionRequests = val;
    }

    /**
     * @param val
     */
    public void setcustomerList(ArrayList val) {
        // TODO implement here
        this.customerList = val;
    }

    /**
     * @param val
     */
    public void setBranchList(ArrayList val) {
        // TODO implement here
        this.branchList = val;
    }

    /**
     * @param val
     */
    public void setaccountList(ArrayList val) {
        // TODO implement here
        this.accountList = val;
    }

    /**
     * @param val
     */
    public void setcreditCardDuration(int val) {
        // TODO implement here
        this.creditCardDuration = val;
    }

    /**
     * @param val
     */
    public void setatmCardDuration(int val) {
        // TODO implement here
        this.atmCardDuration = val;
    }

    /**
     * @param val
     */
    public void setsuspicion(SuspicionMeter val) {
        // TODO implement here
        this.suspicious = val;
    }

    /**
     * @param val
     */
    public void setSuspiciousperDay(int val) {
        // TODO implement here
        this.suspicionThresholdPerDay = val;
    }

    /**
     * @param pin 
     * @param cardnumber 
     * @return
     */
    public Account verifyAccount(int pin, String cardnumber) {
        return null; // WHY IS THISSSSSSSSSSSSSSSSSSSSSSSSSSS EMPTYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY
    }

    /**
     * @param a
     */
    public Boolean updateAccount(Account a) {
        // TODO implement here
        if (a != null){
            for(int i = 0 ; i <  this.accountList.size() ; i++) {
                if(a.getAccountNumber().equals(((Account)this.accountList.get(i)).getAccountNumber())) {
                    this.accountList.set(i, a);
       
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param R 
     * @return
     */
    public Boolean verifyaccount(String R) {
        Boolean found  = false;
            for(int i = 0 ; i <  this.accountList.size() && !found; i++) {
                if(R.equals(((Account)this.accountList.get(i)).getAccountNumber())) {
                    found = true;
                }
            }
            return found;
    }

    /**
     * @param a 
     * @param R 
     * @param Amount
     */
    public Boolean updateTransfers(Account a, String R, double Amount) {
        // TODO implement here
        // change account balance
        // change transaction history
        // check suspicion meter ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        return false;
    }

    /**
     * @param cnic
     */
    public Customer searchCustomerbyCnic(String cnic) {
        // TODO implement here
        if(this.customerList.size() > 0)
        {
            for(int i = 0 ; i < this.customerList.size() ; i++) {
                if(cnic.equals(((Customer)this.customerList.get(i)).getCnic())){
                 {    return (Customer)this.customerList.get(i);
                
                 }
                }
            }
        
        }
        return null;
    }

    /**
     * @param dim
     */

    /**
     * @param a
     */
    public Boolean deleteAccount(Account a) {
        // TODO implement here
        if(this.accountList.size() > 0) {
            if(this.accountList.remove(a)== true){
                return true;
            }
        }
        else {
            return false;
        }
        return false;
    }

    /**
     * @param c
     */
    public Boolean deleteCustomer(Customer c) {
        // TODO implement here
        if(this.customerList.size() > 0) {
            if(this.customerList.remove(c)== true){
                return true;
            }
        }
        else {
            return false;
        }
        return false;
    }

}
