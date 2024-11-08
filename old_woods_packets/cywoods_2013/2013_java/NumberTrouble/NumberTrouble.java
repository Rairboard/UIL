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

public class NumberTrouble
{
	
	public void run()throws Exception
	{
		Scanner file = new Scanner(new File("judges.dat"));
		BigInteger[] f = new BigInteger[110];
        f[0] = BigInteger.ONE;
        f[1] = BigInteger.valueOf(2);
        
        for (int i=2; i<110; i++)
            f[i] = f[i-1].add(f[i-2]);
        boolean space = false;
        while(file.hasNext())
        {
            String s = file.next();
            BigInteger N = BigInteger.ZERO;
            for (int i=0; i<s.length(); i++)
                if ( s.charAt(i) == '1' )
                    N = N.add(f[s.length()-i-1]);
            
            String m = file.next();
            for (int i=0; i<m.length(); i++)
                if ( m.charAt(i) == '1' )
                    N = N.add(f[m.length()-i-1]);
            
            if(space) System.out.println();
            space = true;
            
            if(N.compareTo(BigInteger.ZERO) == 0)
            {
                System.out.println("0");
                continue;
            }
            
            boolean flag = false;
            for (int i=109; i>=0; i--)
            {
                if(N.compareTo(f[i])>= 0)
                {
                    System.out.print("1");
                    N = N.subtract(f[i]);
                    flag = true;
                }
                else if(flag) System.out.print("0");
            }
            System.out.println();
        }
	}
	
	public static void main(String[] args)throws Exception
	{
		NumberTrouble a=new NumberTrouble();
		a.run();
	}	
}