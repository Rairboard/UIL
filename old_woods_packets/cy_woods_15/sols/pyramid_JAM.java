import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class pyramid
{
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("judgespyramid.dat"));
		int times = file.nextInt(); 
		file.nextLine();
		
		for(int asdf = 0; asdf<times; asdf++)
		{
			int x = file.nextInt();
			if(x != 0)
			{
				for(int y = x; y > 0; y--)
				{	
					for(int z = 0; z < y; z++)
					{
						System.out.print(y); 
					}
					System.out.println("");
				}
			}
			else
			{
				System.out.println("Not Buildable");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws Exception
	{
		new pyramid().run();
	}	
	
}