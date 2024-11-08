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


class template
{
	//instance variables go here
	char[][] mat; 
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("CountCopyCatJudges.dat"));
		Scanner chop = new Scanner("");
		int run = file.nextInt(); 
		for(int i = 0; i < run ; i++)
		{
			int row = file.nextInt(); 
			int col = file.nextInt(); 
			mat = new char [row][col]; 
				
			for(int r = 0; r< mat.length; r++)
			{
				String s = file.next(); 
				mat[r] = s.toCharArray();
				
			}
			int cases = file.nextInt(); 
			for(int l = 0; l<cases; l++)
			{
				int x = file.nextInt()-1; 
				int y = file.nextInt()-1;
				char c = mat[x][y]; 
				System.out.println(count(x, y, c)); 
				
 			}
		}
	}
	public  int count(int x, int y, char c)
	{
		if(x >=0 && x < mat.length && y>= 0 && y <mat[x].length)
		{
			if(mat[x][y] == c)
			{
				mat[x][y] = '#'; 
				return 1 + count(x,y-1, c) + count(x,y+1, c) + count(x+1, y, c) + count(x-1, y, c) + count(x-1, y-1, c) + count(x+1, y+1, c) + count(x-1, y+1, c) + count(x+1, y-1,c); 
			}
		}
		return 0; 
	}

	public static void main(String[] args)throws Exception
	{
		template a=new template();
		a.run();
	}
}