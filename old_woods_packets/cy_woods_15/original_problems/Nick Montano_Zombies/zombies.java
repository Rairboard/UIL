import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

			//change the class name
public class zombies
{
	public int[] arr;
	public String[][] mat;
	public int row;
	public int col;
		
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("zombiesj.dat"));
			//read in the number at the top of the data file
		int times = file.nextInt(); 
			//pick up the left over enter key
		
			//read in each data set
		for(int asdf = 0; asdf<times; asdf++)
		{
			row=file.nextInt();
			col=file.nextInt();
			mat=new String[row][col];
			file.nextLine();
			for(int r=0; r<row; r++)
			{
				String str= file.nextLine();
				for(int s=0; s<str.length(); s++)
					mat[r][s]=str.substring(s,s+1);
			}
			int count=0;
			for(int r=0; r<row; r++)
			{
				for(int c=0; c<col; c++)
				{
					if(!mat[r][c].equals("#"))
						count++;
				}
			}
			arr=new int[count];
			
			for(int r=0; r<row; r++)
			{
				for(int c=0; c<col; c++)
				{
					if(mat[r][c].equals("@"))
						linearize(r,c,0);
				}
			}
			recur(0,1);
			System.out.println();
		}
	}
	
	public void linearize(int r, int c, int spot)
	{
		if(r<row && r>=0 && c<col && c>=0 && !mat[r][c].equals("#"))
		{
			if(mat[r][c].equals("@") || mat[r][c].equals("-") || mat[r][c].equals("E"))
				arr[spot]=0;
			else
				arr[spot]=Integer.parseInt(mat[r][c]);				
			
			mat[r][c]="#";
			spot++;
			linearize(r+1, c, spot);
			linearize(r-1, c, spot);
			linearize(r, c+1, spot);
			linearize(r, c-1, spot);
		}
	}
	
	
	
	public void recur(int spot, int days)
	{
		if(spot==arr.length-1)
		{
			days--;
			System.out.println("Day " + days + ": Exit");
		}
		else 
		{
			if(arr[spot]>0)
			{
				System.out.println("Day " + days + ": Block " + spot);
				arr[spot]--;
			}
			else
			{
				spot++;
			}
			for(int i=1; i< arr.length; i++)
			{
				if(arr[i]>0 && i!=spot)
				{
					arr[i-1]+=arr[i];
					arr[i]=0;
				}
			}
			days++;
			recur(spot, days);
		}
	}

	public static void main(String[] args) throws Exception
	{
			//change this to whatever your class name is
		new zombies().run();
	}	
	
}