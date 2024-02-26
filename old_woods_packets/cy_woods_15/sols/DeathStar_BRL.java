import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class DeathStar_BRL
{
	private int[] out;
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("DeathStar.dat"));
		
		int times = file.nextInt(); 
		file.nextLine();

		for(int i = 0; i<times; i++)
		{
			if(file.nextLine().equals("Rebellion")) 
				System.out.println("True");
			else
				System.out.println("False");
			
		}
	}

	public static void main(String[] args) throws Exception
	{
		new DeathStar_BRL().run();
	}	
	
}