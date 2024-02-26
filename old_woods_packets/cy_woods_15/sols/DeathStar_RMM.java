import java.util.*;
import java.util.Scanner;
import java.io.*;
import java.text.*;
import java.math.*;
import java.awt.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class DeathStar_RMM 
{

	public void run() throws IOException
	{
		Scanner input=new Scanner( new File("DeathStar.dat"));
		int numOfPlanets=input.nextInt();
		input.nextLine();
		
		for (int a=0; a<numOfPlanets; a++)
		{
			String currentPlanet=input.nextLine();
			if (currentPlanet.equals("Rebellion"))
				System.out.println("True");
			else
				System.out.println("False");
		}
	}

	public static void main(String[] args) throws IOException	
	{
		new DeathStar_RMM().run(); 
	}
    
}