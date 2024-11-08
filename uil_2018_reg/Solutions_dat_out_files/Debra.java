//UIL 2018 - Region - Debra
import java.io.*;
import java.util.*;
import static java.lang.System.*;
import static java.lang.Math.*;

public class Debra{
	public static void main(String [] args) throws IOException
	{ 
		Scanner f = new Scanner(new File("debra.dat"));
		while(f.hasNext())
		{
			int R = f.nextInt();
			int C = f.nextInt();
			f.nextLine();
			char[][]g=new char[R][C];
			int row = 0;
			while(row<R)
			{
				String s = f.nextLine();
				g[row++] = s.toCharArray();
			}
			for(int r=0;r<g.length;r++)
			{
				for(int c=g[r].length-1;c>=0;c--)
					out.print(g[r][c]);
				out.println();
			}
			out.println("=====");
		}
		f.close();
	}
}
