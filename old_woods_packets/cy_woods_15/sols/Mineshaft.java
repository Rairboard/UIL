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


class Mineshaft
{
	//instance variables go here
	char[][][] mat;
	int[][][] shad;
	char[][][] copy;
	int moves;
	int durability;
	int durlost;
	public void run()throws Exception
	{
		Scanner file = new Scanner(new File("mineshaft.dat"));
		
		int times = file.nextInt();
		
		file.nextLine();
		
		for(int asdf = 0; asdf < times; asdf++)
		{
			int f = file.nextInt();
			int rows = file.nextInt();
			int cols = file.nextInt();
			int a = file.nextInt();
			durability = a;
			durlost = 0;
			mat = new char[f][rows][cols];
			copy = new char[f][rows][cols];
			shad = new int[f][rows][cols];
			file.nextLine();
			int tempr = -1,tempc = -1,tempd = -1;
			for(int d = 0; d < f; d++)
			{
				for(int r = 0; r < rows; r++)
				{
					char[] temp = file.nextLine().toCharArray();
					mat[d][r] = temp;
					copy[d][r] = temp;
					for(int c = 0; c < cols; c++)
					{
						if(mat[d][r][c] == 'S')
						{
							tempd = d;
							tempr = r;
							tempc = c;
						}
						shad[d][r][c] = Integer.MAX_VALUE;
					}
					
				}
			}
			solve(tempd,tempr,tempc,0,0);
			durability -= durlost;
			System.out.println(durability < 0 && moves < Integer.MAX_VALUE? "DEAD":moves + " SECONDS");
		}
	}
	
	public void solve(int d, int r, int c, int path, int dur)
	{
		if(d >= 0 && r >= 0 && c >= 0 && d < mat.length && r < mat[d].length && c < mat[d][r].length && mat[d][r][c] != '#' && path < shad[d][r][c])
		{
			shad[d][r][c] = path;
			if(mat[d][r][c] == 'E')
			{
				moves = path;
				durlost = dur;
				return;
			}
			if(mat[d][r][c] == '%')
			{	
				dur++;
				path += 3;
			}
			char temp = mat[d][r][c];
			
			solve(d-1,r,c,path + 3,dur);
			solve(d+1,r,c,path + 2,dur);
			solve(d,r+1,c,path + 1,dur);
			solve(d,r-1,c,path + 1,dur);
			solve(d,r,c-1,path + 1,dur);
			solve(d,r,c+1,path + 1,dur);
			mat[d][r][c] = temp;
			
		}
	}

	public static void main(String[] args)throws Exception
	{
		Mineshaft a=new Mineshaft();
		a.run();
	}
}