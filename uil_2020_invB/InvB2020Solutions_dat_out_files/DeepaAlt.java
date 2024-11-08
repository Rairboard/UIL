/*
 *UIL Computer Science 2020
 *Invitational B Packet - Alternate Solution
 */
import java.util.*;
import java.io.*;
import static java.lang.System.*;
class DeepaAlt
{
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("deepa.dat"));
		int N = f.nextInt();
		int x = 1;
		while (x<=N)
		{
			int numBrackets = f.nextInt();
			double income = f.nextDouble();
			double Income = income;
			double brac[] = new double[numBrackets];
			double per[] = new double[numBrackets];
			for(int b = 0;b<numBrackets;b++)
			{
				brac[b]=f.nextDouble();
				per[b]=f.nextDouble();
			}
			double tax = 0.0;
			int b;
			double delta = 0;
			if(brac.length>1)
				delta = brac[1]-brac[0];
			for(b = 0;b<brac.length-1&&income>delta;b++)
			{
				tax+=(brac[b+1]-brac[b])*(per[b]/100);
				delta = brac[b+1]-brac[b];
				if(income>delta)
					income -= delta;
			}
			tax+=income*(per[b]/100);
			double fper = tax/Income*100;
			out.printf("Case #%d: $%,.2f %.3f%%\n",x,tax,fper);
			x++;
		}
		f.close();
	}
}