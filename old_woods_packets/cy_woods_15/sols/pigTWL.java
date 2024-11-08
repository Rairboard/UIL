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


class pigTWL
{
	//instance variables go here
	char[][] mat;
	int[][] shad;
	int moves;
	public void run()throws Exception
	{
		Scanner file = new Scanner(new File("pig.dat"));
		
		int times = file.nextInt();
		
		file.nextLine();
		
		for(int asdf = 0; asdf < times; asdf++)
		{
			int row = file.nextInt();
			int col = file.nextInt();
			file.nextLine();
			mat = new char[row][col];
			shad = new int[row][col];
			int tempr = 0;
			int tempc = 0;
			for(int r = 0; r < row; r++)
			{
				mat[r] = file.nextLine().toCharArray();
			}
			for(int r = 0; r < row; r++)
			{
				
				for(int c = 0; c < col; c++)
				{
					if(mat[r][c] == 'D')
					{
						tempr = r;
						tempc = c;
					}
					shad[r][c] = Integer.MAX_VALUE;
				}
			}
			solve(tempr,tempc,0);
			System.out.println(moves <= 7 ? "BACON":"PIG ON THE RUN");
		}
		

	}
	
	public void solve(int r, int c, int path)
	{
		if(r >= 0 && c >= 0 && r < mat.length && c < mat[r].length && mat[r][c] != 'H' && path < shad[r][c])
		{
			shad[r][c] = path;
			if(mat[r][c] == 'O')
			{
				moves = path;
				return;
			}
			
			char temp = mat[r][c];
			solve(r-1,c,path + 1);
			solve(r,c-1,path +1);
			solve(r+1,c,path + 1);
			solve(r,c+1,path + 1);
			mat[r][c] = temp;
		}
		
	}


	public static void main(String[] args)throws Exception
	{
		pigTWL a=new pigTWL();
		a.run();
	}
}