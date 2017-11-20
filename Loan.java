/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;
import java.util.*;

 class Loan {

    private LoanType type;
    private Boolean approval;
    private double ammount;
    private Date date;
   // private TIME time;
    private String comment;
    private Date maturityDate;
    private float interestRate;
    private double isPaid;
    private ArrayList includedAssets;
    private Customer customer;
    
    public enum LoanType { A, B, C} 
    
    Loan()
    {
        
    }
    public Loan(LoanType type, Boolean approval, double ammount, Date date, String comment, Date maturityDate, float interestRate, double isPaid, ArrayList includedAssets, Customer customer) {
        this.type = type;
        this.approval = approval;
        this.ammount = ammount;
        this.date = date;
        this.comment = comment;
        this.maturityDate = maturityDate;
        this.interestRate = interestRate;
        this.isPaid = isPaid;
        this.includedAssets = includedAssets;
        this.customer = customer;
    }

    public LoanType getType() {
        return type;
    }

    public Boolean getApproval() {
        return approval;
    }

    public double getAmmount() {
        return ammount;
    }

    public Date getDate() {
        return date;
    }

    public String getComment() {
        return comment;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public double getIsPaid() {
        return isPaid;
    }

    public ArrayList getIncludedAssets() {
        return includedAssets;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setType(LoanType type) {
        this.type = type;
    }

    public void setApproval(Boolean approval) {
        this.approval = approval;
    }

    public void setAmmount(double ammount) {
        this.ammount = ammount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public void setIsPaid(double isPaid) {
        this.isPaid = isPaid;
    }

    public void setIncludedAssets(ArrayList includedAssets) {
        this.includedAssets = includedAssets;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
        public Boolean addAsset(String type, double value) 
      {
          Asset a= new Asset(type,value,0);
 //        this.addAsset(type, value);
           this.includedAssets.add(a);
         return true;
    }
    public Boolean releaseAsset(int index) 
    {
           this.includedAssets.remove(index);
           return true;
    }


  
}