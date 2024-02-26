import java.io.*;
import java.util.*;

public class Poker
{
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("poker.dat"));
		int run=file.nextInt();
		file.nextLine();
		for(int q=0; q<run; q++)
		{
			char[][] card=new char[10][11];
			for(int i=0; i<10; i++)
			{
				card[i]=file.nextLine().toCharArray();
			}
			String val;
			switch(card[2][1])
			{
				case 'K' : val="King of "; break;
				case 'Q' : val="Queen of "; break;
				case 'J' : val="Jack of "; break;
				case 'A' : val="Ace of "; break;
				case '1' : val="10 of "; break;
				default : val=card[2][1]+" of "; break;
			}
			if(card[3][5]==',')
				val+="Spades";
			else if(card[4][4]=='(')
				val+="Clubs";
			else if(card[4][5]=='^')
				val+="Diamonds";
			else
				val+="Hearts";
			System.out.println(val);
		}
	}

	public static void main(String[] args)throws Exception
	{
		Poker a=new Poker();
		a.run();
	}
}