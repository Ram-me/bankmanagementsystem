package backend;
import java.io.File;
import java.nio.file.Files;
import java.util.*;

/**
 * 
 */
public class Converter {

    private Branch location;
    private Date date;
    private double ammount;
    private String currencybought;
    private String currencysold;

    public Converter(Branch location, Date date, double ammount, String currencybought, String currencysold) {
        this.location = location;
        this.date = date;
        this.ammount = ammount;
        this.currencybought = currencybought;
        this.currencysold = currencysold;
    }

    /**
     * @param ammount 
     * @param currencybought 
     * @param currencysold 
     * @return
     */
    public Boolean convert(double ammount, String currencybought, String currencysold) {
        Boolean converted = false;
        Boolean corrupt = false;
        if(!currencybought.contains("=")&&!currencysold.contains("="))
        {

        File f = new File(location.getTotalcurrencies());
        
        List<String> ls = new LinkedList<String>();
        try
        {
            ls = Files.readAllLines(f.toPath());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        String[] reading = null; 
        for(int i = 0; i < ls.size() && !converted && !corrupt; ++i)
        {
            reading = ls.get(i).split(currencysold);
            if(reading.length == 3)
            {
                if(reading[0].trim().toLowerCase().equals(currencybought.toLowerCase())&&reading[1].trim().toLowerCase().equals(currencysold.toLowerCase()))
                {
                    converted = true;
                    currencysold= currencysold+"="+Double.toString(ammount);
                    ammount=Double.parseDouble(reading[2].trim())*ammount;
                    currencybought= currencybought+"="+Double.toString(ammount);
                }
                else
                {
                    corrupt = true;
                }
            }
        }
        }  
        return converted;
    }

    /**
     * 
     */
    private void readfile() {
        // TODO implement here
    }

    public Branch getLocation() {
        return location;
    }

    public Date getDate() {
        return date;
    }

    public double getAmmount() {
        return ammount;
    }

    public String getCurrencybought() {
        return currencybought;
    }

    public String getCurrencysold() {
        return currencysold;
    }


}