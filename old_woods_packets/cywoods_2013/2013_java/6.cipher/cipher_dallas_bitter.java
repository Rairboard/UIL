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


public class cipher
{
	//instance variables go here

	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("cipher.dat"));
		int jim = file.nextInt();
		file.nextLine();
		ArrayList<Character> val = new ArrayList<Character>();
		for(char c: "bcdefghijklmnopqstuvxyz".toCharArray())
		{
			val.add(c);
		}
		ArrayList<Character> key = val;
		Collections.rotate(val, val.size()-1);
		String e = "war ";
		for(int bob = 0; bob<jim; bob++)
		{
			String in = file.nextLine().toLowerCase();
			String ciph = "";
			for(char c: in.toCharArray())
			{
				if(e.indexOf(c)==-1)
				{
					int i = key.indexOf(c);
					if(i == 0)
					{
						ciph+=val.get(key.size()-1);
					}
					else
					{
						ciph+=val.get((key.indexOf(c)-1)%key.size());
					}
						
				}
				else
				{
					ciph+=c;
				}			
			}
			out.println(ciph);
		}
	}

	public static void main(String[] args)throws Exception
	{
		cipher a=new cipher();
		a.run();
	}
}