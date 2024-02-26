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

public class FactorFact_RMM
{

	public void run() throws IOException
	{
		Scanner input=new Scanner( new File("factor.dat"));
		int numOfParts=input.nextInt();
		input.nextLine();
		
		for (int a=0; a<numOfParts; a++)
		{
			int num=input.nextInt();
			int currentNum=1;
			for (int b=1; b<num; b++)
			{
				if (currentNum<=num)
				{
					System.out.print(currentNum+" : ");
					for (int c=1; c<num; c++)
					{
						if (num%c==0 && c<=currentNum)
						{
							System.out.print(c+" ");
						}
						
					}
					if (currentNum==num)
							System.out.print(num+" ");	
					System.out.print("\n");	
					currentNum=currentNum*2;
				}
				
				
			}
			System.out.println("\n");
			input.nextLine();
		}
	}

	public static void main(String[] args) throws IOException	
	{
		new FactorFact_RMM().run(); 
	}
    
}