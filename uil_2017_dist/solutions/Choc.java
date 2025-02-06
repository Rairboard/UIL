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


public class Choc
{
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("choc.dat"));
		int reps = file.nextInt();
		for(int q=0; q<reps; q++)
		{
			Calendar cal = new Calendar.Builder().setDate(2025,7,21).build();
			cal.add(Calendar.DAY_OF_YEAR, file.nextInt());
			System.out.println(cal.get(Calendar.MONTH)+"/"+cal.get(Calendar.DAY_OF_MONTH)+"/"+cal.get(Calendar.YEAR));
		}
	}

	public static void main(String[] args)throws Exception
	{
		Choc a=new Choc();
		a.run();
	}

}