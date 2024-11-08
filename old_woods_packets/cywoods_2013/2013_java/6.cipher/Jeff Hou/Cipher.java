//attempted by Jeff Hou
//also, whoever made this needs to revise the doc to say "shifts over 1 to the LEFT"
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


class template
{
	//instance variables go here

	public void run()throws Exception
	{
		Scanner kb=new Scanner(new File("cipher.dat"));
		int runs = kb.nextInt();
		kb.nextLine();
		for (int x=0; x<runs; x++)
		{
			char[] temp = kb.nextLine().toCharArray();
			for (int y=0; y<temp.length; y++)
			{	
				if ((int)temp[y]!=97&&(int)temp[y]!=114&&(int)temp[y]!=119&&temp[y]!=' ')
					if ((((int)temp[y])+1)>118)
						out.print('a');
					else
						out.print((char)((int)temp[y]-1));
				else
					out.print(temp[y]);
			}				

			out.println("");
		}
	}

	public static void main(String[] args)throws Exception
	{
		template a=new template();
		a.run();
	}
}