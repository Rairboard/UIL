import java.io.*;
import java.util.*;
import java.text.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Character.*;
import static java.util.Collections.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;


class FancyMatrixTWL
{
	//instance variables go here
	String[][] mat;
	public void run()throws Exception
	{
		Scanner file = new Scanner(new File("mc.dat"));
		
		int times = file.nextInt();
		
		file.nextLine();
		
		for(int asdf = 0; asdf < times; asdf++)
		{
			mat = new String[file.nextInt()][file.nextInt()];
			
			for(int r = 0; r < mat.length; r++)
			{
				Arrays.fill(mat[r],"#");
				if(r != mat.length-1 && r != 0)
				{
					for(int c = 1; c < mat.length - 1; c++)
					{
						if(r % 2 == 0)
						{
							if(c % 2 == 1)
							{
								mat[r][c] = " ";
							}
						}else if(c % 2 == 0)
						{
							mat[r][c] = " ";
						}
					}
				}
			}
			for(String[] r : mat)
			{
				for(String c : r)
				{
					System.out.print(c);
				}
				System.out.println();
			}
			System.out.println();
		}
		

	}
	


	public static void main(String[] args)throws Exception
	{
		FancyMatrixTWL a=new FancyMatrixTWL();
		a.run();
	}
}