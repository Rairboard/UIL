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
import static java.util.GregorianCalendar.*;



class DaysUntilChristmas
{
	//instance variables go here

	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("DaysUntilChristmas.dat"));
		int x = file.nextInt();
		for(int i = 0; i < x; i++){
			int m = file.nextInt();
			int d = file.nextInt();
			int y = file.nextInt();

			GregorianCalendar g = new GregorianCalendar(y,m-1,d);
			GregorianCalendar c = new GregorianCalendar(y,11,25);
			int first = g.get(DAY_OF_YEAR);
			int last = c.get(DAY_OF_YEAR);
			int f  =last - first;
			if(f < 0){
				f = f + 365;
			}
			System.out.println(f + " DAYS UNTIL CHRISTMAS" );
		}
	}

	public static void main(String[] args)throws Exception
	{
		DaysUntilChristmas a=new DaysUntilChristmas();
		a.run();
	}
}