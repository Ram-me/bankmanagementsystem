/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;
 
import static java.lang.Integer.min;
import java.util.*;
 
public class ATMMachine {

    /**
     * Default constructor
     */
    

    private Boolean isRunning;
    private double cashInside;
    private Account currentUser;
    public Branch location;
    public  int DaysinStatement;

     ATMMachine(Boolean isRunning, double cashInside, Account currentUser, Branch location) {
        this.isRunning = isRunning;
        this.cashInside = cashInside;
        this.currentUser = currentUser;
        this.location = location;
    }

     Boolean getIsRunning() {
        return isRunning;
    }

     double getCashInside() {
        return cashInside;
    }

     Account getCurrentUser() {
        return currentUser;
    }

     Branch getLocation() {
        return location;
    }

      int getDaysinStatement() {
        return DaysinStatement;
    }

     void setIsRunning(Boolean isRunning) {
        this.isRunning = isRunning;
    }

     void setCashInside(double cashInside) {
        this.cashInside = cashInside;
    }

     void setCurrentUser(Account currentUser) {
        this.currentUser = currentUser;
    }

     void setLocation(Branch location) {
        this.location = location;
    }

      void setDaysinStatement(int DaysinStatement) {
        this.DaysinStatement = DaysinStatement;
    }
    
    // require tranasactions 
      ArrayList getminibankstatement(Account a) 
    {
        ArrayList <Transaction> list= new ArrayList<Transaction>();
         ArrayList <Transaction> list1= new ArrayList<Transaction>();
          ArrayList <Transaction> list2= new ArrayList<Transaction>();
         Transaction t;
         
        list=location.getTransactionsl();
        
        for (int i = 0; i < list.size(); i++)
        {
            t= list.get(i);
            if(t.initiatedBy==a)
            {
                list1.add(t);
            }
        }
        
        for (int i = 0; i < min(DaysinStatement,list1.size()); i++) 
        {
         
            t=list1.get(0);
            int d=0;
            for (int j = 1 ; j < list1.size(); j++) 
            {
               
               int v= t.date.compareTo(list1.get(j).date);
                if(v < 0 )
                {
                    t=list1.get(j);
                    d=j;
                }
                
                
            }
            list2.add(t);
            list1.remove(d);
            
        }
        
        return list2;
    }
    
    
    
    
     Boolean approveTransfer(int amount, String R)
    {
        // TODO implement here
       
        this.isRunning = false;
        this.currentUser = null;
        
        return true;
    }
    public Boolean approveAtmWithdrawl(Double ammount)
    {
        Boolean flag=false;
       if( this.CheckCurrentBalance(ammount)==true)
       {
           this.updateCurrentuserBalance(ammount);
           this.updateAccount(currentUser);
           flag=true;
       }
        
        return flag;
        
    }
    public Boolean login(int pincode, String cardnumber) 
    {
        return location.verifyAccount(pincode, cardnumber);
        
    }
    public double checkBalance()
    {
        // TODO implement here
        return this.currentUser.getBalance();
    }
    
    public Boolean CheckCurrentBalance(Double amount)
    {
        Boolean flag=false;
        if(checkBalance()>amount)
        {
            flag=true; 
        }
        return flag;
        // TODO implement here
    }
    public void updateCurrentuserBalance(Double amount) 
    {
       Double var;
       var=currentUser.getBalance()-amount;
        this.currentUser.setBalance(var);
        // TODO implement here
    }
    public void updateAccount(Account a)
    {
        location.updateAccount(a);
        // TODO implement here
    }
    public void ejectCard() 
    {
        
        
        // TODO implement here
    }
    public Boolean verifyrecieveraccount(String R)
    {
        return location.Verifyaccount(R);
        
        // TODO implement here
        
    }

    public void updateTransfers(Account a , String R, Double Amount) 
    {
        location.UpdateTransfers(a, R, Amount);
        
        // TODO implement here
    }

}