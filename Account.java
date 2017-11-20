/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;
import java.util.Date;

/**
 *
 * @author Ishwa
 */
public class Account 
{
    private String accountNumber;
    private Date dateOpened;
    private double balance;
    private static double feeRate;
    private Date dateClosed;
    private double initialDeposit;
    private static double minimumFee;
    private ATMCardDetail atmCard;
    private CreditCardDetail creditCard;
    private Customer owner;
    private ChequeBookDetail cheque;
    
    public Account(String account,Date open,double balancee,double ratefee,Date close,double deposit,double minfee,ATMCardDetail acard,CreditCardDetail ccard,Customer own,ChequeBookDetail ccheque)
    {
        accountNumber=account;
        dateOpened=open;
        balance=balancee;
        feeRate=ratefee;
        dateClosed=close;
        initialDeposit=deposit;
        minimumFee=minfee;
        atmCard=acard;
        creditCard=ccard;
        owner=own;
        cheque=ccheque;
    }
    public double computeFees()
    {
        double temp=balance*feeRate;
        return temp;
    }
    public void setBalance(double addition)
    {
        balance=balance+addition;
    }
    public String getAccountNumber()
    {
        return accountNumber;
    }
    public Date getDateOpened()
    {
        return dateOpened;
    }
    public double getBalance()
    {
        return balance;
    }
    public double getFeeRate()
    {
        return feeRate;
    }
    public Date getDateClosed()
    {
        return dateClosed;
    }
    public double getInitialDeposit()
    {
        return initialDeposit;
    }
    public double getMinimumFee()
    {
        return minimumFee;
    }
    public ATMCardDetail getAtmCard()
    {
        return atmCard;
    }
    public CreditCardDetail getCreditCard()
    {
        return creditCard;
    }
    public Customer getOwner()
    {
        return owner;
    }
    public ChequeBookDetail getCheque()
    {
        return cheque;
    }
    public void setAccountNumber(String num)
    {
        accountNumber=num;
    }
    public void setDateOpened(Date date)
    {
        dateOpened=date;
    }
    public void setFeeRate(double a)
    {
        feeRate=a;
    }
    public void setDateClosed(Date date)
    {
        dateClosed=date;
    }
    public void setInitialDeposit(double g)
    {
        initialDeposit=g;
    }
    public void setMinimumFee(double g)
    {
        minimumFee=g;
    }
    public void setAtmCard(ATMCardDetail atm)
    {
        atmCard=atm;
    }
    public void setCreditCard(CreditCardDetail cc)
    {
        creditCard=cc;
    }
    public void setOwner(Customer g)
    {
        owner=g;
    }
    public void setCheque(ChequeBookDetail g)
    {
        cheque=g;
    }
}
