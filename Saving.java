/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;

/**
 *
 * @author Ishwa
 */
public class Saving extends Account
{
    private double interestRate;

    public Saving(double interestRate, String account, Date open, double balancee, double ratefee, Date close, double deposit, double minfee, ATMCardDetail acard, CreditCardDetail ccard, Customer own, ChequeBookDetail ccheque) {
        super(account, open, balancee, ratefee, close, deposit, minfee, acard, ccard, own, ccheque);
        this.interestRate = interestRate;
    }
    

    public double computeinterest()
    {
        LocalDate localDate = getDateOpened().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int startyear=localDate.getYear();
        localDate = getDateClosed().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int endyear=localDate.getYear();
        int timeperiod=endyear-startyear;
        double rate=interestRate/100;
        double balance=getBalance();
        double result;
        result=timeperiod*balance*rate;
        return result;
    }
    public double getinterestRate()
    {
        return interestRate;
    }
}
