import java.io.*;
import java.util.*;

public class Rescue
{
	//instance variables go here
	private char[][][] mat;
	private int[][][] shad;

	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("rescue.dat"));
		int run=file.nextInt();
		file.nextLine();
		for(int zzz=0; zzz<run; zzz++)
		{
			int rs=file.nextInt(), cs=file.nextInt(), ls=file.nextInt();
			file.nextLine();
			mat=new char[ls][rs][cs];
			shad=new int[ls][rs][cs];
			for(int qwe=0; qwe<ls; qwe++)
			{
				for(int asd=0; asd<rs; asd++)
				{
					for(int zxc=0; zxc<cs; zxc++)
					{
						shad[qwe][asd][zxc]=1000000;
					}
				}
			}
			int sr=-1,sc=-1,sl=-1,er=-1,ec=-1,el=-1;
			for(int q=0; q<ls; q++)
			{
				for(int w=0; w<rs; w++)
				{
					String inp=file.nextLine();
					if(inp.indexOf("S")!=-1)
					{
						sr=w;
						sc=inp.indexOf("S");
						sl=q;
					}
					if(inp.indexOf("E")!=-1)
					{
						er=w;
						ec=inp.indexOf("E");
						el=q;
					}
					mat[q][w]=inp.toCharArray();
				}
			}
			//file.nextLine();
			solve(sl,sr,sc,0);
			System.out.print("Rescue #"+(zzz+1)+": ");
			if(shad[el][er][ec]==1000000)
			{
				System.out.println("NO");
			}
			else
			{
				System.out.println(shad[el][er][ec]);
			}
		}
	}

	public void solve(int l, int r, int c, int n)
	{
		//System.out.println("L: "+l+" R: "+r+" C: "+c);
		if(l<0 || l>=mat.length || r<0 || r>=mat[l].length || c<0 || c>=mat[l][r].length || c>=mat[l][r].length)
		{
			return;
		}
		else if(shad[l][r][c]<n || mat[l][r][c]=='#')
		{
			//System.out.println("mat: "+mat.length+" "+mat[l].length+" "+mat[l][r].length);
			//System.out.println("shad: "+shad.length+" "+shad[l].length+" "+shad[l][r].length);
			return;
		}
		else
		{
			shad[l][r][c]=n;
			solve(l,r-1,c,n+1);
			solve(l,r+1,c,n+1);
			solve(l,r,c-1,n+1);
			solve(l,r,c+1,n+1);
			solve(l-1,r,c,n+1);
			solve(l+1,r,c,n+1);
		}
	}

	public static void main(String[] args)throws Exception
	{
		Rescue a=new Rescue();
		a.run();
	}
}