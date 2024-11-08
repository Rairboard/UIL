import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

			//change the class name
public class Grader_BGN
{
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("judgegrader.dat"));
		
			//read in the number at the top of the data file
		int times = file.nextInt(); 
			//pick up the left over enter key
		file.nextLine();
		
			//read in each data set
		for(int asdf = 0; asdf<times; asdf++)
		{
			String line = file.nextLine();
			Scanner chop = new Scanner(line);
			String name = chop.next();
			double grade = chop.hasNextDouble() ? chop.nextDouble() : (double)chop.nextInt();
			System.out.println((grade >= 89.5 ? "A" : grade >= 79.45 ? "B" : grade >= 69.45 ? "C" : "F") + " " + name);
		}
	}

	public static void main(String[] args) throws Exception
	{
			//change this to whatever your class name is
		new Grader_BGN().run();
	}	
	
}