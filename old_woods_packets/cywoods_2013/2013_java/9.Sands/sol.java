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


class sands
{
	char[][][] chars;
	double[][][] dubs;
	
	//description:
	//sandier sands of sandiness
	//
	//input: d r c
	//d represents depth of sand maze, r represents rows of each level, c represents columns of each level
	//next d*r*c lines represent the sand maze, from top to bottom
	//
	//track the percentage of sand that reaches the floor of the maze, as well as the percentage trapped in the maze.
	//output in format floor% trapped% and round to two decimal places
	//
	//'o' denotes a hole at the top of the maze that sand will fall through
	//'^' denotes a splitter that splits the sands into the 8 spaces around it 
	//'#' denotes a space that sand cannot fall through. if sand lands here it will be trapped
	//
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("sands.dat"));
		PrintWriter out = new PrintWriter(new FileWriter(new File("sands.out")));
		int zz = file.nextInt();
		file.nextLine();
		for(int z = 0;z<zz;z++)
		{
			int f = file.nextInt();
			int r = file.nextInt();
			int c = file.nextInt();
			file.nextLine();
			chars = new char[f][r][c];
			dubs  = new double[f][r][c];
				for(int j = 0;j<f;j++)
				{
					for(int k = 0;k<r;k++)
					{
						String str = file.nextLine();
						System.out.println(str);
						chars[j][k] = str.toCharArray();
					}
					System.out.println();
				}
			int cnt = 0;
			for(int i = 0;i<chars[0].length;i++)
			{
				for(int j = 0;j<chars[0][i].length;j++)
				{
					if(chars[0][i][j]=='o')
						cnt++;
				}
			}
			for(int i = 0;i<chars[0].length;i++)
			{
				for(int j = 0;j<chars[0][i].length;j++)
				{
					if(chars[0][i][j]=='o')
						dubs[0][i][j] = 100.0/cnt;
				}
			}
			trace(dubs);
			int test = dubs.length-1;
			double sum = 0;
			for(double[] d:dubs[test])
			{
				for(double du:d)
				{
					sum+=du;
				}
			}
			out.printf("%.2f%% made it to the floor and %.2f%% was trapped %n",sum,100-sum);
		}
		out.close();
	}
	
	public void trace(double[][][] dubs)
	{
		for(int i = 0;i<dubs.length-1;i++)
		{
			trace(i);
		}
	}
	
	public void trace(int f)
	{
		for(int i = 0;i<dubs[f].length;i++)
		{		
			for(int j = 0;j<dubs[f][i].length;j++)
			{
				if(chars[f+1][i][j]=='^')
				{
					double n = dubs[f][i][j]/8;
					int[] r = new int[]{-1,-1,-1,0,0,1,1,1};
					int[] c = new int[]{-1,0,1,-1,1,-1,0,1};
					for(int k = 0;k<8;k++)
					{
						dubs[f+1][i+r[k]][j+c[k]] += n;
					}
				}
				else if(chars[f][i][j]!='#')
					dubs[f+1][i][j] += dubs[f][i][j];
			}
		}
	}
	
	public static void testGen(int cases,int sizeR) throws Exception
	{
		PrintWriter out = new PrintWriter(new FileWriter(new File("sands.dat")));
		out.println(cases);
		ArrayList<Integer> sizes = new ArrayList<Integer>();
		for(int i = 0;i<cases;i++)
		{
			sizes.add((int)(Math.random()*(sizeR-3)+3));
		}
		for(int i:sizes)
		{
			gen(i,Math.random()*.2,Math.random()*.2,Math.random()*.2,out);
		}
		out.close();
	}
	
	public static void gen(int size,double perca,double percb,double percc,PrintWriter out)
	{
		out.println(size+" "+size+" "+size);
		String p = "";
		for(int i = 0;i<size;i++)
			p+="#";
		out.println(p);
		for(int i = 1;i<size-1;i++)
		{
			for(int j = 0;j<size;j++)
			{
				if(j==0||j==size-1)
					out.print("#");
				else if(Math.random()<perca)
					out.print("o");
				else
					out.print(".");
			}
			out.println();
		}
		out.println(p);
		for(int a = 1;a<size-1;a++)
		{
			out.println(p);
			for(int i = 1;i<size-1;i++)
			{
				for(int j = 0;j<size;j++)
				{
					if(j==0||j==size-1)
						out.print("#");
					else if(Math.random()<percb&&j>1&&i>1&&j<size-2&&i<size-2)
					{
						out.print("^");						
					}
					else if(Math.random()<percc)
						out.print("#");
					else
						out.print(".");
				}
				out.println();
			}
			out.println(p);	
		}
		out.println(p);
		for(int i = 1;i<size-1;i++)
		{
			for(int j = 0;j<size;j++)
			{
				if(j==0||j==size-1)
					out.print("#");
				else
					out.print(".");
			}
			out.println();
		}
		out.println(p);
		
	}

	public static void main(String[] args)throws Exception
	{
		//testGen(10,15);
		sands a=new sands();
		a.run();
	}
}