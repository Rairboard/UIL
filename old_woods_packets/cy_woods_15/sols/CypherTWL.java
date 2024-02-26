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


class Cypher
{
	//instance variables go here
	char[][] mat;
	public void run()throws Exception
	{
		Scanner file = new Scanner(new File("cypherjudges.dat"));
		
		mat = new char[27][27];
		for(int r = 0; r < mat.length; r++)
		{
			for(int c = 0; c < mat[r].length; c++)
			{
				mat[r][c] = file.next().charAt(0);
			}
		
		}
		file.nextLine();
		int times = file.nextInt();
		
		file.nextLine();
		
		for(int asdf = 0; asdf < times; asdf++)
		{
			String text = file.nextLine();
			String key = file.nextLine();
			if(file.hasNextLine())
			{
				file.nextLine();
			}
			
			String out = "";
			for(int i = 0; i < text.length(); i++)
			{
				char temp = text.charAt(i);
				char keytemp = key.charAt(i % key.length());
				for(int r = 0; r < mat.length; r++)
				{
					if(mat[r][0] == keytemp)
					{
						for(int c = 1; c < mat[r].length; c++)
						{
							if(mat[r][c] == temp)
							{
								out += "" + mat[0][c];	
							}
						}
					}
				}
			}
			System.out.println(text + " decrypted with " + key + " : " + out);
		}
		

	}
	


	public static void main(String[] args)throws Exception
	{
		Cypher a=new Cypher();
		a.run();
	}
}