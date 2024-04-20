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


public class Maze
{
	public void run()throws Exception
	{
		Scanner file = new Scanner(new File("Maze.dat"));
		int zz = file.nextInt();file.nextLine();
	loop:
		for(int z = 0;z<zz;z++)
		{
			int n = file.nextInt();
			int goal = file.nextInt();
			file.nextLine();
			char[][] chars = new char[n][n];
			for(int i = 0;i<n;i++)
				chars[i] = file.nextLine().toCharArray();
			Queue<quad> que = new LinkedList<quad>();
			que.add(new quad(0,0,chars[0][0]-48,1));
			while(true)
			{
				quad q = que.poll();
				int r = q.row;
				int c = q.col;
				int t = q.total;
				int cnt = q.count;
				if(t==goal)
				{
					System.out.println(cnt);
					break;
				}
				int[][] d = new int[][]{{-1,-1,-1,0,0,1,1,1},{-1,0,1,-1,1,-1,0,1}};
				for(int i = 0;i<8;i++)
				{
					if(val(chars,r+d[0][i],c+d[1][i]))
					{
						char sign = chars[r+d[0][i]][c+d[1][i]];
						int val = chars[r+d[0][i]*2][c+d[1][i]*2]-48;
						switch(sign)
						{
							case '+':
								quad a = new quad(r+d[0][i]*2,c+d[1][i]*2,t+val,cnt+2);
								quad b = new quad(r,c,t+chars[r][c]-48,cnt+2);
								que.add(a);
								que.add(b);
							case '-':
								quad aa = new quad(r+d[0][i]*2,c+d[1][i]*2,t-val,cnt+2);
								quad bb = new quad(r,c,t-chars[r][c]-48,cnt+2);
								que.add(aa);
								que.add(bb);
							case '/':
								quad aaa = new quad(r+d[0][i]*2,c+d[1][i]*2,t/val,cnt+2);
								quad bbb = new quad(r,c,t/chars[r][c]-48,cnt+2);
								que.add(aaa);
								que.add(bbb);
							case '*':
								quad aaaa = new quad(r+d[0][i]*2,c+d[1][i]*2,t*val,cnt+2);
								quad bbbb = new quad(r,c,t*chars[r][c]-48,cnt+2);
								que.add(aaaa);
								que.add(bbbb);
						}
					}
				}
			}
		}
	}
	
	public boolean val(char[][] chars, int r, int c)
	{
		return Math.min(r,c)>=0&&Math.max(r,c)<chars.length;
	}

	public static void main(String[] args)throws Exception
	{
		Maze a=new Maze();
		a.run();
	}

}
class quad{
	public int row,col, total, count;
		
	public quad(int r,int c, int t,int q)
	{
		row = r;
		col = c;
		total = t;
		count = q;
	}
	
	public String toString()
	{
		return row+" "+col+" "+total+" "+count;
	}
}