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


public class Round
{
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("round.dat"));
		int reps = file.nextInt();
		for(int q=0; q<reps; q++)
		{
			int gal = file.nextInt();
			double dist = (double)file.nextInt()/5280;
			double totalDist = (double)gal*20;
			
			System.out.println((int)Math.floor(totalDist/dist));
		}
	}

	public static void main(String[] args)throws Exception
	{
		Round a=new Round();
		a.run();
	}

}