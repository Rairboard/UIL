import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

		
public class deathStar_KAS
{
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("planetData.dat"));
	
		int times = file.nextInt();
		file.nextLine();
		
		for(int asdf = 0; asdf<times; asdf++)
		{   
			String bob= file.nextLine();
			System.out.println(bob.equals("Rebellion"));
		}
	}

	public static void main(String[] args) throws Exception
	{
			//change this to whatever your class name is
		new deathStar_KAS().run();
	}	
	
}