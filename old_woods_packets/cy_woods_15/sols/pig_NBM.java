import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

			//change the class name
public class pig_NBM
{
	private String[][] mat;
	private String[][] copy;
	private boolean pass;
	private int best;
	
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("pig.dat"));
		
			//read in the number at the top of the data file
		int times = file.nextInt(); 
			//pick up the left over enter key
		
			//read in each data set
		for(int asdf = 0; asdf<times; asdf++)
		{
			pass=false;
			int row=file.nextInt();
			int col=file.nextInt();
			mat=new String[row][col];
			copy=new String[row][col];
			file.nextLine();
			best=100;
			
			for(int r=0; r<row; r++)
			{
				String str=file.nextLine();
				for(int c=0; c<str.length(); c++)
				{
					mat[r][c]=str.substring(c,c+1);
					copy[r][c]=str.substring(c,c+1);
				}
			}
			for(int r=0; r<row; r++)
			{
				for(int c=0; c<col; c++)
				{
					if(mat[r][c].equals("D"))
						recur(r,c,0);
				}
			}
			if(best<=7)
				pass=true;
			if(pass)
				System.out.println("BACON");
			else
				System.out.println("PIG ON THE RUN");
		}
	}
	
	public void recur(int r, int c, int days)
	{
		if(days<=7 && r<mat.length && r>=0 && c<mat[r].length && c>=0 && !mat[r][c].equals("H"))
		{
			if(mat[r][c].equals("O"))
			{
				best=days;
			}
			else
			{
				copy[r][c]="*";
				recur(r+1, c, days+1);
				recur(r-1, c, days+1);
				recur(r, c+1, days+1);
				recur(r, c-1, days+1);
			}
		}
	}
	
	
	

	public static void main(String[] args) throws Exception
	{
			//change this to whatever your class name is
		new pig_NBM().run();
	}	
	
}