package backend;

import java.sql.Time;
import java.util.*;

public abstract class Cheque extends Transaction
{
   protected String chequeNumber;
   protected Boolean approval;
   protected Cashier approvedBy;

    public Cheque(String chequeNumber, Boolean approval, Cashier approvedBy, double amount, Date datee, Time timee, String num, Account account) {
        super(amount, datee, timee, num, account);
        this.chequeNumber = chequeNumber;
        this.approval = approval;
        this.approvedBy = approvedBy;
    }


 



    public void setApproval(Boolean approved, String requester) 
    {
        approval=approved;
        chequeNumber=requester;
        
    }
    

    public void setChequeNumber(String val) 
    {
           chequeNumber=val;       
       
    }

    public void setapprovedBy(Cashier val) 
    {
        approvedBy=val;
    }
    
    public String getChequeNumber() 
    {
            return chequeNumber;
    }

    public Cashier getApprovedBy()
    {
        return approvedBy;
    }

    public Boolean getApproval() 
    {
       return approval;
    }

}