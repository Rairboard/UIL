import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

			//change the class name
public class Mineshaft
{
	public char[][][][] mat;
	public int[][][][] shad;
	public int[] points;
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("mineshaft.dat"));
		int ans = file.nextInt();
		for(int asdf = 0;asdf<ans;asdf++)
		{
			int f = file.nextInt();
			int r = file.nextInt();
			int c = file.nextInt();
			int dur = file.nextInt();
			file.nextLine();
			mat = new char[dur+1][f][r][c];
			shad = new int[dur+1][f][r][c];
			points = new int[6];
			//for(int k=0;k<4;k++)
			for(int i=0;i<f;i++)
			{
				for(int j=0;j<r;j++)
				{
					String a = file.nextLine();
					char[] temp = a.toCharArray();
					if(a.contains("S"))
					{
						//System.out.println(i+""+a.indexOf("S")+j);
						points[0] = i;
						points[2] = a.indexOf("S");
						points[1] = j;
					}
					if(a.contains("E"))
					{
						points[3] = i;
						points[5] = a.indexOf("E");
						points[4] = j;
					}
					for(int t =0;t<mat.length;t++)
					{
						mat[t][i][j] = Arrays.copyOf(temp,c);
						Arrays.fill(shad[t][i][j],1000000);
					}

				}
			}
			recur(0,points[0],points[1],points[2],0);
			int smallest = Integer.MAX_VALUE;
			for(int i=0;i<mat.length;i++)
			{
				smallest = Math.min(smallest, shad[i][points[3]][points[4]][points[5]]);
			}
			if(smallest > 999999)
			{
				System.out.println("DEAD");
			}
			else System.out.println(smallest + " SECONDS");
			//System.out.println(points[3]+" "+points[4]+" "+points[5]);
			for(int i=0;i<f;i++)
			{
				for(int j=0;j<r;j++)
				{
				//	System.out.println(Arrays.toString(mat[0][i][j]) + "  " + Arrays.toString(mat[1][i][j]) + "  " + Arrays.toString(mat[2][i][j]) + "  " + Arrays.toString(mat[3][i][j]));
				}
			}
			//System.out.println();
			//System.out.println();
			for(int i=0;i<f;i++)
			{
				for(int j=0;j<r;j++)
				{
					for(int k=0;k<mat.length;k++)
					{
						//System.out.print(Arrays.toString(shad[k][i][j]) + "  ");
					}
					//System.out.println();
				}
			}
		}
	}

	public void recur(int m,int f,int r,int c,int count)
	{
		//System.out.println(mat[m][l][r][c] != '#' );
		//System.out.println(m + ""+l+r+c );
		if(m>=0 &&  f>=0 && r>=0 && c>=0 && m<mat.length && f<mat[m].length && r<mat[m][f].length && c<mat[m][f][r].length && mat[m][f][r][c] != '#' && shad[m][f][r][c] > count)
		{
			//System.out.println("Mineshaft");
			if(mat[m][f][r][c] == '%')
			{ 
				count+=3;
				shad[m][f][r][c] = count;
				m++;
				
				//recur(m+1,l,r,c,count+1);
			}
			if(m<mat.length)shad[m][f][r][c] = count;
			recur(m,f+1,r,c,count+2);
			recur(m,f-1,r,c,count+3);
			recur(m,f,r+1,c,count+1);
			recur(m,f,r-1,c,count+1);
			recur(m,f,r,c+1,count+1);
			recur(m,f,r,c-1,count+1);
			
		}
	}

	public static void main(String[] args) throws Exception
	{
			//change this to whatever your class name is
		new Mineshaft().run();
	}

}