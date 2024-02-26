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


class temp
{
	//instance variables go here
	

	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("Blackpearl.dat"));
		Scanner chop = new Scanner("");
		
		char[][] ocean = new char[11][23];
		String first = "";
		String line = "";
		int r = 0;
		int c = 0;
		
		int numtimes = file.nextInt();
		file.nextLine();
		
		for(int y = 0; y < numtimes; y++)
		{
			for(int x = 0; x < 11;x++)
			{
				line = file.nextLine();
				ocean[x] = line.toCharArray();
			//	System.out.println(ocean[x]);
			}
			
			
			int numPnts = file.nextInt();
			file.nextLine();
			
			for(int z = 0; z < numPnts; z++)
			{
				line = file.nextLine();
				r = Integer.parseInt(line.substring(1,2));
				first = line.substring(0,1);
				r++;
				if(first.equals("A"))
				{
					c = 3;
				}
				else if(first.equals("B"))
				{
					c = 5;
				}
				else if(first.equals("C"))
				{
					c = 7;
				}
				else if(first.equals("D"))
				{
					c = 9;
				}
				else if(first.equals("E"))
				{
					c = 11;
				}
				else if(first.equals("F"))
				{
					c = 13;
				}
				else if(first.equals("G"))
				{
					c = 15;
				}
				else if(first.equals("H"))
				{
					c = 17;
				}
				else if(first.equals("I"))
				{
					c = 19;
				}
				else
				{
					c = 21;
				}
				
			//	System.out.println(r+" "+c);
			
				
				if(ocean[r][c] == '~')
				{
					System.out.println("MISS");
				}
				else
				{
					System.out.println("HIT!");
				}
				
			}
		}
		
		
	}

	public static void main(String[] args)throws Exception
	{
		temp a=new temp();
		a.run();
	}
}