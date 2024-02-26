import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

			//change the class name
public class myYeezy
{
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("yeezy.dat"));
		
			//read in the number at the top of the data file
		int times = file.nextInt(); 
			//pick up the left over enter key
		file.nextLine();
		int totalHours = 5 * 4 * 43;
			//read in each data set
		for(int asdf = 0; asdf<times; asdf++)
		{
			double wage = file.nextDouble();
			if ((wage*totalHours) * .25 > 2000)
				System.out.println("true");
			else 
				System.out.println("false");
		}
	}

	public static void main(String[] args) throws Exception
	{
			//change this to whatever your class name is
		new myYeezy().run();
	}	
	
}