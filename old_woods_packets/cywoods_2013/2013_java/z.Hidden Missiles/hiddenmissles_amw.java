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


class hiddenmissles
{
	//instance variables go here

	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("hiddenmissiles.dat"));
		Scanner chop = new Scanner("");
		int zz = file.nextInt();
		file.nextLine();
		for(int times = 0; times<zz;times++)
		{
			int rows = file.nextInt();
			int columns = file.nextInt();
			file.nextLine();
			String[][] grid = new String[rows][columns];
			ArrayList<String> coords = new ArrayList<String>();
			for(int r=0;r<rows;r++)
			{
				String[] line = file.nextLine().split("");
				for(int c=1;c<columns+1;c++)
				{
					grid[r][c-1] = line[c];
					if(line[c].equals("o"))
					{
						coords.add("("+r+","+(c-1)+")");
					}
				}
			}
			for(String s: coords)
			{
				System.out.println(s);
			}
			System.out.println(coords.size() + "\n");
		}
	}

	public static void main(String[] args)throws Exception
	{
		hiddenmissles a=new hiddenmissles();
		a.run();
	}
}