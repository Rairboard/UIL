import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

			//change the class name
public class liberties_NBM
{
	private String[][] mat;
	
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("liberties-judge.dat"));
		
			//read in the number at the top of the data file
		int times = file.nextInt(); 
			//pick up the left over enter key
		file.nextLine();
			//read in each data set
		for(int asdf = 0; asdf<times; asdf++)
		{
			mat=new String[file.nextInt()][file.nextInt()];
			file.nextLine();
			for(int r=0; r<mat.length; r++)
			{
				String line=file.nextLine();
				for(int s=0; s<line.length(); s++)
				{
				mat[r][s]=line.substring(s,s+1);
				}
			}
			for(int r=0; r<mat.length; r++)
			{
				for(int c=0; c<mat[r].length; c++)
				{
					if(mat[r][c].equals("W") && !isFree(r,c))
						System.out.println(r + " " + c);
				}
			}
			System.out.println();
		}
	}
	
	public boolean isFree(int r, int c)
	{
		boolean ret = true;
		if(r-1>=0 && !mat[r-1][c].equals("B"))
			ret=false;
		if(c-1>=0 && !mat[r][c-1].equals("B"))
			ret=false;
		if(r+1<mat.length && !mat[r+1][c].equals("B"))
			ret=false;
		if(c+1<mat[r].length && !mat[r][c+1].equals("B"))
			ret=false;
		return ret;
	}

	public static void main(String[] args) throws Exception
	{
			//change this to whatever your class name is
		new liberties_NBM().run();
	}	
	
}