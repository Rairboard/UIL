import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

			//change the class name
public class three
{
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("three.txt"));
		
			//read in the number at the top of the data file
		int times = file.nextInt(); 
			//pick up the left over enter key
		file.nextLine();
		
			//read in each data set
		for(int asdf = 0; asdf<times; asdf++)
		{
			Scanner x = new Scanner (file.nextLine());
			int max = Integer.MIN_VALUE;
			while (x.hasNext())
			{
				int num = x.nextInt();
				max = Math.max(num, max);
			}
			if (max % 2 == 0)
				System.out.println(max/2);
			else
				System.out.println(3*max+1);
		}
	}

	public static void main(String[] args) throws Exception
	{
			//change this to whatever your class name is
		new three().run();
	}	
	
}