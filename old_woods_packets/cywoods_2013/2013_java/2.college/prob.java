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

//Applying to college sucks. This is a fact; therefore, Rish wants to start and finish these in one sitting. 

//Given the names of colleges to which Rish applies, calculate the amount of time he needs to complete the applications.
//Each college has a separate, one-hour application and a certain number of essays. Rish is careless and only spends 45
//minutes on each essay. Rishabh is not very organized and might have essays from the same college appear as different 
//essays, so Rish might do 3 essays for cornell and then work on something else before panicking and realizing that cornell
//has 2 more. 

//You must take input of the university names and number of essays required and output the latest time at which rish can start his apps.
//input in form name #
//ex harvard 7
//output in form 
//"Rish should start his applications on or before 3-letter month day at time.
//ex "rish should start his applications on or before oct 31 at 16:00.

class prob
{
	//instance variables go here

	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("prob.in"));
		String sch = "";
		int totalT=0;
		while(file.hasNextLine())
		{
			String[] ls = file.nextLine().toLowerCase().split(" ");
			int uniT=45*parseInt(ls[1]);
			if(sch.indexOf(ls[0])>=0)
			{
			}
			else
			{
				uniT+=60;
				sch+=ls[0]+" "+uniT+" ";
			}
			totalT+=uniT;
		}
		int hrs = totalT/60;
		int mins = totalT-(hrs*60);
		GregorianCalendar gc = new GregorianCalendar(2013,10,1,0,0);
		gc.add(gc.MINUTE,-totalT);
		//out.println("You need "+hrs+" hours and "+mins+" minutes.");
		Date rep = gc.getTime();
		out.println("Rish should start his applications on or before "+
			rep.toString().substring(0,11)+
				"at "+rep.toString().substring(11,16)+".");
	}

	public static void main(String[] args)throws Exception
	{
		prob a=new prob();
		a.run();
	}
}