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


class password
{
	//instance variables go here

	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("password-judge.dat"));
		int times = file.nextInt();file.nextLine();
		for(int n=0;n<times;n++)
		{
			String line = file.nextLine();
			String fH = line.substring(0,line.length()/2);
			String sH = line.substring(line.length()/2);
			//out.println(fH+" "+sH);
			//out.println(line);
			String op = "";
			int x=0;
			for(;x<fH.length();x++)
			{
				op+=sH.charAt(x);
				op+=fH.charAt(x);
			}
			op+=""+sH.substring(x);
			out.println(op);
		}
	}

	public static void main(String[] args)throws Exception
	{
		password a=new password();
		a.run();
	}
}