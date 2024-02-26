import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

			//change the class name
public class Lucky7_JTV
{
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("lucky7.dat"));
		int times = file.nextInt(); 
		file.nextLine();
		for(int asdf = 0; asdf<times; asdf++)
		{
			if(file.nextLine().equals("7 7 7"))
				System.out.println("WINNER");
			else
				System.out.println("LOSER");	
		}
	}

	public static void main(String[] args) throws Exception
	{
			//change this to whatever your class name is
		new Lucky7_JTV().run();
	}	
	
}