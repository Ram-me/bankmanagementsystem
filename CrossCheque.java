

package backend;
import java.sql.Time;
import java.util.*;

class CrossCheque extends SelfCheque 
{
    private Date signedDate;
    private Date finalDate;
    private Account receiver;

    public CrossCheque(Date signedDate, Date finalDate, Account receiver, String chequeNumber, Boolean approval, Cashier approvedBy, double amount, Date datee, Time timee, String num, Account account) {
        super(chequeNumber, approval, approvedBy, amount, datee, timee, num, account);
        this.signedDate = signedDate;
        this.finalDate = finalDate;
        this.receiver = receiver;
    }





    public void setSignedDate(Date signedDate) {
        this.signedDate = signedDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public void setReceiver(Account receiver) {
        this.receiver = receiver;
    }

    public Date getSignedDate() {
        return signedDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public Account getReceiver() {
        return receiver;
    }



}