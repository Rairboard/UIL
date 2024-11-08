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
import java.util.Scanner;


public class DeathStar
{
	
	public void run() throws FileNotFoundException
	{
		Scanner file = new Scanner(new File("planetData.dat"));
		int times = file.nextInt();
		file.nextLine();
		
		for(int x=0; x<times; x++)
		{
			String s = file.nextLine();
			System.out.println(s.equals("Rebellion"));
		}
	}
	
	public static void main(String[] args)throws FileNotFoundException
	{
		DeathStar a = new DeathStar();
		a.run();
	}	
}