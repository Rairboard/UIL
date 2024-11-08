import java.io.*;
import java.util.*;

public class swimminglanes_clt
{
	//instance variables go here
	
	class Swimmer implements Comparable<Swimmer>
	{
		private String name;
		private int time;
		
		public Swimmer(String n, int t)
		{
			name=n;
			time=t;
		}
		
		public int getTime()
		{
			return time;
		}
		
		public String getName()
		{
			return name;
		}
		
		public int compareTo(Swimmer s)
		{
			if(s.getTime()>time){return -1;}
			else if(s.getTime()<time){return 1;}
			return 0;
		}
	}
	
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("swimLanes.dat"));
		int run=file.nextInt();
		file.nextLine();
		for(int q=0; q<run; q++)
		{
			ArrayList<Swimmer> swim=new ArrayList<Swimmer>();
			for(int i=0; i<7; i++)
			{
				String hld=file.next();
				int tim=0;
				String[] ctim=file.next().split("\\.");
				if(ctim.length==3)
				{
					tim+=(Integer.parseInt(ctim[0]) * 60 * 1000);
					tim+=(Integer.parseInt(ctim[1]) * 1000);
					tim+=(Integer.parseInt(ctim[2]));
				}
				else
				{
					tim+=(Integer.parseInt(ctim[0])*1000);
					tim+=(Integer.parseInt(ctim[1]));
				}
				file.nextLine();
				swim.add(new Swimmer(hld,tim));
			}
			Collections.sort(swim);
			System.out.println("Lane 1:" + swim.get(5).getName());
			System.out.println("Lane 2:" + swim.get(3).getName());
			System.out.println("Lane 3:" + swim.get(1).getName());
			System.out.println("Lane 4:" + swim.get(0).getName());
			System.out.println("Lane 5:" + swim.get(2).getName());
			System.out.println("Lane 6:" + swim.get(4).getName());
			System.out.println("Lane 7:" + swim.get(6).getName());
			System.out.println();
		}
	}
	
	public static void main(String[] args)throws Exception
	{
		swimminglanes_clt a=new swimminglanes_clt();
		a.run();
	}	
}