import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

			//change the class name
public class Factorfact_BGN
{
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
			int num = file.nextInt();
			for (int i = 1; i <= num; i++) {
				if (num % i == 0) {
					System.out.print(i + " :");
					for (int j = 1; j <= i; j++) {
						if (i % j == 0) {
							System.out.print(" " + j);
						}
					}
					System.out.println();
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws Exception
	{
			//change this to whatever your class name is
		new Factorfact_BGN().run();
	}	
	
}