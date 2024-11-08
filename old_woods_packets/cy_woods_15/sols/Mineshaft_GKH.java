import java.util.*;
import java.io.*;

public class Mineshaft_GKH {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	private char[][][] mat;
	private int[][][] shadow;
	private char[][][] copy;
	private int seconds;
	private int dur;
	
	public void run() throws FileNotFoundException
	{
		Scanner file = new Scanner(new File("mineshaft.dat"));
		int times = file.nextInt();
		file.nextLine();
		for(int i=0;i<times;i++)
		{
			int floor = file.nextInt();
			int row = file.nextInt();
			int col = file.nextInt();
			dur = file.nextInt();
			file.nextLine();
			
			mat = new char[floor][row][col];
			shadow = new int[floor][row][col];
			copy = new char[floor][row][col];
			seconds = Integer.MAX_VALUE;
			
			int sF = 0;
			int sR = 0;
			int sC = 0;
			
			for(int f=0;f<floor;f++)
			{
				for(int r=0;r<row;r++)
				{
					String s = file.nextLine();
					for(int c=0;c<col;c++)
					{
						mat[f][r][c] = s.charAt(c);
						if(mat[f][r][c]=='S')
						{
							sF = f;
							sR = r;
							sC = c;
						}
						shadow[f][r][c] = Integer.MAX_VALUE;
					}
				}
			}
			
			maze(sF,sR,sC,0);
			
			int sub = 0;
			
			for(int x=0;x<mat.length;x++)
			{
				for(int y=0;y<mat[x].length;y++)
				{
					for(int z=0;z<mat[x][y].length;z++)
					{
						if(copy[x][y][z]=='*'&&mat[x][y][z]=='%')
							sub++;
					}
				}
			}
			
			dur -= sub;
			
			if(seconds<Integer.MAX_VALUE&&dur>=0)
				System.out.println(seconds + " SECONDS");
			else
				System.out.println("DEAD");
		}
	}
	public void maze(int f,int r,int c,int steps)
	{
		if(steps<seconds&&f>=0&&f<mat.length&&r>=0&&r<mat[f].length&&c>=0&&c<mat[f][r].length
			&&mat[f][r][c]!='#'&&mat[f][r][c]!='*'&&steps<shadow[f][r][c])
		{
			if(mat[f][r][c]=='E')
			{
				seconds = steps;
				
				for(int x=0;x<mat.length;x++)
					for(int y=0;y<mat[x].length;y++)
						for(int z=0;z<mat[x][y].length;z++)
							copy[x][y][z] = mat[x][y][z];
				copy[f][r][c] = '*';
				
				return;
			}
			shadow[f][r][c] = steps;
			
			char temp = mat[f][r][c];
			int move = 0;
			
			mat[f][r][c] = '*';
			
			if(temp=='%')
			{
				move = 3;
			}
			
			maze(f-1,r,c,steps+3+move);
			maze(f+1,r,c,steps+2+move);
			maze(f,r-1,c,steps+1+move);
			maze(f,r+1,c,steps+1+move);
			maze(f,r,c-1,steps+1+move);
			maze(f,r,c+1,steps+1+move);
			
			mat[f][r][c] = temp;
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Mineshaft_GKH x = new Mineshaft_GKH();
		x.run();
	}
}