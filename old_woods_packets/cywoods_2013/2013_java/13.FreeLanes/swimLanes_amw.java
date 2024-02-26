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


class swimLanes
{
	//instance variables go here

	public void run()throws Exception
	{
		int[] order = new int[]{4,3,5,2,6,1,7};
		Scanner file=new Scanner(new File("swimLanes.dat"));
		int zz = file.nextInt();
		file.nextLine();
		for(int times = 0; times<zz;times++)
		{
			Map<Swim,String> m = new TreeMap<Swim,String>();
			String[] sortedtimes = new String[7];
			for(int i=0;i<7;i++)
			{
				String line = file.nextLine();
				String[] split = line.split(" ");	
				String name = split[0];
				String time = split[1];
				Swim sw = new Swim(time);
				m.put(sw, name);
			}
			int i = 0;
			for(Swim s: m.keySet())
			{
				sortedtimes[order[i]-1] = s.time();
				i++;
			}
			i =1;
			for(String t : sortedtimes)
			{
				Swim temp = new Swim(t);
				System.out.println("Lane " + (i++) + ": " + m.get(temp));
			}
		}
		

	}
	

	public static void main(String[] args)throws Exception
	{
		swimLanes a=new swimLanes();
		a.run();
	}
}

class Swim implements Comparable
{
	private String time;
	public Swim(String t)
	{
		time = t;
	}
	public String time()
	{
		return time;
	}
	
	public int compareTo(Object obj)
	{
		Swim s = (Swim)(obj);
		String mine = time;
		String theirs = s.time();
		String[] here = mine.split("\\.");
		String[] togo = theirs.split("\\.");
		if(mine.equals(theirs))
		{
			return 0;
		}
		if(here.length>togo.length)
		{
			return 1;
		}
		if(here.length<togo.length)
		{
			return -1;
		}
		if(here.length==togo.length)
		{
			int hfirst = Integer.parseInt(here[0]);
			int tfirst = Integer.parseInt(togo[0]);
			if(hfirst>tfirst)
			{
				return 1;
			}
			if(hfirst<tfirst)
			{
				return -1;
			}
			if(hfirst==tfirst)
			{
				int hsecond = Integer.parseInt(here[1]);
				int tsecond = Integer.parseInt(togo[1]);
				if(hsecond>tsecond)
				{
					return 1;
				}
				if(hsecond<tsecond)
				{
					return -1;
				}
				if(hsecond==tsecond && here.length==3)
				{
					int hthird = Integer.parseInt(here[2]);
					int tthird = Integer.parseInt(togo[2]);
					if(hthird>tthird)
					{
						return 1;
					}
					if(hthird<tthird)
					{
						return -1;
					}
					if(hthird==tthird)
					{
						return 0;
					}
				}
			}
		}
		return 0;
	}
	
	public String toString()
	{
		return time;
	}
}