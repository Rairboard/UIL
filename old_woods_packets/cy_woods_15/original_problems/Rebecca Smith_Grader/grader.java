import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

			//change the class name
public class grader
{
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("grader.dat"));
		
			//read in the number at the top of the data file
		int times = file.nextInt(); 
			//pick up the left over enter key
		file.nextLine();
		//while(file.hasNextLine())
		//{
			
		//} 
			//read in each data set
		for(int asdf = 0; asdf<times; asdf++)
		{
			Scanner line = new Scanner (file.nextLine());
			{
				String name = line.next();
				String lettergrade = grade(line.nextDouble());
				System.out.println(lettergrade+ " "+ name);
			}
			
		}
	}
	
	public String grade (double x)
	{
		if (x>= 89.5) return "A";
		if (x>= 79.45 && x<= 89.49) return "B";
		if( x>= 69.45 && x<= 79.44) return "C";
		return "F";
	}

	public static void main(String[] args) throws Exception
	{
			//change this to whatever your class name is
		new grader().run();
	}	
	
}