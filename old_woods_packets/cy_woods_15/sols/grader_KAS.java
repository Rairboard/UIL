import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

		
public class grader_KAS
{
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("grader.dat"));
	
		int times = file.nextInt();
		file.nextLine();
	    double a=89.5;
	    double b=79.45;
	    double c=69.45;
	    double f=0;
		
		for(int asdf = 0; asdf<times; asdf++)
		{   
			String name=file.next();
			double grade=file.nextDouble();
			if (grade>=a)
			System.out.println("A "+name);
			else if (grade>=b)
			System.out.println("B "+name);	
			else if (grade>=c)
			System.out.println("C "+name);
			else System.out.println("F " +name);
		}
	}

	public static void main(String[] args) throws Exception
	{
			//change this to whatever your class name is
		new grader_KAS().run();
	}	
	
}