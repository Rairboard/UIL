import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

			//change the class name
public class Factorfact_BJR
{
	int num;
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("factor.dat"));
		
			//read in the number at the top of the data file
		int times = file.nextInt(); 
			//pick up the left over enter key
		file.nextLine();
		
			//read in each data set
		for(int asdf = 0; asdf<times; asdf++)
		{
			num = file.nextInt();
			for(int i = 1;i<=num;i++)
			{
				if(num%i==0)
				{
					out.print(i + " : ");
					factor(i);
					out.println();
				}
			}
			out.println();
		}
	}
	public void factor(int n)
	{
		for(int i = 1;i<=n;i++)
			{
				if(num%i==0)
				{
					out.print(i + " ");
					
				}
			}
	}

	public static void main(String[] args) throws Exception
	{
			//change this to whatever your class name is
		new Factorfact_BJR().run();
	}	
	
}