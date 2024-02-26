import java.io.*;
import java.util.*;
import java.text.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Character.*;
import static java.util.Collections.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import java.math.BigInteger;

public class EthiopianDivision {

    public void run()throws Exception
    {
    	Scanner file = new Scanner(new File("ethiopiandivision.dat"));
        int x, y, z;
        while(file.hasNextInt()) {
        	x = file.nextInt();
            y = file.nextInt();
            z = file.nextInt();
            System.out.printf("(%d^%d-1)/(%d^%d-1) ", x, y, x, z);
            if(x == 1) {
            	System.out.println("isn't an integer containing 100 digits or less.");
                continue;
            }
            if(y == z) {
            	System.out.println("1");
            	continue;
            }
            if(y%z != 0) {
            	System.out.println("isn't an integer containing 100 digits or less.");
                continue;
            }
            if((y-z)*Math.log10(x) > 99) {
           		System.out.println("isn't an integer containing 100 digits or less.");
                continue;
            }
            
            BigInteger q, w, temp;
            q = BigInteger.valueOf(x);
            w = BigInteger.valueOf(x);
            q = q.pow(y);
            w = w.pow(z);
            q = q.subtract(BigInteger.valueOf(1));
            w = w.subtract(BigInteger.valueOf(1));
            if(w.compareTo(BigInteger.valueOf(0)) == 0) {
            	System.out.println("isn't an integer containing 100 digits or less.");
                continue;
            }
            temp = q.mod(w);
            q = q.divide(w);
            System.out.println(q.toString());
       }

  	}   
    public static void main(String[] args)throws Exception{
    	EthiopianDivision a = new EthiopianDivision();
    	a.run();
    }
}