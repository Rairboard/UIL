import java.util.*;
import java.math.*;
import java.io.*;

public class Flow {
	
	public char[][] orig;
	public HashMap<Integer,Character> map;
	
	public void run()throws Exception
	{
		Scanner file = new Scanner(new File("flow.dat"));
		//System.setOut(new PrintStream(new File("flowj.out")));
			
		int zz = file.nextInt();
		
		for(int z = 0;z<zz;z++)
		{
			int size = file.nextInt();
			file.nextLine();
			orig = new char[size][];
			for(int i = 0;i<size;i++)
				orig[i] = file.nextLine().toCharArray();
			char[][] sol = null;
			ArrayList<String> p = new ArrayList<String>();
			permu(countColors(),"",p);
			//System.out.println(p);
			//System.out.println(map);
			//countColors();
			//p.add("fhigabedc");
			for(String s:p)
			{
				sol = solve(s,clone(orig));
				if(sol!=null)
					break;
			}
			if(sol==null)
				System.out.println("NO SOLUTION");
			else
				for(char[] cha:sol)
				{
					for(char ch:cha)
						System.out.print(ch);
					System.out.println();
				}
			if(z!=zz-1)
				System.out.println();
		}
	}
	
	public int countColors(){
		map = new HashMap<Integer,Character>();
		for(char[] cha:orig)
			for(char ch:cha)
				if(!map.containsValue(ch)&&ch!='.')
					map.put(map.size(),ch);
		return map.size();
	}
	
	public void permu(int n, String current, ArrayList<String> list)
	{
		if(current.length()==n)
			list.add(current);
		else
			for(int i = 0;i<n;i++)
				if(!current.contains((char)(i+97)+""))
					permu(n,current+(char)(i+97),list);
	}
	
	public char[][] solve(String str,char[][] chars)
	{
		if(isFull(chars))
			return chars;
		char ch = map.get((int)(str.charAt(0)-97));
		int[] s = find(ch);
		int[] e = findLast(ch);
		int[][] ints = fillInts(chars,ch);
		d(s[0],s[1],0,ints);
		ArrayList<char[][]> trace = new ArrayList<char[][]>();
		traceBack(e[0],e[1],ints,chars,trace);
		for(char[][] chars2:trace)
		{
			char[][] ans = solve(str.substring(1),chars2);
			if(ans!=null)
				return ans;
		}
		return null;
	}
	
	public boolean isFull(char[][] chars)
	{
		for(char[] cha:chars)
			for(char ch:cha)
				if(ch=='.')
					return false;
		return true;
	}
	
	public int[] find(char ch)
	{
		for(int r = 0;r<orig.length;r++)
			for(int c = 0;c<orig[r].length;c++)
				if(orig[r][c]==ch)
					return new int[]{r,c};
		return null;
	}
	
	public int[] findLast(char ch)
	{
		for(int r = orig.length-1;r>-1;r--)
			for(int c = orig[r].length-1;c>-1;c--)
				if(orig[r][c]==ch)
					return new int[]{r,c};
		return null;
	}
	
	public int[][] fillInts(char[][] chars, char ch)
	{
		int[][] ints = new int[chars.length][chars[0].length];
		for(int r = 0;r<ints.length;r++)
			for(int c = 0;c<ints.length;c++)
				if(chars[r][c]==ch||chars[r][c]=='.')
					ints[r][c]=10000;
				else
					ints[r][c] = -1;
		return ints;
	}
	
	public void d(int r, int c, int cnt, int[][] shadow)
	{
		if(Math.min(r,c)>-1&&r<shadow.length&&c<shadow[r].length&&cnt<shadow[r][c])
		{
			shadow[r][c]=cnt;
			d(r+1,c,cnt+1,shadow);
			d(r,c+1,cnt+1,shadow);
			d(r-1,c,cnt+1,shadow);
			d(r,c-1,cnt+1,shadow);
		}
	}
	
	public void traceBack(int r, int c, int[][] ints,char[][] chars,ArrayList<char[][]> trace)
	{
		if(ints[r][c]==0)
			trace.add(chars);
		int[][] d = new int[][]{{0,1,-1,0},{1,0,0,-1}};
		for(int i = 0;i<4;i++)
		{
			int dr = r+d[0][i];
			int dc = c+d[1][i];
			if(Math.min(dr,dc)>-1&&dr<ints.length&&dc<ints[dr].length&&ints[dr][dc]==ints[r][c]-1)
			{
				char[][] copy = clone(chars);
				copy[dr][dc] = copy[r][c];
				traceBack(dr,dc,ints,copy,trace);
			}
		}
	}
	
	public char[][] clone(char[][] chars)
	{
		char[][] i = new char[chars.length][chars[0].length];
		for(int r = 0;r<i.length;r++)
			for(int c = 0;c<i[r].length;c++)
				i[r][c] = chars[r][c];
		return i;
	}
	
	public static void main(String[] args) throws Exception
	{
		new Flow().run();
	}
	
}
