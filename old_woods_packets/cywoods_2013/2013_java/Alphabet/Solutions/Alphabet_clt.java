import java.io.*;
import java.util.*;

public class Alphabet_clt
{
	//instance variables go here
	
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("alpha.dat"));
		int run=file.nextInt();
		file.nextLine();
		for(int q=0; q<run; q++)
		{
			char[] good=file.nextLine().toCharArray();
			int spa=0;
			for(char let=91; let>64; let--)
			{
				for(int i=0; i<spa; i++)
				{
					System.out.print(" ");
				}
				spa++;
				if(let<=good[2] && let>=good[0])
				{
					System.out.print(let + "\n");
				}
				else
				{
					System.out.print("#\n");
				}
			}
		}
	}
	
	public static void main(String[] args)throws Exception
	{
		Alphabet_clt a=new Alphabet_clt();
		a.run();
	}	
}