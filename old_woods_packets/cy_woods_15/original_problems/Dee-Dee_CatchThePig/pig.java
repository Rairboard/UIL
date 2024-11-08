import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

			//change the class name
public class pig
{
	
	private boolean pass;
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("pig.dat"));
		int times = file.nextInt(); 
		file.nextLine();
	
		for(int asdf = 0; asdf<times; asdf++)
		{
			pass = false;
			int rows = file.nextInt();
			int cols = file.nextInt();
			file.nextLine();
			
			char[][]mat = new char[rows][cols];
			for (int r = 0; r < rows; r++)
			{
				mat[r] = file.nextLine().toCharArray();
			}

			out:
			for (int r = 0; r < rows; r++)
			{
				for (int c = 0; c < cols; c++)
				{
					if (mat[r][c] == 'D')
					{
						go(r,c,7,0,mat);
						break out;

					}
				}
				
			}
			if (pass)
				System.out.println("BACON");
			else
				System.out.println("PIG ON THE RUN");
				
		}
	}
	
	
	
	
	public void go (int r, int c, int bs, int st, char[][]mat)
	{
		if(r >=0 && c >=0 && r < mat.length && c < mat[r].length && mat[r][c] != 'H' && st<=bs)
		{
			st++;
			char[][]temp = copy(mat);
			
			if (temp[r][c] == 'O')
			{
				pass = true;
					return;
			}
			temp[r][c] = 'H';
			go(r+1,c,bs,st,temp); go(r-1,c,bs,st,temp);go(r,c+1,bs,st,temp); go(r, c-1, bs,st, temp);
		}
		
	}
	public char[][] copy(char[][] mat)
	{
		char[][]temp = new char[mat.length][mat[0].length];
		for (int r =0; r < mat.length; r++)
		{
			for (int c=0; c < mat[r].length; c++)
			{
				temp[r][c] = mat[r][c];
			}
		}
		return temp;
	}
	public static void main(String[] args) throws Exception
	{
		new pig().run();
	}	
	
}