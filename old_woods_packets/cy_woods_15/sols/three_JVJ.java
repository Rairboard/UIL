import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class three_JVJ
{
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("three.txt"));
		int times = file.nextInt(); 
		file.nextLine();
		
		for(int x = 0;x < times;x++)
		{
			Scanner chop = new Scanner(file.nextLine());
			int max = 0;
			while(chop.hasNext())
			{
				int out = chop.nextInt();
				max = Math.max(out, max);
				if(out > max)
				{
					max = out;
				}
				else
				{
					max = max;
				}
			}
			if (max % 2 == 0)
			{
				System.out.println(max/2);
			}
			else
			{
				System.out.println(3*max+1);
			}	
		}
	}
	public static void main(String[] args) throws Exception
	{
		new three_JVJ().run();
	}		
}