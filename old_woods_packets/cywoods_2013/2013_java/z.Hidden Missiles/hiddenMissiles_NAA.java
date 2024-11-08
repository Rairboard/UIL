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


class hiddenMissiles
{
	//instance variables go here

	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("hiddenMissiles.dat"));
		int times = file.nextInt();file.nextLine();
		String outp="";
		for(int n=0;n<times;n++)
		{
			int r = file.nextInt();
			int c = file.nextInt();
			file.nextLine();
			char[][] mat = new char[r][c];
			int cnt = 0;
			for(int x=0;x<r;x++)
			{
				String line = file.nextLine();
				mat[x]=line.toCharArray();
				int i = line.indexOf('o');
				while(i>=0)
				{
					outp+="("+x+","+i+")\n";
					i = line.indexOf('o',i+1);
					cnt++;
				}
			}
			outp+=((cnt+"\n\n"));
			//out.println("");
		}
		out.println(outp.trim());
	}

	public static void main(String[] args)throws Exception
	{
		hiddenMissiles a=new hiddenMissiles();
		a.run();
	}
}