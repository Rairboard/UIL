/*
 *UIL Computer Science 2020
 *Invitational B Packet - Alternate Solution
 */
import java.util.*;
import java.io.*;
import static java.lang.System.*;
class IreneAlt
{
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("irene.dat"));
		int N = f.nextInt();
		
		while (N-->0)
		{
			int num = f.nextInt();
			out.print(num+" ");
			if(isDisc(num))
				out.println("DISCRETE SEMIPRIME");
			else
			if(isSemi(num))
				out.println("SEMIPRIME");
			else
				out.println("NOT SEMIPRIME");
		}
		f.close();
	}
	static boolean isSemi(int i)
	{
		for(int x = 2;x<=Math.sqrt(i);x++)
			if(isPrime(x) && i%x == 0 && isPrime(i/x))
				return true;
		return false;
	}
	static boolean isDisc(int i)
	{
		int sq = (int)Math.sqrt(i);
		if(isSemi(i) && Math.pow(sq,2)!=i)
			return true;
		return false;
	}
	static boolean isPrime(int i)
	{
		for(int x=2;x<=(int)Math.sqrt(i);x++)
			if(i%x==0)
				return false;
		return true;
	}
}