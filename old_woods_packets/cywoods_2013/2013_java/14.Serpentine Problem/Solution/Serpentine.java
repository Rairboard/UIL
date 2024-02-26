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
import java.util.Map;
import java.util.TreeMap;
import java.math.BigInteger;


class Serpentine
{
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("Serpentine.in"));
		String l = file.nextLine();
		int cnt = Integer.parseInt(l);
		PrintWriter w = new PrintWriter(new FileWriter("E:\\outputfile.out"));
		while(cnt>0)
		{
			String p = file.nextLine();
			int s = Integer.parseInt(p);
			int[][] mat = new int[s][s];
			int c = 0;
			int r = s-1;
			int x = 1;
			int y = -1;
			
			for(int n = 1; n<(s*s);n++)
			{
				mat[r][c]=n;
				if(r == c)
				{
					x=x*(-1);
					y=y*(-1);
				}
				else if((r==mat.length-1 && c!=mat.length-1)&&c!=0)
				{
					mat[r][c]=n;
					n++;
					c++;
					mat[r][c]=n;
					y=y*(-1);
				}
				else if(r!=mat.length-1 && c==mat.length-1)
				{
					mat[r][c]=n;
					n++;
					r++;
					mat[r][c]=n;
					y=y*(-1);
				}
				if(x>0)
				{
					r=r+y;
				}
				else if(x<0)
				{
					c=c+y;
				}
			}
			for(int v = 0;v<mat.length;v++)
			{
				for(int z = 0;z<mat[v].length;z++)
				{
					out.print((mat[v][z])+" ");
				}
				out.println();	
			}
			out.println();
			cnt--;
		}
	}

	public static void main(String[] args)throws Exception
	{
		Serpentine a=new Serpentine();
		a.run();
	}
}