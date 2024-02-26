//michael baker
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


class template
{
	//instance variables go here
	private static TreeMap<String,ArrayList<String>> dads;
	private static boolean imStronger=false;

	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("judgedads.dat"));
		int times=file.nextInt();
		file.nextLine();
		for(int go=0;go<times;go++)
		{
			dads=new TreeMap<String,ArrayList<String>>();
			int ehh=file.nextInt();
			file.nextLine();
			for(int x=0;x<ehh;x++)
			{
				String strong=file.nextLine();
				String weak=file.nextLine();
				if(dads.get(strong)==null)
				{
					ArrayList<String> temp=new ArrayList<String>();
					dads.put(strong,temp);
				}
				ArrayList<String> temp=dads.get(strong);
				temp.add(weak);
				dads.put(strong,temp);
			}
			int cases=file.nextInt();
			file.nextLine();
			for(int cas=0;cas<cases;cas++)
			{
				String dad1=file.nextLine();
				String dad2=file.nextLine();
				isStronger(dad1,dad2);
				if(imStronger==true)
					System.out.println(dad1+"'s dad can beat up "+dad2+"'s dad.");
				else System.out.println(dad1+"'s isnt bad enough.");
			}
			System.out.println();
		}
	}
	
	public static void isStronger(String d1,String d2)
	{
		ArrayList<String> D1=dads.get(d1);
		if(D1==null)
		{
			imStronger=false;
			return;
		}
		if(D1.indexOf("none")>-1)
		{
			imStronger=false;
			return;
		}
		if(D1.isEmpty())
			return;
		if(D1.indexOf(d2)>-1)
		{
			imStronger=true;
			return;
		}
		for(int x=0;x<D1.size();x++)
		{
			isStronger(D1.get(x),d2);
		}
	}

	public static void main(String[] args)throws Exception
	{
		template a=new template();
		a.run();
	}
}