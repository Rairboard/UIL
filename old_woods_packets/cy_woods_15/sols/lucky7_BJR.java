import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

			
public class lucky7_BJR
{
	private int[][] mat;
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("judges.dat"));
		
		int times = file.nextInt(); 	
		file.nextLine();
		
		for(int i = 0; i<times; i++)
		{
			int rows = file.nextInt();
			file.nextLine();
			boolean win = false;
			for(int r=0;r<rows;r++)
			{
				String nums = file.nextLine();
				Scanner chop = new Scanner(nums);
				if(chop.nextInt()==7 &&chop.nextInt()==7 &&chop.nextInt()==7)
				{
					win = true;
				}
			}
			if(win)
				out.println("WINNER");
			else
				out.println("LOSER");
		}
	}

	public static void main(String[] args) throws Exception
	{
		new lucky7_BJR().run();
	}	
	
}