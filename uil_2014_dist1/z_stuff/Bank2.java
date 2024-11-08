//alternate solution
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;
public class Bank2 
{
    public static void main(String args[]) throws IOException 
    {
        Scanner f = new Scanner(new File("bank.dat"));
        int n = f.nextInt();
        f.nextLine();
        while(n-->0)
        {
        	String s = f.nextLine();
        	args = s.split("[^0-9]+");
        	int sum=0;
        	if(args.length>0)
        	{
        		for(String a:args)
	        		if(a.length()>0)
	        		{
	        			int x=Integer.parseInt(a);
	        			out.print(x+" ");
	        			sum+=x;
	        		}
        	}
        	else
        		out.print("-");
        	out.println("\n"+sum);
        }
    }
}
/*
Test data:
11
Stanley worked for a company in a big building as employee number 427.
Employee 427's job was simple: he sat in room 427 and worked at his desk.
Stanley was happy.
That coffee will cost you $4.20.
Linux L1 3.5.0-45-generic #68-Ubuntu SMP Mon Dec 2 21:58:52 x86_64 GNU/Linux
2,014 CE
PI, the ratio 4.23 of the circumference  of a circle to its diameter, or
3.1415 926 5,35 - and this  is just the  beginning. It keeps on going, 
forever, without 1 2 3 4 ever repeating, which means that contained within
this string 4.3 of decim 09 als is  every 03.020 single other  number
:D

Output:
427
427
427 427
854
-
0
4 20
24
1 3 5 0 45 68 2 21 58 52 86 64
405
2 14
16
4 23
27
3 1415 926 5 35
2384
1 2 3 4
10
4 3 9 3 20
39
-
0
*/