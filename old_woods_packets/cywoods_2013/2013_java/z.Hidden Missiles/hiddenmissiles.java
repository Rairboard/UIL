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


class hiddenmissiles
{
	char[][] grid;

	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("hiddenmissiles.dat"));
		int samples = Integer.parseInt(file.nextLine());
		for(int i = 0; i<samples; i++)
		{
			int targetCount = 0;
			int rowcord = 0;
			int colcord = 0;
			String[] dimensions = file.nextLine().split(" ");
			int rowdim = Integer.parseInt(dimensions[0]);
			int coldim = Integer.parseInt(dimensions[1]);
			grid = new char[rowdim][coldim];
			for(int rows = 0; rows<rowdim; rows++)
			{
				char[] item = file.nextLine().toCharArray();
				grid[rows] = item;
			}
			for(int r = 0; r<grid.length; r++)
			{
				for(int c = 0; c<grid[r].length; c++)
				{
					if(grid[r][c] == 'o')
					{
						targetCount++;
						rowcord = r;
						colcord = c;
						System.out.println("(" + rowcord + "," + " " + colcord + ")");
						
					}	
				}
			}
			System.out.println(targetCount);
			System.out.println("");
			
		}
		
	}

	public static void main(String[] args)throws Exception
	{
		hiddenmissiles a=new hiddenmissiles();
		a.run();
	}
}