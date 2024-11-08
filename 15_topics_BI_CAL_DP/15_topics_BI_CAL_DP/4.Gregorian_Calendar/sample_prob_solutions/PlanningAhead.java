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
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

class PlanningAhead
{
	//instance variables go here

	public void run()throws Exception
	{
		Scanner file = new Scanner(new File("planningAhead2.dat"));
		int times= file.nextInt();
		for(int t=0; t<times; t++){
			GregorianCalendar g = new GregorianCalendar(1993, 8, 12);
			SimpleDateFormat f = new SimpleDateFormat("MMMM dd, yyyy");
			int len=file.nextInt(); int rest=len/3;
			g.add(g.DAY_OF_MONTH, len+rest);
			out.println(f.format(g.getTime()));
		}


	}

	public static void main(String[] args)throws Exception
	{
		PlanningAhead a=new PlanningAhead();
		a.run();
	}
}