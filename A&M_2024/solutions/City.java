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


public class City
{
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("city.dat"));
		int reps = file.nextInt();
		for(int q=0; q<reps; q++)
		{
			int day = file.nextInt();
			int month = file.nextInt();
			Calendar cal = new Calendar.Builder().setDate(2023,4,14).build();
			Calendar temp = new Calendar.Builder().setDate(2023,month,day).build();
			
		
			if((Math.abs(cal.get(Calendar.DAY_OF_YEAR))-temp.get(Calendar.DAY_OF_YEAR))<=30) {
				System.out.println("outstanding work gentlemen");
			}
			else {
				System.out.println("this is the worst of all possible worlds");
			}
		}
	}

	public static void main(String[] args)throws Exception
	{
		City a=new City();
		a.run();
	}

}