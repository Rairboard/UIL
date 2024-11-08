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

public class Lucky7_RMM
{

	public void run() throws IOException
	{
		Scanner input=new Scanner( new File("lucky7.dat"));
		int numOfParts=input.nextInt();
		input.nextLine();
		
		for (int a=0; a<numOfParts; a++)
		{
			boolean win=false;
			
			int numOfRows=input.nextInt();
			for (int b=0; b<numOfRows; b++)
			{
				int first=input.nextInt();
				int second=input.nextInt();
				int third=input.nextInt();
				if (first==second && second==third)
					win=true;
			}
			if (win==true)
				System.out.println("WINNER");
			else
				System.out.println("LOSER");
			input.nextLine();
		}
	}

	public static void main(String[] args) throws IOException	
	{
		new Lucky7_RMM().run(); 
	}
    
}