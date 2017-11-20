/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;
import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author Ishwa
 */
public class TransactionHistory 
{
    private Date hdate;
    private int totalTransactions;
    private double totalAmountDeposited;
    private ArrayList transactionList;

    public TransactionHistory(Date hdate, ArrayList transactionList) {
        this.hdate = hdate;
        this.transactionList = transactionList;
        totalTransactions = 0;
        if(transactionList != null)
        {
        totalTransactions = transactionList.size();
        }
        totalAmountDeposited = 0;
        for(int i = 0; i < totalTransactions;++i)
        {
            totalAmountDeposited+=((Transaction)transactionList.get(i)).getAmmount();
        }
    }
    

    public Date getDate()
    {
        return hdate;
    }
    public int getTotalTransactions()
    {
        return totalTransactions;
    }
    public double getTotalAmountDeposited()
    {
        return totalAmountDeposited;
    }
    public ArrayList getTransactionList()
    {
        return transactionList;
    }
    public void setdate(Date date)
    {
        hdate=date;
    }
    public void settotalTransactions(int num)
    {
        totalTransactions=num;
    }
    public void settotalAmount(double amount)
    {
        totalAmountDeposited=amount;
    }
    public void setTransactionList(ArrayList array)
    {
        transactionList.addAll(array);
    }
}
