import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class GridSearch
{
	static char g[][];
	public static void look(String s, int r, int c)
	{
		//look right
		if(c+s.length()<=g[r].length)
		{
			boolean match = true;
			for(int x=0;x<s.length();x++)
				if(g[r][c+x]!=s.charAt(x))
					match=false;
			if(match)
				out.printf("%d,%d,%s ",r+1,c+1,"right");
		}
		//look down
		if(r+s.length()<=g.length)
		{
			boolean match = true;
			for(int x=0;x<s.length();x++)
				if(g[r+x][c]!=s.charAt(x))
					match=false;
			if(match)
				out.printf("%d,%d,%s ",r+1,c+1,"down");
		}
		//look left
		if(c-s.length()>=-1)
		{
			boolean match = true;
			for(int x=0;x<s.length();x++)
				if(g[r][c-x]!=s.charAt(x))
					match=false;
			if(match)
				out.printf("%d,%d,%s ",r+1,c+1,"left");

		}
		//look up
		if(r-s.length()>=-1)
		{
			boolean match = true;
			for(int x=0;x<s.length();x++)
				if(g[r-x][c]!=s.charAt(x))
					match=false;
			if(match)
				out.printf("%d,%d,%s ",r+1,c+1,"up");
		}
	}
	public static void main(String [] args) throws FileNotFoundException 
	{
		Scanner f = new Scanner(new File("gridsearch.dat"));
		int n = f.nextInt();
		g=new char[n][n];
		for(int r=0;r<g.length;r++)
		{
			String s = f.next();
			for(int c=0;c<s.length();c++)
				g[r][c]=s.charAt(c);
		}
		n=f.nextInt();
		while(n-->0)
		{
			String s = f.next();
			out.printf("%s ",s);
			for(int r=0;r<g.length;r++)
				for(int c = 0;c<g[r].length;c++)
					if(s.charAt(0) == g[r][c])
						look(s,r,c);
					out.println();	
		}
	}
}
/*
Student Input
6
123454
254321
353451
443452
534343
145234
5
5435
3454
4112
1543
3451

Student Output
5435 3,5,left
3454 1,3,right
4112 1,6,down
1543 3,6,left 6,1,up
3451 3,1,down 3,3,right

Test Input
7
1234542
2543215
3534511
4434523
5343434
1452343
5241355
12
5435
3454
4112
1543
3451
1452
4432
3434
4321
1234
5531
5343

Test Output
5435 3,5,left
3454 1,3,right 4,3,down
4112 1,6,down
1543 3,6,left 6,1,up
3451 3,1,down 3,3,right
1452 6,1,right
4432 3,4,down
3434 5,2,right 5,4,right 5,6,left
4321 1,4,left 2,3,right 4,1,up 4,4,down 6,6,up
1234 1,1,right 1,1,down 2,6,left 3,6,down 7,4,up
5531 7,7,left
5343 5,1,right 7,7,up
*/