package work2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * The {@code Certified} is responsible for collecting system date 
 * to certified and generate certificate identification code.
 */
public class Certified {

    /**
     * This class has the function to generate a new code 
     * identifier for the certificate from the last generated.
     * @return the codeUnitCertified
     */
    public int getCodeUnit() throws IOException {
        FileInputStream fileCodeUnit = new FileInputStream("./codeUnitCertified/code.dat");
        DataInputStream searchCode = new DataInputStream(fileCodeUnit);
        int codeUnitCertified = searchCode.readInt() + 1;
        FileOutputStream fileCodeUnit1 = new FileOutputStream("./codeUnitCertified/code.dat");
        DataOutputStream saveNewCode = new DataOutputStream(fileCodeUnit1);
        saveNewCode.writeInt(codeUnitCertified);
        searchCode.close();
        saveNewCode.close();
        return codeUnitCertified;
    }
    /**
     * This class has the function to get current system date dor program.
     * @return the dateFormat.format(date)
     */
    public String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
    /**
     * This class has the function to get current system date for certified.
     * @return the dateGeration.format(date)
     */
    public String getDateGeration() {
        DateFormat dateGeration = new SimpleDateFormat("dd 'de ' MMMM 'de' yyyy");
        Date date = new Date();
        return dateGeration.format(date);
    }
}