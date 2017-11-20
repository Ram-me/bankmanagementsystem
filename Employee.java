package backend;
import java.util.*;

/**
 * 
 */
public abstract class Employee extends Person {

    protected int ssn;
    protected String designation;
    protected DepartmentType department;
    protected Double salary;
    protected LoginDetail credentials;
    protected Branch worksIn;

    public Employee(int ssn, String designation, DepartmentType department, Double salary, LoginDetail credentials, Branch worksIn, String cnic, String name, String email, String currentaddress, String residentialaddress, String mobilenumber, String telephonenumber) {
        super(cnic, name, email, currentaddress, residentialaddress, mobilenumber, telephonenumber);
        this.ssn = ssn;
        this.designation = designation;
        this.department = department;
        this.salary = salary;
        this.credentials = credentials;
        this.worksIn = worksIn;
    }

    /**
     * 
     */
    public void login() {
        // TODO implement here
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public DepartmentType getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentType department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LoginDetail getCredentials() {
        return credentials;
    }

    public void setCredentials(LoginDetail credentials) {
        this.credentials = credentials;
    }

    public Branch getWorksIn() {
        return worksIn;
    }

    public void setWorksIn(Branch worksIn) {
        this.worksIn = worksIn;
    }

}