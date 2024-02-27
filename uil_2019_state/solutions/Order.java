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


public class Order
{
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("order.dat"));
		int reps = file.nextInt();
		
		for(int q=0; q<reps; q++)
		{
			String str = file.next();
			
	        int n = str.length();
	        
	        System.out.println(cSub(str, 0, n - 1, n));
		}
	}
	static int cSub(String str, int a, int b, int n)
		{
		// base cases
		if (n==1) {
			return 1;
		}
		if (n<=0) {
			return 0;
		}
		
		int res = cSub(str, a + 1, b, n - 1) +
				
		cSub(str, a, b - 1, n - 1) -
		
		cSub(str, a + 1, b - 1, n - 2);        
		
		if (str.charAt(a) == str.charAt(b)) {
			res++;
		}
		
		return res;
		}

	public static void main(String[] args)throws Exception
	{
		Order a=new Order();
		a.run();
	}

}