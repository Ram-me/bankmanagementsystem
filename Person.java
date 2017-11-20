package backend;
import java.util.*;

/**
 * 
 */
public abstract class Person {

    protected String cnic;
    protected String name;
    protected String email;
    protected String currentaddress;
    protected String residentialaddress;
    protected String mobilenumber;
    protected String telephonenumber;

    public Person(String cnic, String name, String email, String currentaddress, String residentialaddress, String mobilenumber, String telephonenumber) {
        this.cnic = cnic;
        this.name = name;
        this.email = email;
        this.currentaddress = currentaddress;
        this.residentialaddress = residentialaddress;
        this.mobilenumber = mobilenumber;
        this.telephonenumber = telephonenumber;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurrentaddress() {
        return currentaddress;
    }

    public void setCurrentaddress(String currentaddress) {
        this.currentaddress = currentaddress;
    }

    public String getResidentialaddress() {
        return residentialaddress;
    }

    public void setResidentialaddress(String residentialaddress) {
        this.residentialaddress = residentialaddress;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getTelephonenumber() {
        return telephonenumber;
    }

    public void setTelephonenumber(String telephonenumber) {
        this.telephonenumber = telephonenumber;
    }

    
}