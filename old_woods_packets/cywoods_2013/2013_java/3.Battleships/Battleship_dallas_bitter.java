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


public class Battleship
{
	//instance variables go here
	String[][] mat = new String[10][10];

	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("Blackpearl.dat"));
		int bob = file.nextInt();
		file.nextLine();
		for(int jim = 0; jim<bob; jim++)
		{
			file.nextLine();
			for(int i = 0; i<10; i++)
			{
				String line = file.nextLine().substring(3);
				mat[i] = line.split("\\|");
			}
			int tests = file.nextInt();
			file.nextLine();
			for(int i = 0; i<tests; i++)
			{
				String loc = file.nextLine();
				String there = mat[Integer.parseInt(""+loc.charAt(1))][loc.charAt(0)-65];
				if(there.equals("~"))
				{
					out.println("MISS");
				}
				else
				{
					out.println("HIT!");
				}
			}
				
		}
	}

	public static void main(String[] args)throws Exception
	{
		Battleship a=new Battleship();
		a.run();
	}
}