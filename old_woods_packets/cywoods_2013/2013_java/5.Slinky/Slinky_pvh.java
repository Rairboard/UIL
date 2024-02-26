import java.io.*;
import java.util.*;
import java.text.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Character.*;
import static java.util.Collections.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;


class Slinky
{
	//instance variables go here

	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("Slinky_judges.dat"));
		int count = file.nextInt();
		file.nextLine();
		for (int a = 0 ; a < count; a++)
		{
			double d = file.nextDouble();
			//System.out.println(d);
			double x = Math.pow(file.nextInt(),2);
			//System.out.println(x);
			System.out.println(((d)*(x))/2);
		}
	}

	public static void main(String[] args)throws Exception
	{
		Slinky a=new Slinky();
		a.run();
	}
}