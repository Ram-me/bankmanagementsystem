package backend;
import java.util.*;
import java.time.*;
import java.time.temporal.*;
/**
 * 
 */
public class BranchManager extends Employee {

    private Branch manages;
    public ArrayList loans;

    public BranchManager(Branch manages, ArrayList loans, int ssn, String designation, DepartmentType department, Double salary, LoginDetail credentials, Branch worksIn, String cnic, String name, String email, String currentaddress, String residentialaddress, String mobilenumber, String telephonenumber) {
        super(ssn, designation, department, salary, credentials, worksIn, cnic, name, email, currentaddress, residentialaddress, mobilenumber, telephonenumber);
        this.manages = manages;
        this.loans = loans;
    }

    /**
     * @param given 
     * @return
     */
    public Boolean manageloans(Loan given) {
        Boolean accepted = false;
        if(given != null && manages.getTotalfunds()>=given.getAmmount())
        {
            double totals = 0;
            List<Asset> all = given.getIncludedAssets();
            for(int i = 0; i < all.size(); ++i)
            {
                totals += all.get(i).getInspectedvalue();
            }
            if(totals >= given.getAmmount())
            {
                Instant instant = Instant.now(); //can be LocalDateTime
                ZoneId systemZone = ZoneId.systemDefault(); // my timezone
                ZoneOffset zo = systemZone.getRules().getOffset(instant);
                LocalDateTime start = LocalDateTime.ofEpochSecond((given.getDate().getTime()/1000),0,zo);
                LocalDateTime here =  LocalDateTime.ofEpochSecond((given.getMaturityDate().getTime()/1000),0,zo);
                int days = (int)start.until(here, ChronoUnit.DAYS);
                if(here.isAfter(start))
                {
                if(given.getIsPaid()<=(given.getAmmount()+days*given.getInterestRate()))
                {
                    if(given.getApproval())
                    {
                        manages.setTotalfunds((manages.getTotalfunds()-given.getAmmount())+given.getIsPaid());
                    }
                    manages.addLoan(given);
                    accepted=true;
                }
                }
            }
        }
        return accepted;
    }

    /**
     * @return
     */
    public ArrayList viewallemployees() {
        ArrayList l = manages.getEmployeelist();
        return l;
    }

    /**
     * @param departmentid 
     * @return
     */
    public ArrayList viewemployeeesbydepartment(int departmentid) {
        // TODO implement here
        ArrayList l = manages.getEmployeelist();
        Employee e = null;
        for(int i = 0; i < l.size(); ++i)
        {
            e = (Employee) l.get(i);
            if(e.getDepartment()!=DepartmentType.values()[departmentid])
            {
                l.remove(i);
                i--;
            }
        }
        return l;
    }

    /**
     * 
     */
    public ArrayList viewactiveloans() {
        // TODO implement here
        ArrayList l = manages.getLoanlist();
        Loan e = null;
        for(int i = 0; i < l.size(); ++i)
        {
            e = (Loan) l.get(i);
            if(!e.getApproval()||e.getIsPaid()==e.getAmmount())
            {
                l.remove(i);
                i--;
            }
        }
        return l;      
    }

    /**
     * @param accountnumber 
     * @return
     */
    public ArrayList viewcustomerprofile(String accountnumber) {
        // TODO implement here
        ArrayList searchresults = new ArrayList();
        Customer c = null;
        Account a = null;
        Account tmp = null;
        Customer t = null;
        int totalloans = 0;
        int totaltransactions = 0;
        Bank b = manages.getThebank();
        ArrayList<Account> alist = b.getAccountList();
        for(int i = 0; i < alist.size() && a == null; ++i)
        {
            tmp = alist.get(i);
            if(tmp.getAccountNumber().equals(accountnumber))
            {
                a = tmp;
                c = tmp.getOwner();
            }
        }
        searchresults.add(c);
        searchresults.add(a);
        if(a != null)
        { 
            ArrayList<Loan> llist = manages.getLoanlist();
            for(int i = 0; i < llist.size(); ++i)
            {
                if(llist.get(i).getCustomer() == c)
                {
                    totalloans++;
                }
            }
            
            ArrayList<Transaction> tlist = manages.getTransactionsl();
            for(int i = 0; i < tlist.size(); ++i)
            {
                if(tlist.get(i).getInitiatedBy() == a)
                {
                    totaltransactions++;
                }
            }
        }
        searchresults.add(totalloans);
        searchresults.add(b.getSuspicious().FindACustomer(accountnumber));
        searchresults.add(totaltransactions);
        return searchresults;
    }

