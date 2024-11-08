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
		Scanner file=new Scanner(new File("Slinky.dat"));
		int times = file.nextInt();
		file.nextLine();
		for(int n=0;n<times;n++)
		{
			String[] ls = file.nextLine().split(" ");
			double k = parseDouble(ls[0]);
			double x = parseDouble(ls[1]);
			double outp = .5*k*x*x;
			out.println(outp);
		}
	}

	public static void main(String[] args)throws Exception
	{
		Slinky a=new Slinky();
		a.run();
	}
}