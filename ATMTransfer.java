/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Ishwa
 */
public class ATMTransfer extends Transaction
{
    private Account sender;
    
    public ATMTransfer(double amount,Date datee,Time timee,String num,Account account)
    {
        super(amount,datee,timee,num,account);
        //sender=;
        account.setBalance(amount);
        sender.setBalance(amount);
    }
    
}
