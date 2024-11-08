import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class lucky7_JVJ
{
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("judges.dat"));
		int times = file.nextInt(); 	
		file.nextLine();
		
		for(int x = 0; x<times; x++)
		{
			int rows = file.nextInt();
			file.nextLine();

			for(int r=0;r<rows;r++)
			{
				String nums = file.nextLine();
				Scanner chop = new Scanner(nums);
				if(chop.nextInt()==7 &&chop.nextInt()==7 &&chop.nextInt()==7)
				{
						System.out.println("WINNER");
					
				}
				else
						System.out.println("LOSER");
			}
			
		}
	}

	public static void main(String[] args) throws Exception
	{
		new lucky7_JVJ().run();
	}	
}