import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class yeezy_BRL
{
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("yeezy.dat"));
		int times = file.nextInt();
		file.nextLine();
		
		for(int asdf = 0; asdf<times; asdf++)
		{
			if((double)(file.nextDouble()*43*20*.25) >= 2000.00) System.out.println("true");
			else System.out.println("false");
		}
	}
	public static void main(String[] args) throws Exception
	{
		new yeezy_BRL().run();
	}	
}