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
public class DirectDeposit extends Transaction
{
    public DirectDeposit(double amount,Date date,Time time,String num,Account account)
    {
        super(amount,date,time,num,account);
    }
}
