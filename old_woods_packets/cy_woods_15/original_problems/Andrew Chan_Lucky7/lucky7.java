import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

			
public class lucky7
{
	private int[][] mat;
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("judges.dat"));
		
		int times = file.nextInt(); 	
		file.nextLine();
		
		for(int a = 0; a<times; a++)
		{
			int rows = file.nextInt();
			mat = new int[rows][3];
		
			for(int r=0;r<mat.length;r++){
				for(int c=0;c<mat[r].length;c++){
					mat[r][c]=file.nextInt();
				}
				file.nextLine();
			}
			String check = "LOSER";
			for(int r=0;r<mat.length;r++){
				int count = 0;
				for(int c=0;c<mat[r].length;c++){
					if(mat[r][c]==7)
						count++;
				}
				if(count==3)
					check = "WINNER";
		}
			System.out.println(check);
		}
		
	}

	public static void main(String[] args) throws Exception
	{
		new lucky7().run();
	}	
	
}