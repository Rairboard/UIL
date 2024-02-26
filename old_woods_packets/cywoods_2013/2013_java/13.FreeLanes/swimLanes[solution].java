import java.io.*;
import java.util.*;
import java.text.*;
import java.util.TreeMap;
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
		Scanner file=new Scanner(new File("swimLanes.dat"));
		PrintWriter out=new PrintWriter(new FileWriter("swimLanes.out"));
		Scanner chop = new Scanner("");

		int times=file.nextInt();
		//file.nextLine();
		while(times>0)
		{
			String name="";
			String time="";
			ArrayList<String> t=new ArrayList<String>();
			String[] nam=new String[7];
			for(int x=0;x<7;x++)
			{
				name=file.next();
				time=file.next();
				//file.nextLine();
				nam[x]=name;
				t.add(time);
			}
			ArrayList<Integer> lb=new ArrayList<Integer>();
			for(int f=0;f<7;f++)
			{
				String[] tt=t.get(f).split("\\.");
				Integer[] temp=new Integer[tt.length];
				String lt="";
				for(int j=0;j<tt.length;j++)
				{
					lt+=tt[j];
				}
				lb.add(Integer.parseInt(lt));
			}

			ArrayList<Integer> nt=new ArrayList<Integer>();
			for(int y=0;y<t.size();y++)
			{
				String[] tt=t.get(y).split("\\.");
				Integer[] temp=new Integer[tt.length];
				String lt="";
				for(int j=0;j<tt.length;j++)
				{
					lt+=tt[j];
				}

				nt.add(Integer.parseInt(lt));
			}
				Collections.sort(nt);



				out.println("Lane 1: "+nam[lb.indexOf(nt.get(5))]);
				out.println("Lane 2: "+nam[lb.indexOf(nt.get(3))]);
				out.println("Lane 3: "+nam[lb.indexOf(nt.get(1))]);
				out.println("Lane 4: "+nam[lb.indexOf(nt.get(0))]);
				out.println("Lane 5: "+nam[lb.indexOf(nt.get(2))]);
				out.println("Lane 6: "+nam[lb.indexOf(nt.get(4))]);
				out.println("Lane 7: "+nam[lb.indexOf(nt.get(6))] + "\n");
		
				System.out.println("Lane 1: "+nam[lb.indexOf(nt.get(5))]);
				System.out.println("Lane 2: "+nam[lb.indexOf(nt.get(3))]);
				System.out.println("Lane 3: "+nam[lb.indexOf(nt.get(1))]);
				System.out.println("Lane 4: "+nam[lb.indexOf(nt.get(0))]);
				System.out.println("Lane 5: "+nam[lb.indexOf(nt.get(2))]);
				System.out.println("Lane 6: "+nam[lb.indexOf(nt.get(4))]);
				System.out.println("Lane 7: "+nam[lb.indexOf(nt.get(6))] + "\n");


			times--;
		}
		out.close();
	}

	public static void main(String[] args)throws Exception
	{
		swimLanes a=new swimLanes();
		a.run();
	}
}