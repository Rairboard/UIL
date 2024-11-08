/*
 *UIL Computer Science 2020
 *Invitational B Packet - Alternate Solution
 */
import java.util.*;
import java.io.*;
import static java.lang.System.*;
class EmilioAlt
{
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("emilio.dat"));
		int N = f.nextInt();
		int x = 1;
		while (x<=N)
		{
			int d = f.nextInt();
			ArrayList dist = new ArrayList<Double>();
			while(d-->0)
				dist.add(f.nextDouble());
			Collections.sort(dist);
			double lowAvg = 0;
			double hiAvg = 0;
			for(int lo = 0;lo<10;lo++)
				lowAvg += (double)dist.get(lo);
			lowAvg/=10;				
			for(int hi = dist.size()-10;hi<dist.size();hi++)
				hiAvg += (double)dist.get(hi);
			hiAvg/=10;				
			out.printf("%d: %.1f\n",x,hiAvg);
			out.printf("%d: %.1f\n",x,lowAvg);
			
			out.println("------");
			x++;
		}
		f.close();
	}
}