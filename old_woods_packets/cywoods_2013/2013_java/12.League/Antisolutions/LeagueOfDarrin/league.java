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

class league{
	char[][] chars;
	int[][][] ints;
	public void run()throws Exception
	{
		Comparator<String> comp = new Comparator<String>(){
			
			public int compare(String a, String b)
			{
				return a.length()-b.length()==0?a.compareTo(b):a.length()-b.length();
			}
		};
		ArrayList<String> prec = new ArrayList<String>();
		String alph = "ABCDE";
		permu(new ArrayList<Character>(Arrays.asList('A','B','C','D','E')),"",prec);
		Scanner file = new Scanner(new File("league.dat"));
		int zz = file.nextInt();file.nextLine();
		for(int z = 0;z<zz;z++)
		{
			int n = file.nextInt();
			int[] quotas = new int[5];
			for(int i = 0;i<5;i++)
				quotas[i] = file.nextInt();
			ArrayList<String> list = new ArrayList<String>();
			for(int i = 0;i<n;i++)
				list.add(file.next());
			Collections.sort(list,comp);
			int max = 0;
			for(String s:prec)
			{
				max = Math.max(solve(new ArrayList<String>((List)list.clone()),s,quotas,comp),max);
			}
			System.out.println(max);
		}
	}
	public void permu(ArrayList<Character> l, String curr, ArrayList<String> fin)
	{
		if(l.isEmpty())
			fin.add(curr);
		else
			for(int i = l.size()-1;i>-1;i--)
			{
				char ch = l.remove(i);
				permu(l,curr+ch,fin);
				l.add(i,ch);
			}
	}
	
	public int solve(ArrayList<String> list,final String prec,int[] quotas,Comparator comp)
	{
		Comparator<Character> ca = new Comparator<Character>(){
			public int compare(Character a, Character b)
			{
				return prec.indexOf(a)-prec.indexOf(b);
			}
		};
		for(int i = 0;i<list.size();i++)
		{
			char[] cha = list.get(i).toCharArray();
			ArrayList<Character> chars = new ArrayList<Character>();
			for(char j:cha)
				chars.add(j);
			Collections.sort(chars,ca);
			String s = "";
			for(char ch:chars)
				s+=ch;
			list.set(i,s);
		}
		int[] quo = quotas.clone();
		for(int i = 0;i<5;i++)
		{
			if(quo[i]==0)
			{
				for(int g = 0;g<list.size();g++)
				{
					list.set(g,list.get(g).replaceAll((char)(65+i)+"",""));
				}
			}
		}
		Collections.sort(list,comp);
		int c = 0;
		while(!list.isEmpty())
		{
			String str = list.remove(0);
			if(str.isEmpty())
				continue;
			int f = str.charAt(0)-65;
			quo[f]--;
			c++;
			if(quo[f]==0)
			{
				for(int i = 0;i<list.size();i++)
				{
					list.set(i,list.get(i).replaceAll((char)(65+f)+"",""));
				}
				Collections.sort(list,comp);
			}
		}
		return c;
	}
	
	public static void main(String[] args)throws Exception
	{
		new league().run();
	}
}
