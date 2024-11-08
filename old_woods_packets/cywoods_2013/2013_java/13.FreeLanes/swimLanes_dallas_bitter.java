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


public class swimLanes
{
	//instance variables go here

	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("swimLanes.dat"));
		int jim = file.nextInt();
		file.nextLine();
		ArrayList<Swimmer> ppl = new ArrayList<Swimmer>();
		for(int bob = 0; bob<jim; bob++)
		{
			for(int i = 0; i<7; i++)
			{
				String[] line = file.nextLine().split(" ");
				ppl.add(new Swimmer(line[0],line[1]));				
			}
			Collections.sort(ppl);
			out.println(ppl);
			out.println("Lane 1: "+ppl.get(5));
			out.println("Lane 2: "+ppl.get(3));
			out.println("Lane 3: "+ppl.get(1));
			out.println("Lane 4: "+ppl.get(0));
			out.println("Lane 5: "+ppl.get(2));
			out.println("Lane 6: "+ppl.get(4));
			out.println("Lane 7: "+ppl.get(6));
			
		}
	}
	class Swimmer implements Comparable<Swimmer>
	{
		int time;
		String name;
		
		public Swimmer(String a, String b)
		{
			name = a;
			time = Integer.parseInt(b.replace(".",""));
		}
		
		public int compareTo(Swimmer a)
		{
			return time-a.time;
		}
		
		public String toString()
		{
			return name;
		}
	}

	public static void main(String[] args)throws Exception
	{
		swimLanes a=new swimLanes();
		a.run();
	}
}