import java.io.*;
import java.util.*;

public class Poker2
{
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("pokerj2.dat"));
		int run=file.nextInt();
		file.nextLine();
		for(int q=0; q<run; q++)
		{
			String card=file.nextLine();
			String[] val={"King","Queen","Jack","Ace"};
			String v="";
			for(String p : val)
			{
				if(card.contains(p))
				{
					char x=p.charAt(0);
					v="|" + x + "       " + x + "|\n";
				}
			}
			if(card.contains("10"))
			{
				v="|10     10|\n";
			}
			else
			{
				char x=card.charAt(0);
				v="|" + x + "       " + x + "|\n";
			}
			String suit="";
			if(card.contains("Spades"))
			{
				suit="|    ,    |\n|   / \\   |\n|  (_ _)  |\n|   /_\\   |\n|         |\n";
			}
			else if(card.contains("Clubs"))
			{
				suit="|    _    |\n|   ( )   |\n|  (_ _)  |\n|   /_\\   |\n|         |\n";
			}
			else if(card.contains("Diamonds"))
			{
				suit="|         |\n|    ^    |\n|   / \\   |\n|   \\ /   |\n|    v    |\n";
			}
			else
			{
				suit="| __   __ |\n|(  \\ /  )|\n| \\  v  / |\n|  \\   /  |\n|   \\ /   |\n";
			}
			String out=" _________ \n/         \\\n";
			out+=v;
			out+=suit;
			out+=v;
			out+="\\_________/";
			System.out.println(out);
		}
	}

	public static void main(String[] args)throws Exception
	{
		Poker2 a=new Poker2();
		a.run();
	}
}