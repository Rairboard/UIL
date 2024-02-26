import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

		
public class yeezy
{
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("yeezy.dat"));
		int times = file.nextInt();
		file.nextLine();
		
		for(int asdf = 0; asdf<times; asdf++)
		{
			double wage= file.nextDouble();
			double week= wage*43;
			double save= week/4;
			System.out.println(tOf(save));
		}
		
		
	}
	
	public boolean tOf(double save)
	{
		if ((2000/save)<20.0==true)
		return true;
		return false;
	}

	public static void main(String[] args) throws Exception
	{
			//change this to whatever your class name is
		new yeezy().run();
	}	
	
}