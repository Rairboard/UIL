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


public class dads
{
	//instance variables go here
	private TreeMap<String, String> dads = new TreeMap<String, String>();
	
	public void run()throws Exception
	{
		PrintWriter write=new PrintWriter(new FileWriter(new File("dadssolution.dat")));
		Scanner file=new Scanner(new File("judgedads.dat"));
		int cases = file.nextInt();
		file.nextLine();
		for(int runs = 0; runs<cases; runs++)
		{
			int students = file.nextInt();
			file.nextLine();
			for(int axe = 0; axe<students; axe++)
			{
				String dad = file.nextLine();
				String subdad = file.nextLine();
				dads.put(dad,subdad);
			}				
			int tests = file.nextInt();
			file.nextLine();
			for(int cnt = 0; cnt<tests; cnt++)
			{
				String dad = file.nextLine();
				String compare = file.nextLine();
				if(fight(dad,compare))
				{
					write.println(dad+"'s dad can beat up "+compare+"'s dad.");
				}
				else
				{
					write.println(dad+"'s dad isn't bad enough.");
				}				
			}
			dads.clear();
			write.println();
		}
		write.close();
	}
	
	public boolean fight(String key, String val)
	{
		if(dads.containsKey(key))
		{
			return dads.get(key).equals(val) || fight(dads.get(key),val);
		}
		else
		{
			return false;
		}
	}

	public static void main(String[] args)throws Exception
	{
		dads a=new dads();
		a.run();
	}
}