package backend;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.*;

/**
 * 
 */
public class SuspicionMeter {
    private ArrayList suspiciounList;
    private Bank worksFor;

    public SuspicionMeter(Bank worksFor) {
        this.worksFor = worksFor;
        suspiciounList = new ArrayList();
    }

    /**
     * @return
     */
    public ArrayList getSuspicionList() {
        return suspiciounList;
    }

    /**
     * @param accountnumber 
     * @return
     */
    public int FindACustomer(String accountnumber) {
        int counter = 0;
        Customer c = null;
        ArrayList<Account> all = worksFor.getAccountList();
        for(int i = 0; i < all.size() && c == null;++i)
        {
            if(all.get(i).getAccountNumber().equals(accountnumber))
            {
                c = all.get(i).getOwner();
            }
        }
        if(c != null)
        {
            for(int i = 0; i < suspiciounList.size(); ++i)
            {
                if(((Transaction)suspiciounList.get(i)).getInitiatedBy().getOwner() == c)
                {
                    counter++;
                }
            }
        }
        return counter;
    }

    public void setSuspiciounList(ArrayList suspiciounList) {
        this.suspiciounList = suspiciounList;
    }

    public void setWorksFor(Bank worksFor) {
        this.worksFor = worksFor;
    }

    
}