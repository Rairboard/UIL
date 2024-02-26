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
	//instance variables go here

	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("hiddenmissiles.dat"));
		int times = file.nextInt();
		for (int a = 0; a < times; a++)
		{
			int numO = 0;
			int numR = file.nextInt();
			int numC = file.nextInt();
			file.nextLine();
			char[][] map = new char[numR][numC];
			for (int b = 0; b < map.length; b++)
			{
				map[b] = file.nextLine().toCharArray();
			}
			for (int c = 0; c < map.length; c++)
			{
				for (int d = 0; d < map[c].length; d++)
				{
					if (map[c][d] == 'o')
					{
						numO++;
						System.out.println("(" + c + "," + " " + d + ")");
					}
				}
			}
			System.out.println(numO);
		}
	}

	public static void main(String[] args)throws Exception
	{
		hiddenmissiles a=new hiddenmissiles();
		a.run();
	}
}