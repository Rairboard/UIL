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


public class Timeline
{
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("timeline.dat"));
		int reps = file.nextInt();
		
		for(int q=0; q<reps; q++)
		{
			Calendar cal = new Calendar.Builder().setDate(1975,7,1).build();
			file.next();
			cal.add(Calendar.DAY_OF_YEAR, file.nextInt()*12);
			System.out.println(cal.get(Calendar.MONTH)+"/"+cal.get(Calendar.DAY_OF_MONTH)+"/"+cal.get(Calendar.YEAR));
		}
	}

	public static void main(String[] args)throws Exception
	{
		Timeline a=new Timeline();
		a.run();
	}

}