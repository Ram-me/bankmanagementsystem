/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package backend;
import java.util.Date;
import java.sql.Time;

/**
 *
 * @author Ishwa
 */
public class Transaction 
{
    protected double ammount;
    protected Date date;
    protected Time time;
    protected String receiptNumber;
    protected Account initiatedBy;
    

    public Transaction(double amount,Date datee,Time timee,String num,Account account)
    {
        ammount=amount;
        date=datee;
        time=timee;
        receiptNumber=num;
        initiatedBy=account;
    }
    
    
    /*public double updatebranchfunds(Branch obj)
    {
        double temp=obj.getTotalfunds();
        temp=temp+ammount;
        obj.setTotalfunds(temp);
        return temp;
    }*/
    
    
    public double getAmmount()
    {
        return ammount;
    }
    public Date getDate()
    {
        return date;
    }
    public Time getTime()
    {
        return time;
    }
    public String getReceiptNumber()
    {
        return receiptNumber;
    }
    public Account getInitiatedBy()
    {
        return initiatedBy;
    }
    public void setamount(Double amountt)
    {
        ammount=amountt;
    }
    public void setDate(Date datee)
    {
        date=datee;
    }
    public void setTime(Time timee)
    {
        time=timee;
    }
    public void setreceipt(String num)
    {
        receiptNumber=num;
    }
    public void setInitiatedby(Account account)
    {
        initiatedBy=account;
    }
}
