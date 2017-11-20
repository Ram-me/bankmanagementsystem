/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class OperationalManager extends Employee 
{

    public OperationalManager(int ssn, String designation, DepartmentType department, Double salary, LoginDetail credentials, Branch worksIn, String cnic, String name, String email, String currentaddress, String residentialaddress, String mobilenumber, String telephonenumber) {
        super(ssn, designation, department, salary, credentials, worksIn, cnic, name, email, currentaddress, residentialaddress, mobilenumber, telephonenumber);
    }


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Boolean openCustomerAccount(Customer info, String accountype, double initialfee) 
    {
        if(accountype.toLowerCase().equals("checking"))
        {
            if(info.getCheckingaccount() == null)
            {
                // add checking account
                return true;
            }
            return false;     
        }
        else if(accountype.toLowerCase().equals("saving"))
        {
            if(info.getSavingaccount() == null)
            {
                // add savings account
                return true;
            } 
            return false;
        }
        else
        {
                return false;
        }
/*
        if(worksIn.getThebank().getAccountList().contains(info.getOwned())==false)
        {            
            info.owned.setInitialDeposit(initialfee);
            if(worksIn.getThebank().getAccountList().add(info.owned)==true)
            {
                if(worksIn.getThebank().addCustomer(info)==true)
                {
                    return true;
                }
                else
                    return false;
            }
            else
                return false; 
        }
        else
            return false;
*/
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public Boolean terminateAccount(String accountnumber, String accounttype) 
    {
        Boolean flag=true;
        if(worksIn.getThebank().verifyaccount(accountnumber)==true)
        {
            for (int i=0;i<worksIn.getThebank().getAccountList().size();i++)
            {
                if(((Account)worksIn.getThebank().getAccountList().get(i)).getAccountNumber().equals(accountnumber))
                {
                    if(worksIn.getThebank().getAccountList().remove(i)!=null)
                    {
                        flag= true;
                    }
                    else
                        flag= false;
                }
               
            }
        }
        else
        {
            flag= false;
        }
       return flag;
    }

   
    public Boolean requestCreditCard(String accountnumber) 
    {
        Account found = null;
        ArrayList<Account> a = worksIn.getThebank().getAccountList();
        for(int i = 0; i < a.size(); ++i)
        {
            found = a.get(i);
            if(!found.getAccountNumber().equals(accountnumber))
            {
                found = null;
            }
        }
       if(worksIn.getThebank().verifyaccount(accountnumber)==true&&found.getCreditCard()==null)
       {
            worksIn.getThebank().addCreditCardRequest(accountnumber);
            return true;
       }
       else
       {
           return false;
       }
    }

  
    public Boolean requestCreditCardExtension(String accountnumber) 
    {
        Account found = null;
        ArrayList<Account> a = worksIn.getThebank().getAccountList();
        for(int i = 0; i < a.size(); ++i)
        {
            found = a.get(i);
            if(!found.getAccountNumber().equals(accountnumber))
            {
                found = null;
            }
        }
        if(worksIn.getThebank().verifyaccount(accountnumber)==true)
        {
            if(found.getCreditCard() != null)
            {
                if(worksIn.getThebank().addCreditCardExtensionRequest(accountnumber)==true)
                    return true;
                else
                    return false;
            }
            else
            {
                return false;
            }
        }
        else
        {
           return false;
        }
    }

    
    public Boolean requestAtmCard(String accountnumber) 
    {
        Account found = null;
        ArrayList<Account> a = worksIn.getThebank().getAccountList();
        for(int i = 0; i < a.size(); ++i)
        {
            found = a.get(i);
            if(!found.getAccountNumber().equals(accountnumber))
            {
                found = null;
            }
        }
       if(worksIn.getThebank().verifyaccount(accountnumber)==true && found.getAtmCard() == null)
       {
            if(worksIn.getThebank().addATMCardRequest(accountnumber)==true)
                return true;
            else
                return false;
       }
       else
       {
           return false;
       }
    }

 
    public Boolean requestAtmCardExtension(String accountnumber) 
    {
        Account found = null;
        ArrayList<Account> a = worksIn.getThebank().getAccountList();
        for(int i = 0; i < a.size(); ++i)
        {
            found = a.get(i);
            if(!found.getAccountNumber().equals(accountnumber))
            {
                found = null;
            }
        }
        if(worksIn.getThebank().verifyaccount(accountnumber)==true)
        {
            if(found.getAtmCard()!=null)
            {
                if(worksIn.getThebank().addATMCardExtensionRequest(accountnumber))
                    return true;
                else
                    return false;
            }
            else
            {
                return false;
            }
        }
        else
        {
           return false;
        }
    }

   
    public Boolean manageloans(Loan given) {
        Boolean accepted = false;
        if(given != null && worksIn.getTotalfunds()>=given.getAmmount())
        {
            double totals = 0;
            List<Asset> all = given.getIncludedAssets();
            for(int i = 0; i < all.size(); ++i)
            {
                totals += all.get(i).getInspectedvalue();
            }
            if(totals >= given.getAmmount())
            {
                Instant instant = Instant.now(); //can be LocalDateTime
                ZoneId systemZone = ZoneId.systemDefault(); // my timezone
                ZoneOffset zo = systemZone.getRules().getOffset(instant);
                LocalDateTime start = LocalDateTime.ofEpochSecond((given.getDate().getTime()/1000),0,zo);
                LocalDateTime here =  LocalDateTime.ofEpochSecond((given.getMaturityDate().getTime()/1000),0,zo);
                int days = (int)start.until(here, ChronoUnit.DAYS);
                if(here.isAfter(start))
                {
                if(given.getIsPaid()<=(given.getAmmount()+days*given.getInterestRate()))
                {
                    if(given.getApproval())
                    {
                        worksIn.setTotalfunds((worksIn.getTotalfunds()-given.getAmmount())+given.getIsPaid());
                    }
                    worksIn.addLoan(given);
                    accepted=true;
                }
                }
            }
        }
        return accepted;
    }
}
