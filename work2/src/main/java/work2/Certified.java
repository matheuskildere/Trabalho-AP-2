package work2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Certified {
    private String dateGeration;
    private int codeUnit = 1222;

    public String getDateGeration() {
        return this.dateGeration;
    }

    public int getCodeUnit() {
        return this.codeUnit;
    }

    public String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }    

}