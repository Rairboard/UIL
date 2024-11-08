import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class Pyramid_BRL
{
	private int[] out;
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("judgespyramid.dat"));
		
		int times = file.nextInt(); 
		file.nextLine();

		for(int i = 0; i<times; i++)
		{
			int k = file.nextInt();
			for(int a = k; a>0 ; a--)
			{
				for(int j = a; j > 0; j--)
					System.out.print("" + a);
				System.out.println("");
			}
			if(k == 0)
				System.out.println("NOT BUILDABLE");
			System.out.println("");	
			
		}
	}

	public static void main(String[] args) throws Exception
	{
		new Pyramid_BRL().run();
	}	
	
}