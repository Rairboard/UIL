/*
 *UIL Computer Science 2020
 *Invitational B Packet - Alternate Solution
 */
import java.util.*;
import java.io.*;
import static java.lang.System.*;
class KellyAlt
{
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("kelly.dat"));
		char [][] g = {{' '},
					  {' ','A','B','C','D','E'},
					  {' ','F','G','H','I','J'},
					  {' ','L','M','N','O','P'},
					  {' ','Q','R','S','T','U'},
					  {' ','V','W','X','Y','Z'}};
		while (f.hasNext())
		{
			String s = f.nextLine();
			Scanner ch = new Scanner(s);
			while(ch.hasNext())
			{
				int a = ch.nextInt();
				int b = ch.nextInt();
				out.print(g[a][b]);
			}
			out.println();
		}
		f.close();
	}
}