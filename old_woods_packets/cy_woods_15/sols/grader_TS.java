package Contest_Problems;
import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

			//change the class name
public class grader_TS
{
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("grader.dat"));
		
			//read in the number at the top of the data file
		int times = file.nextInt(); 
			//pick up the left over enter key
		file.nextLine();
		double grade = 0;
		String name = "";
		
			//read in each data set
		for(int asdf = 0; asdf<times; asdf++)
		{
			name = file.next();
			grade = file.nextDouble();
			
			if(grade <= 69.44)
				System.out.println("F " + name);
			else if(grade <= 79.44 && grade >= 69.45)
				System.out.println("C " + name);
			else if(grade <= 89.49 && grade >= 79.45)
				System.out.println("B " + name);
			else 
				System.out.println("A " + name);
		}
	}

	public static void main(String[] args) throws Exception
	{
			//change this to whatever your class name is
		new grader_TS().run();
	}	
	
}