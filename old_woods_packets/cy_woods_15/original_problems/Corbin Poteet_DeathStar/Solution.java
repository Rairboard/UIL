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


public class Solution
{
	
	public run() throws FileNotFoundException
	{
		Scanner file = new Scanner(new File("planetData.dat"));
		int planets = file.nextInt();
		file.next();
		
		for(int i = 0; i < planets; i++)
		{
				if(file.nextLine().equals("Rebellion")){ System.out.println("True"); }
				else { System.out.println("False"); }
		}
	}
	
	public static void main(String[] args)throws FileNotFoundException
	{
		DeathStar dS = new DeathStar();
		dS.run();
	}	
}