import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

		
public class yeezy_BJR
{
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("yeezy.dat"));
		int times = file.nextInt();
		file.nextLine();
		int hours = 43;
		int weeks = 20;
		for(int asdf = 0; asdf<times; asdf++)
		{
			double pay = file.nextDouble();
			if(hours*pay*weeks/4>=2000)
				out.println("True");
			else
				out.println("False");
		}
		
		
	}

	public static void main(String[] args) throws Exception
	{
			//change this to whatever your class name is
		new yeezy_BJR().run();
	}	
	
}