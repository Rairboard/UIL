import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

			//change the class name
public class DeathStar_JTV
{
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("planetData.dat"));
		
			//read in the number at the top of the data file
		int times = file.nextInt(); 
			//pick up the left over enter key
		file.nextLine();
		
			//read in each data set
		for(int asdf = 0; asdf<times; asdf++)
		{
			if(file.nextLine().equals("Empire"))
				System.out.println("False");
			else
				System.out.println("True");	
		}
	}

	public static void main(String[] args) throws Exception
	{
			//change this to whatever your class name is
		new DeathStar_JTV().run();
	}	
	
}