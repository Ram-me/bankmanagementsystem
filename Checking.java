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
public class Checking extends Account
{

    public Checking(String account, Date open, double balancee, double ratefee, Date close, double deposit, double minfee, ATMCardDetail acard, CreditCardDetail ccard, Customer own, ChequeBookDetail ccheque) {
        super(account, open, balancee, ratefee, close, deposit, minfee, acard, ccard, own, ccheque);
    }

}