    /**
     * @return
     */
    public ArrayList viewsuspicionmeter() {
        return manages.getThebank().getSuspicious().getSuspicionList();
    }

    /**
     * @param date 
     * @return
     */
    public ArrayList<Transaction> viewinfobydate(Date date) {
        ArrayList<Transaction> ret = null;
        ArrayList<TransactionHistory> t = manages.getTransactionsl();
                Instant instant = Instant.now(); //can be LocalDateTime
                ZoneId systemZone = ZoneId.systemDefault(); // my timezone
                ZoneOffset zo = systemZone.getRules().getOffset(instant);
                LocalDateTime d = LocalDateTime.ofEpochSecond((date.getTime()/1000),0,zo);
                LocalDateTime then = null;
        for(int i = 0; i < t.size() && ret == null;++i)
        {
            then = LocalDateTime.ofEpochSecond((t.get(i).getDate().getTime()/1000),0,zo);
            if(then.getYear() == d.getYear() && then.getDayOfYear() == d.getDayOfYear())
            {
                ret = t.get(i).getTransactionList();
            }
                
        }
        return ret;
    }

    /**
     * @return
     */
    public ArrayList viewfreelockers() {
            ArrayList all = manages.getLockerlist();
            for(int i = 0; i < all.size();++i)
            {
                if(((Locker)all.get(i)).getIsoccupied())
                {
                    all.remove(i);
                    i--;
                }
            }
            return all;
    }

    /**
     * @return
     */
    public ArrayList viewbookedlockers() {
            ArrayList all = manages.getLockerlist();
            for(int i = 0; i < all.size();++i)
            {
                if(!((Locker)all.get(i)).getIsoccupied())
                {
                    all.remove(i);
                    i--;
                }
            }
            return all;
    }

    /**
     * @param requestorcnic 
     * @param dimension 
     * @return
     */
    public Boolean approvelocker(String requestorcnic,double height,double length,double width) {
        Boolean accepted = false;
        Customer c = manages.getThebank().searchCustomerbyCnic(requestorcnic);
        if(c.getLocker()== null)
        {
            List<Locker> all = manages.getLockerlist();
            Locker l = null;
            for(int i = 0; i < all.size();++i)
            {
                l = all.get(i);
                if(l.getIsoccupied()||l.getHeight()!=height||l.getWidth()!=width||l.getLength()!=length)
                {
                    all.remove(i);
                    i--;
                }
            }
            if(all.size()>0)
            {
                accepted = true;
                l.setIsoccupied(true);
                c.setLocker(l);
            }
        }
        return accepted;
    }

