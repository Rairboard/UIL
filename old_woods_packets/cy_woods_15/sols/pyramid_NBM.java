import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

			//change the class name
public class pyramid_NBM
{
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("judgespyramid.dat"));
		
			//read in the number at the top of the data file
		int times = file.nextInt(); 
			//pick up the left over enter key
		file.nextLine();
		
			//read in each data set
		for(int asdf = 0; asdf<times; asdf++)
		{
			int size=file.nextInt();
			if(size==0)
			{
				System.out.println("NOT BUILDABLE");
			}
			for(int i=size; i>=0; i--)
			{
				for(int x=i; x>0; x--)
				{
					System.out.print(i);
				}
				System.out.println();
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws Exception
	{
			//change this to whatever your class name is
		new pyramid_NBM().run();
	}	
	
}