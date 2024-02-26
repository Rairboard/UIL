/**
 * @(#)marbles_dal.java
 *
 *
 * @author 
 * @version 1.00 2013/8/26
 */
 
import java.util.*;
import java.io.*;
import java.text.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Character.*;
import static java.lang.Math.*;
import static java.util.Collections.*;
import static java.util.Arrays.*;



public class marbles_dal 
{
	
	public void run()throws Exception
	{
		Scanner file = new Scanner(new File("bagJudge.dat"));
		int n = file.nextInt();
		file.nextLine();
		
		for(int i = 0;i<n;i++)
		{
			int red = file.nextInt();
			int blue = file.nextInt();
			int green = file.nextInt();
			int yellow = file.nextInt();
			int total = red + blue + green + yellow;
			int cases = file.nextInt();
			file.nextLine();

			for(int c = 0;c<cases;c++)
			{
				String color = file.nextLine();
				String col = "";
				if(color.equals("Red"))
					col = "" + red + "/" + total;
				if(color.equals("Blue"))
					col = "" + blue + "/" + total;
				if(color.equals("Green"))
					col = "" + green + "/" + total;
				if(color.equals("Yellow"))
					col = "" + yellow + "/" + total;
				System.out.println(col);										
			}
		}
	}

        
    public static void main(String[] args) throws Exception
    {
 		marbles_dal a = new marbles_dal();
 		a.run();
    }
}
