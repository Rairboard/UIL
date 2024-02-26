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


class temp
{
	//instance variables go here
	

	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("poker.dat"));
		Scanner chop = new Scanner("");
		
		char[][] card = new char[10][11];
		String suit = "";
		String line = "";
		
		int numtimes = file.nextInt();
		file.nextLine();
		
		for(int z = 0; z < numtimes; z++)
		{
			for(int x = 0; x < 10;x++)
			{
				line = file.nextLine();
				card[x] = line.toCharArray();
			}
			
			if(card[3][5] == ',')
			{
				suit = "Spades";
			}
			else if(card[4][5] == '^')
			{
				suit = "Diamonds";
			}
			else if(card[3][5] == '_')
			{
				suit = "Clubs";
			}
			else
			{
				suit = "Hearts";
			}
			
			if(card[2][1] == 'A')
			{
				System.out.println("Ace" + " of " + suit);
			}
			else if(card[2][1] == 'K')
			{
				System.out.println("Ace" + " of " + suit);
			}
			else if(card[2][1] == 'Q')
			{
				System.out.println("Ace" + " of " + suit);
			}
			else if(card[2][1] == 'J')
			{
				System.out.println("Ace" + " of " + suit);
			}
			else if(card[2][2] == '0')
			{
				System.out.println("10" + " of " + suit);
			}
			else
			{
				System.out.println(card[2][1] + " of " + suit);
			}
		}
	}

	public static void main(String[] args)throws Exception
	{
		temp a=new temp();
		a.run();
	}
}