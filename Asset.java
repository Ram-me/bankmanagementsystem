/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;
import java.util.*;

public class Asset {
    private String type;
    private double value;
    private double inspectedvalue;

    Asset() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public double evaluate(float ratio) {
       //??
       
       return 0.0;
    }

    public Asset(String type, double value, double inspectedvalue) {
        this.type = type;
        this.value = value;
        this.inspectedvalue = inspectedvalue;
    }

    public String getType() {
        return type;
    }

    public double getValue() {
        return value;
    }

    public double getInspectedvalue() {
        return inspectedvalue;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setInspectedvalue(double inspectedvalue) {
        this.inspectedvalue = inspectedvalue;
    }
     
    
    
}