    /**
     * @param requestnumber 
     * @return
     */
    public String approveatmcard(int requestnumber) {
        String mymessage = "Could not find any requests";
        ArrayList r = manages.getThebank().getATMCardRequests();
        if(r.size() != 0)
        {
            mymessage = "Your request was invalid";
            if(requestnumber < 0 || requestnumber >= r.size())
            {
                mymessage = "Account could not londer be found";
                Account a = null;
                String tofind = (String) r.get(requestnumber);
                Account tmp = null;
                ArrayList al = manages.getThebank().getAccountList();
                for(int i = 0; i < al.size() && a != null; ++i)
                {
                    tmp = (Account) al.get(i);
                    if(tmp.getAccountNumber().equals(tofind))
                    {
                        a = tmp;
                    }
                }
                if(a != null)
                {
                    Random rand =  new Random();
                    
                    Date d = new Date();
                    LocalDateTime l = LocalDateTime.now();
                    ZoneId zoneId = ZoneId.systemDefault();
                    Date newdate = new Date(l.plusDays(manages.getThebank().getATMCardDuration()).atZone(zoneId).toEpochSecond()*1000);
                    
                    Boolean generated = false;
                    ArrayList all = manages.getThebank().getAccountList();
                    List<String> allcards = new LinkedList<String>();
                    ArrayList allcardno = new ArrayList();
                    String mycac = "";
                    int cardno = 0;
                    int pin = 0;
                    for(int i = 0; i < all.size();++i)
                    {
                        tmp = (Account) all.get(i);
                        if(tmp.getAtmCard() != null)
                        {
                            allcards.add(tmp.getAtmCard().getCAC());
                            cardno+=Integer.parseInt(tmp.getAtmCard().getCardNumber());
                            pin += tmp.getAtmCard().getPincode();
                            allcardno.add(tmp.getAtmCard().getCardNumber());
                        }
                    }
                    
                    char[] backup = new char[256];
                    for(int i = 0; i < 50; ++i)
                    {   
                        backup[i] = (char) rand.nextInt(256);
                        for(int j = 0; j < allcards.size();++j)
                        {
                            backup[i] += allcards.get(j).charAt(i);
                        }
                    }
                    
                    int tmpnum = 0;
                    while(!generated)
                    {
                    mycac = "";
                    for(int i = 0; i < 50; ++i)
                    {   
                        mycac += (char)(backup[i] + (char) rand.nextInt(256));
                    }
                    cardno += rand.nextInt();
                    pin += rand.nextInt();
                    pin = pin % 10000;
                    for(int j = 0; j < allcards.size() && !generated;++j)
                    {
                        if(allcards.get(j).equals(mycac))
                        {
                            generated = true;
                        }
                        tmpnum = (int) allcardno.get(j);
                        if(cardno == tmpnum)
                        {
                            generated = true;
                        }
                    }
                        
                    }
                    ///////////////////////////////////////////////CARDNOHAVESPECIFIC LEGNTH////////////////////////////////////////////////////
                    a.setAtmCard(new ATMCardDetail(pin,"Basic",d,newdate,mycac,Integer.toString(cardno),a.getOwner()));
                    mymessage = "Account " + a.getAccountNumber() + " has a new ATM Card with card number " + cardno + " and with an expiry at " + newdate.toString();
                }
            }
        }
        return mymessage;
    }

    /**
     * @param requestnumber 
     * @param type 
     * @return
     */
    public Boolean approvecardextension(int requestnumber, int type) {
        Boolean accepted = false;
        List<String> al = new LinkedList<String>();
        if(requestnumber>=0)
        {
            if(type == 0)
            {
                al = manages.getThebank().getCreditCardExtensionRequests();
            }
            else if(type == 1)
            {
                al = manages.getThebank().getATMCardExtensionRequests();
            }
            if(requestnumber<al.size())
            {
                String tofind = al.get(requestnumber);
                Account a = null;
                Account tmp = null;
                ArrayList all = manages.getThebank().getAccountList();
                for(int i = 0; i < all.size() && a != null; ++i)
                {
                    tmp = (Account) all.get(i);
                    if(tmp.getAccountNumber().equals(tofind))
                    {
                        a = tmp;
                    }
                }
                if(a != null)
                {
                    LocalDateTime l = LocalDateTime.now();
                    ZoneId zoneId = ZoneId.systemDefault();
                    Date newdate = new Date(l.plusDays(manages.getThebank().getCreditcardduration()).atZone(zoneId).toEpochSecond()*1000);
                    accepted = true;
                    if(type == 0)
                    {
                        a.getCreditCard().setexpiryDate(newdate);
                    }
                    else if(type == 1)
                    {
                        a.getAtmCard().setexpiryDate(newdate);
                    }
                }
            }
        }
        return accepted;
    }

