import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class Pyramid_JVJ
{
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("judgespyramid.dat"));
		int times = file.nextInt(); 
		file.nextLine();
		int[] out = new int[0];
		
		for(int x = 0;x < times;x++)
		{
			int next = file.nextInt();
			if(next == 0)
			{
				System.out.println("NOT BUILDABLE");
				System.out.println();
			}
			else
			{
				for(int y = next;y >= 0;y-- )
				{
					out = new int[y];
					for(int z = 0;z < y;z++)
					{
						out[z] = y;
						System.out.print(out[z]);
					}
					System.out.println();
			   }
			}			
		}
	}

	public static void main(String[] args) throws Exception
	{
		new Pyramid_JVJ().run();
	}	
}