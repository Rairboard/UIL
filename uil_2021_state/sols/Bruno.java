/*
 *UIL Computer Science 2021
 *State Packet Solution
 */
import java.util.*;
import java.io.*;
class Bruno
{
	public static void main(String [] args)
		throws FileNotFoundException
	{
		Scanner f = new Scanner(new File("bruno.dat"));
		int count = 0;
		while(f.hasNext())
		{
			f.next();
			count++;
		}
		f.close();
		System.out.println(count);
	}
}