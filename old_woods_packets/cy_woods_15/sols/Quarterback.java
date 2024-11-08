import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

			//change the class name
public class Quarterback
{
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("quarterback.dat"));
		
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
			Scanner line = new Scanner(file.nextLine());
			int c = line.nextInt(); //completions
			int a = line.nextInt(); //attempts
			int i = line.nextInt();  //interceptions 
			int y = line.nextInt(); //yards
			int t = line.nextInt(); //touchdowns
			
			double ac = acalc(c,a);
			double bc = bcalc(y,a);
			double cc = ccalc(t,a);
			double dc = dcalc(i,a);
			double rate = rating(ac,bc,cc,dc);
			
			System.out.printf("%.2f", rate);
			System.out.println();
			
		}
	}
	
	public double acalc(int c, int a)
	{
		double one = (double) c/a;
		double two = one - 0.3;
		double three = two *5;
		return three;
	}
	
		public double bcalc(int y, int a)
	{
		double one = (double) y/a;
		double two = one - 3;
		double three = two /4;
		return three;
	}
	
			public double ccalc(int t, int a)
	{
		double one = (double) t/a;
		double two = one *20;
		return two;
	}
	
			public double dcalc(int i, int a)
	{
		double one = (double) i/a;
		double two = one * 25;
		double three = 2.375 - two;
		return three;
	}
	
		public double mm(double x)
	{
	      return Math.max(0,Math.min(x,2.375));
	
	}
	
    	public double rating(double a, double b, double c, double d)
	{  
		double one = mm(a) + mm(b) + mm(c) + mm(d);
		double two = (double) one/6;
		double three = two *100;
	    return three;
	}

	public static void main(String[] args) throws Exception
	{
			//change this to whatever your class name is
		new Quarterback().run();
	}	
	
}