    /**
     * @param requestnumber 
     * @param creditlimit 
     * @return
     */
    public String approvecreditcard(int requestnumber, double creditlimit) {
        String mymessage = "Could not find any requests";
        ArrayList r = manages.getThebank().getCreditCardRequests();
        if(r.size() != 0)
        {
            mymessage = "Your request was invalid";
            if(requestnumber < 0 || requestnumber >= r.size())
            {
                mymessage = "Account could not londer be found";
                Account a = null;
                String tofind = (String) r.get(requestnumber);
                Account tmp = null;
                ArrayList al = manages.getThebank().getAccountList();
                for(int i = 0; i < al.size() && a != null; ++i)
                {
                    tmp = (Account) al.get(i);
                    if(tmp.getAccountNumber().equals(tofind))
                    {
                        a = tmp;
                    }
                }
                if(a != null)
                {
                    Random rand =  new Random();
                    
                    Date d = new Date();
                    LocalDateTime l = LocalDateTime.now();
                    ZoneId zoneId = ZoneId.systemDefault();
                    Date newdate = new Date(l.plusDays(manages.getThebank().getCreditcardduration()).atZone(zoneId).toEpochSecond()*1000);
                    
                    Boolean generated = false;
                    ArrayList all = manages.getThebank().getAccountList();
                    List<String> allcards = new LinkedList<String>();
                    ArrayList allcardno = new ArrayList();
                    String mycac = "";
                    int cardno = 0;

                    for(int i = 0; i < all.size();++i)
                    {
                        tmp = (Account) all.get(i);
                        if(tmp.getCreditCard() != null)
                        {
                            allcards.add(tmp.getCreditCard().getCAC());
                            cardno+=Integer.parseInt(tmp.getCreditCard().getCardNumber()); //////////////////////////////////////card no length
                            allcardno.add(tmp.getCreditCard().getCardNumber());
                        }
                    }
                    
                    char[] backup = new char[256];
                    for(int i = 0; i < 50; ++i)
                    {   
                        backup[i] = (char) rand.nextInt(256);
                        for(int j = 0; j < allcards.size();++j)
                        {
                            backup[i] += allcards.get(j).charAt(i);
                        }
                    }
                    
                    int tmpnum = 0;
                    while(!generated)
                    {
                    mycac = "";
                    for(int i = 0; i < 50; ++i)
                    {   
                        mycac += (char)(backup[i] + (char) rand.nextInt(256));
                    }
                    cardno += rand.nextInt();
                    for(int j = 0; j < allcards.size() && !generated;++j)
                    {
                        if(allcards.get(j).equals(mycac))
                        {
                            generated = true;
                        }
                        tmpnum = (int) allcardno.get(j);
                        if(cardno == tmpnum)
                        {
                            generated = true;
                        }
                    }
                        
                    }
                    a.setCreditCard(new CreditCardDetail(creditlimit,0,"Basic",d,newdate,mycac,Integer.toString(cardno),a.getOwner()));
                    mymessage = "Account " + a.getAccountNumber() + " has a new Credit Card with card number " + cardno + " and with an expiry at " + newdate.toString();
                }
            }
        }
        return mymessage;
    }

    /**
     * @param loanid 
     * @param updated 
     * @return
     */
    public Boolean editloan(int loanid, Loan updated) {
        // TODO implement here
        ArrayList<Loan> g = manages.getLoanlist();
        Boolean succeeded = false;
        if(loanid >= 0 && loanid < g.size())
        {        
                Loan given = g.get(loanid);
                Instant instant = Instant.now(); //can be LocalDateTime
                ZoneId systemZone = ZoneId.systemDefault(); // my timezone
                ZoneOffset zo = systemZone.getRules().getOffset(instant);
                LocalDateTime start = LocalDateTime.ofEpochSecond((given.getDate().getTime()/1000),0,zo);
                LocalDateTime here =  LocalDateTime.ofEpochSecond((given.getMaturityDate().getTime()/1000),0,zo);
                int days = (int)start.until(here, ChronoUnit.DAYS);
                double original = manages.getTotalfunds();
                if(given.getApproval())
                {
                    manages.setTotalfunds((original+given.getAmmount())-given.getIsPaid());
                }
                if(updated == null || manageloans(updated))
                {
                    manages.deleteLoan(loanid);
                }
                else
                {
                    manages.setTotalfunds(original);
                }
        }
        return succeeded;
    }

    /**
     * @return
     */
    public ArrayList viewallloans() {
        return manages.getLoanlist();
    }

    /**
     * @return
     */
    public ArrayList viewalllockers() {
        // TODO implement here
        return manages.getLockerlist();
    }

    public Branch getManages() {
        return manages;
    }

    public void setManages(Branch manages) {
        this.manages = manages;
    }

    public ArrayList getApprovedBy() {
        return loans;
    }

    public void setApprovedBy(ArrayList ApprovedBy) {
        this.loans = ApprovedBy;
    }
    
    public void addEmployees(ArrayList<Employee> e)
    {
        for(int i = 0; i < e.size(); ++i)
        {
            manages.addEmployee(e.get(i));
        }
    }
    
    public Boolean deleteEmployee(String e)
    {
        Boolean deleted = false;
        Employee have = null;
        for(int i = 0; i < manages.getEmployeelist().size() && !deleted; ++i)
        {
            have = (Employee)manages.getEmployeelist().get(i);
            if(have.cnic.equals(e))
            {
                deleted = true;
                manages.DeleteEmployee(i);
            }
        }
        return deleted;
    }

}