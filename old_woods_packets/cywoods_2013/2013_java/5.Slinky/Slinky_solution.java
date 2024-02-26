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


class template
{
	//instance variables go here

	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("Slinky_judges.dat"));
		int cnt = file.nextInt();
		file.nextLine();
		for(int i = 0; i < cnt; i++){
			double k = file.nextDouble();
			double x = file.nextDouble();
			double pe = .5*k*Math.pow(x,2.0);
			System.out.println(pe);
			
			
		}
	}

	public static void main(String[] args)throws Exception
	{
		template a=new template();
		a.run();
	}
}