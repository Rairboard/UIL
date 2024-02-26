import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

			//change the class name
public class DeathStar_JVJ
{
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("DeathStar.dat"));
		int planets = file.nextInt();
		file.nextLine();
		
		for(int x = 0;x < planets;x++)
		{
			System.out.println(file.nextLine().equals("Rebellion"));
		}
	}

	public static void main(String[] args) throws Exception
	{
			//change this to whatever your class name is
		new DeathStar_JVJ().run();
	}	
	
}