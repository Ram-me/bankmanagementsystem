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
 * @author Usama Zulfiqar
 */
public class ChequeBookDetail 
{
    private Date issueDate;
    private int branchNumber;
    private String branchName;
    private ArrayList<Cheque> chequeNumbers;
    private int cpNummber;
    private String IBAN;
    private String ownerName;
    
    ChequeBookDetail(Date issueDate, int branchNumber, String branchName, ArrayList<Cheque> chequeNumbers, int cpNummber, String IBAN, String ownerName)
    {
        this.issueDate = issueDate;
        this.branchNumber = branchNumber;
        this.branchName = branchName;
        this.chequeNumbers = chequeNumbers;
        this.cpNummber = cpNummber;
        this.IBAN = IBAN;
        this.ownerName = ownerName;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public ArrayList<Cheque> getChequeNumbers() {
        return chequeNumbers;
    }

    public void setChequeNumbers(ArrayList<Cheque> chequeNumbers) {
        this.chequeNumbers = chequeNumbers;
    }

    public int getBranchNumber() {
        return branchNumber;
    }

    public void setBranchNumber(int branchNumber) {
        this.branchNumber = branchNumber;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public int getCpNummber() {
        return cpNummber;
    }

    public void setCpNummber(int cpNummber) {
        this.cpNummber = cpNummber;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    
    public int getChequeNumbersRange()
    {
        return chequeNumbers.size();
    }
    
    public void setChequeNumbersRange(int value)
    {
        chequeNumbers.ensureCapacity(value);
    }
    
    public Cheque getFirstChequeNumber()
    {
        return chequeNumbers.get(0);
    }
    
    public void setFirstChequeNumber(Cheque C)
    {
         chequeNumbers.add(0,C);
    }
    
}
