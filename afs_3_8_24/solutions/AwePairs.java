import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class AwePairs
{
	static ArrayList<Character> set1,set2;
	public static void main(String [] args) throws FileNotFoundException 
	{
		Scanner f = new Scanner(new File("awepairs.dat"));
		while(f.hasNext())
		{
			ArrayList<ArrayList<Character>> list = new ArrayList<ArrayList<Character>>();
			String s = f.nextLine();
			set1=null;
			set2=null;
			for(int x=0;x<s.length();)
			{
				char let1 = s.charAt(x++);
				char let2 = s.charAt(x++);
				for(int y = 0;y<list.size();y++)
				{
					if(list.get(y).contains(let1))
					{	set1=list.get(y);break;}
					else
						set1=null;
				}
				for(int y = 0;y<list.size();y++)
				{
					if(list.get(y).contains(let2))
					{	set2=list.get(y);break;}
					else
						set2=null;
				}
				if(set1==null && set2 == null)
				{
					set1 = new ArrayList<Character>();
					set1.add(let1);
					set1.add(let2);
					list.add(set1);
				}
				else
				if(set1==null && set2!=null)
				{
					set1=new ArrayList<Character>();
					set1.add(let1);
					set1.addAll(set2);
					list.add(set1);
					set2.clear();
				}
				else
				if(set2==null && set1!=null)
				{
					set1.add(let2);
				}
				else
				if(set1!=set2)
				{
					for(Character a:set2)
						if(!set1.contains(a))
							set1.add(a);
					set2.clear();
				}
			}
			int size = list.get(0).size();
			for(int z = 0;z<list.size();z++)
				if(list.get(z).size()>size)
					size=list.get(z).size();
			for(int z = 0;z<list.size();z++)
				if(list.get(z).size()==size)
				{
					for(Character c:list.get(z))
						out.print(c);
					out.print(" ");
				}
			out.println();
		}
	}
}
/*
Student Input
ABCDEABF
ABCDEFGHDE
UILCONTEST
ALLTHEWAYTOSTATE

Student Output
EABF
CDEF
STE
YWALTHE

Test Input
ABCDEABF
ABCDEFGHDE
UILCONTEST
ALLTHEWAYTOSTATE
ABCDEFCFGHBIAH
ABCDEFBD
ABCDEFBDGHHD
ABCDEFBDGHDH
ABCDEFGHFHDB
ABCDEFBDBDFEEGFH

Test Output
EABF
CDEF
STE
YWALTHE
ABIGH
ABCD
GHABCD
ABCDGH
CDAB EFGH
ABCD EFGH
*/