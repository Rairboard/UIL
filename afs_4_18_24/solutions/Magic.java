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


public class Magic
{
	public void run()throws Exception
	{
		Scanner file = new Scanner(new File("magic.dat"));
		int zz = file.nextInt();
		for(int z = 0;z<zz;z++)
		{
			int n = file.nextInt();
			int[][] mat = new int[n][n];
			for(int i = 0;i<n;i++)
				for(int j= 0;j<n;j++)
					mat[i][j] = file.nextInt();
			boolean square = check(mat);
			System.out.println((square?"":"not a ")+"magic square");
		}
	}
	
	public boolean check(int[][] ints)
	{
		int s = 0;
		for(int i = 0;i<ints.length;i++)
			s+=ints[0][i];
		boolean[] b = new boolean[ints.length*ints.length];
		for(int r = 0;r<ints.length;r++)
			for(int c = 0;c<ints.length;c++)
				if(ints[r][c]<0||ints[r][c]>b.length||b[ints[r][c]-1])
					return false;
				else
					b[ints[r][c]-1] = true;
		for(int r = 0;r<ints.length;r++)
		{
			int sum = 0;
			int sum2 = 0;
			for(int c = 0;c<ints.length;c++)
			{
				sum+=ints[r][c];
				sum2+=ints[c][r];
			}
			if(sum!=s||sum2!=s)
				return false;
		}
		int su =0;
		int su1 = 0;
		for(int i = 0;i<ints.length;i++)
		{
			su+=ints[i][i];
			su1+=ints[ints.length-1-i][i];
		}
		return su==s&&su1==s;
	}

	public static void main(String[] args)throws Exception
	{
		Magic a=new Magic();
		a.run();
	}

}