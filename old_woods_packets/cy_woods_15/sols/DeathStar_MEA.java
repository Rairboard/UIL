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


public class DeathStar_MEA
{
	
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("DeathStar.dat"));
		int planets = file.nextInt();
		file.nextLine();
		
		for(int i = 0; i < planets; i++)
		{
				System.out.println(file.nextLine().equals("Rebellion"));
		}
	}
	
	public static void main(String[] args)throws Exception
	{
		DeathStar_MEA dS = new DeathStar_MEA();
		dS.run();
	}	
}