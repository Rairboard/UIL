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


class Factorfact
{
	//instance variables go here
	Map<Integer,Set<Integer>> map;
	public void run()throws Exception
	{
		Scanner file = new Scanner(new File("factor.dat"));
		
		int times = file.nextInt();
		
		file.nextLine();
		
		for(int asdf = 0; asdf < times; asdf++)
		{
			int num = file.nextInt();
			Set<Integer> temp = factor(num);
			map = new TreeMap<>();
			for(int q : temp)
			{
				map.put(q,factor(q));
			}
			for(int x : map.keySet())
			{
				System.out.print(x + " :");
				for(int q : map.get(x))
				{
					System.out.print(" " + q);
				}
				System.out.println();
			}
			System.out.println();
		}
		

	}
	
	public Set<Integer> factor(int x)
	{
		Set<Integer> facts = new TreeSet<>();
		for(int r = 1; r <= x; r++)
		{
			if(x % r == 0)
			{
				facts.add(r);
			}
		}
		return facts;
	}

	public static void main(String[] args)throws Exception
	{
		Factorfact a=new Factorfact();
		a.run();
	}
}