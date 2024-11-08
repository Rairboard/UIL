import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;
import static java.lang.System.*;

public class Pyramid_BJR
{
	private int[] out;
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("judgespyramid.dat"));
		
		int times = file.nextInt(); 
		file.nextLine();

		for(int asdf = 0; asdf<times; asdf++)
		{
			int num = file.nextInt();
			file.nextLine();
			if(num==0)
				System.out.println("NOT BUILDABLE");
			else
			{
				int curnum = num;
				for(int a=0;a<num;a++)
				{
					for(int i=0;i<curnum;i++)
					{
						System.out.print(curnum);
					}
					System.out.println();
					curnum--;
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws Exception
	{
		new Pyramid_BJR().run();
	}	
	
}