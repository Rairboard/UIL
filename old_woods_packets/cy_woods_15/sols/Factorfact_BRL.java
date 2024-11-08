import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class Factorfact_BRL
{
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("factor.dat"));
		int times = file.nextInt(); 
		file.nextLine();
		for(int asdf = 0; asdf<times; asdf++)
		{
			int hold = file.nextInt();
			for(int i = 1; i <= hold; i++)
			{
				int possib = hold % i;
				if(possib == 0)
				{
					System.out.print("" + i + " : ");
					for(int j = 1; j <= i; j++)
					{
						int fac = i % j;
						if(fac == 0)
							System.out.print(" " + j);	
					}
					System.out.println();
				}	
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws Exception
	{
		new Factorfact_BRL().run();
	}	
	
}