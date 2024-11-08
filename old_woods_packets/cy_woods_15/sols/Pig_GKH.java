import java.util.*;
import java.io.*;

public class Pig_GKH {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	private char[][] map;
	private int[][] shadow;
	private char[][] copy;
	private int bmoves;
	
	public void run() throws FileNotFoundException
	{
		Scanner file = new Scanner(new File("pig.dat"));
		int times = file.nextInt();
		file.nextLine();
		for(int i=0;i<times;i++)
		{
			int row = file.nextInt();
			int col = file.nextInt();
			file.nextLine();
			
			map = new char[row][col];
			shadow = new int[row][col];
			copy = new char[row][col];
			bmoves = Integer.MAX_VALUE;
			
			int sR = 0;
			int sC = 0;
			
			for(int r=0;r<row;r++)
			{
				String s = file.nextLine();
				for(int c=0;c<s.length();c++)
				{
					map[r][c] = s.charAt(c);
					if(map[r][c]=='D')
					{
						sR=r;
						sC=c;
					}
					shadow[r][c]=Integer.MAX_VALUE;
				}
			}
			
			maze(sR,sC,0);
			
			if(bmoves<8)
				System.out.println("BACON");
			else
				System.out.println("PIG ON THE RUN");
		}
	}
	public void maze(int r,int c, int steps)
	{
		if(steps<bmoves && r>=0 && r<map.length && c>=0 && c<map[r].length && map[r][c]!='H' 
			&& map[r][c]!='*' && steps<shadow[r][c])
		{
			if(map[r][c]=='O')
			{
				bmoves = steps;
				for(int n=0;n<map.length;n++)
				{
					for(int m=0;m<map[n].length;m++)
					{
						copy[n][m] = map[n][m];
					}
				}
				copy[r][c] = '*';
				
				return;
			}
			
			shadow[r][c] = steps;
			
			char temp = map[r][c];
			
			map[r][c] = '*';
			
			maze(r-1,c,steps+1);
			maze(r+1,c,steps+1);
			maze(r,c-1,steps+1);
			maze(r,c+1,steps+1);
			
			map[r][c] = temp;
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Pig_GKH x = new Pig_GKH();
		x.run();
	}
}