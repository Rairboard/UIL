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
		Scanner file = new Scanner(new File("lucky7.dat"));
		
		int times = file.nextInt();
		file.nextLine();
		
		for(int i = 0; i<times; i++)
		{
			int size = file.nextInt();
			mat = new int[size][3];
			for(int r = 0; r<mat.length; r++){
				for(int c = 0; c<mat[r].length; c++){
					mat[r][c] = file.nextInt();
				}
				file.nextLine();
			}
			String out = "LOSER";
			for(int r=0; r<mat.length; r++){
				int count = 0;
				for(int c=0; c<mat[r].length; c++){
					if(mat[r][c]==7){
						count ++;
					}
				}
				if(count == 3){
					out = "WINNER";
					
				}
				
				System.out.println(out);
			}
		}
	}

	public static void main(String[] args) throws Exception
	{
		new lucky7().run();
	}	
	
}