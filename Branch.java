/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;
import java.util.*;
public class Branch 
{
   

   
    
      private String branchnumber;

     private String branchname;
    private String address;

     private String telephonenumber;

     private double totalfunds;

     private String totalcurrencies;

     private ArrayList loanlist;
     private BranchManager managedby;

     private ArrayList lockerlist;

     private ArrayList employeelist;

     private Bank thebank;

     private ArrayList conversions;

     private ArrayList transactionsl;

     private ArrayList locker;
//
//     public Set<Employee> WorksFor;
//
//    public Set<Locker> OwnedBy;
//    public SuspicionMeter WorksFor;
//
//    public TransactionHistory LocatedIn;

    Branch()
    {
        
    }
    
    Branch(String branchnumber, String branchname, String address, String telephonenumber, double totalfunds, String totalcurrencies, ArrayList loanlist, BranchManager managedby, ArrayList lockerlist, ArrayList employeelist, Bank thebank, ArrayList conversions, ArrayList transactionsl, ArrayList locker) {
        this.branchnumber = branchnumber;
        this.branchname = branchname;
        this.address = address;
        this.telephonenumber = telephonenumber;
        this.totalfunds = totalfunds;
        this.totalcurrencies = totalcurrencies;
        this.loanlist = loanlist;
        this.managedby = managedby;
        this.lockerlist = lockerlist;
        this.employeelist = employeelist;
        this.thebank = thebank;
        this.conversions = conversions;
        this.transactionsl = transactionsl;
        this.locker = locker;
    }

    public String getAddress() {
        return address;
    }

    public String getBranchnumber() {
        return branchnumber;
    }

    public ArrayList getEmployeelist() {
        return employeelist;
    }

    public String getBranchname() {
        return branchname;
    }

    public String getTelephonenumber() {
        return telephonenumber;
    }

    public double getTotalfunds() {
        return totalfunds;
    }

    public String getTotalcurrencies() {
        return totalcurrencies;
    }

    public ArrayList getLoanlist() {
        return loanlist;
    }

    public BranchManager getManagedby() {
        return managedby;
    }

    public ArrayList getLockerlist() {
        return lockerlist;
    }

    public Bank getThebank() {
        return thebank;
    }

    public ArrayList getConversions() {
        return conversions;
    }

    public ArrayList getTransactionsl() {
        return transactionsl;
    }

    public ArrayList getLocker() {
        return locker;
    }

    public void setBranchnumber(String branchnumber) {
        this.branchnumber = branchnumber;
    }

    public void setBranchname(String branchname) {
        this.branchname = branchname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTelephonenumber(String telephonenumber) {
        this.telephonenumber = telephonenumber;
    }

    public void setTotalfunds(double totalfunds) {
        this.totalfunds = totalfunds;
    }

    public void setTotalcurrencies(String totalcurrencies) {
        this.totalcurrencies = totalcurrencies;
    }

    public void setLoanlist(ArrayList loanlist) {
        this.loanlist = loanlist;
    }
    public void setLoanlist(int index , Loan value) {
            this.loanlist = loanlist;
        }

    public void setManagedby(BranchManager managedby) {
        this.managedby = managedby;
    }

    public void setLockerlist(ArrayList lockerlist) {
        this.lockerlist = lockerlist;
    }

    public void setEmployeelist(ArrayList employeelist) {
        this.employeelist = employeelist;
    }

    public void setThebank(Bank thebank) {
        this.thebank = thebank;
    }

    public void setConversions(ArrayList conversions) {
        this.conversions = conversions;
    }

    public void setTransactionsl(ArrayList transactionsl) {
        this.transactionsl = transactionsl;
    }

    public void setLocker(ArrayList locker) {
        this.locker = locker;
    }
    
    boolean  addLoan(Loan value ) 
    {
        loanlist.add(value);
        return true;
    }
    
    boolean  deleteLoan(int index ) 
    {
        loanlist.remove(index);
        return true;
       
    }
     boolean  addEmployee(Employee value ) 
    {
        employeelist.add(value);
        
        return true;
       
    }
   boolean  DeleteEmployee(int index ) 
    {
        employeelist.remove(index);
        return false;
       
    }
    Bank getthebank()
    {
      return thebank;   
    }
   // changed type will be boolean
     Boolean verifyAccount(int pin ,String cardnumber)
     {
         int c = Integer.parseInt(cardnumber);
          ArrayList <Account>  a=thebank.getAccountList();
          Boolean flag=false;
         for (int i = 0; i < a.size(); i++) 
         {
              if (a.get(i).getAtmCard().getCardNumber().equals(cardnumber)&& a.get(i).getAtmCard().getPincode()==pin )
              {
                 flag=true;
              }
               
         }
            
         return flag;
     }
      boolean   updateAccount(Account a ) 
    {
       return thebank.updateAccount(a);
       
    }
       boolean  Verifyaccount(String value ) 
    {
        return thebank.verifyaccount(value);
       
    }
      boolean  UpdateTransfers(Account a,String R,Double Amount ) 
    {
         return thebank.updateTransfers(a, R, Amount);
         
    }
}