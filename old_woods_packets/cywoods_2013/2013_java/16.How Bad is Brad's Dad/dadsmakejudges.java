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


public class dadsmakejudges
{
	//instance variables go here
	String[] names = "Bob Jim Jake Bill Joel Pedro Robert Alex George Georgette Brett John Robin Yugi Yu Shaquille Matt Brad Dallas Maddie Rebecca Hannah Aylie Darrin Darius Tristana Graves Zac Rachel Tesla Nikola Luke Anakin Yoda".split(" ");

	public void run()throws Exception
	{
		PrintWriter file=new PrintWriter(new FileWriter((new File("dadjudgestest.dat"))));		
		int sets = 10;
		for(int times = 0; times<sets; times++)
		{
			ArrayList<String> thesenames = new ArrayList<String>();
			int numnames = (int)(Math.random()*names.length);
			file.println(numnames);
			int a = (int)(Math.random()*names.length);
			for(int i = 0; i<numnames; i++)
			{
				file.println(names[a]);
				thesenames.add(names[a]);
				int b = (int)(Math.random()*names.length);
				while(b==a || thesenames.indexOf(names[b])!=-1)
				{
					b = (int)(Math.random()*names.length);
				}
				file.println(names[b]);
				a = b;
			}
			int tests = (int)(Math.random()*numnames);
			/*while(tests==0)
			{
				tests = (int)(Math.random()*numnames);
			}*/
			file.println(tests);
			for(int i = 0; i<tests; i++)
			{
				a = (int)(Math.random()*thesenames.size());
				file.println(thesenames.get(a));
				int b = (int)(Math.random()*thesenames.size());
				while(b==a)
				{
					b = (int)(Math.random()*thesenames.size());
				}
				file.println(thesenames.get(b));	
			}
			thesenames.clear();
		}
		file.close();
	}

	public static void main(String[] args)throws Exception
	{
		dadsmakejudges a=new dadsmakejudges();
		a.run();
	}
}