/*
 *UIL Computer Science 2020
 *Invitational B Packet Alternate Solution
 */
import static java.lang.System.*;
import java.util.*;
import java.io.*;
public class BriannaAlt
{
	public static void main(String args[]) throws IOException
	{
		Scanner f = new Scanner(new File("brianna.dat"));
		int num = f.nextInt();
		int min=num, max=num, range;
		while(f.hasNext())
		{
			num = f.nextInt();
			if(num<min)min=num;
			if(num>max)max=num;
		}
		range = max-min;
		out.println(min+" "+max+" "+range);
	}
}