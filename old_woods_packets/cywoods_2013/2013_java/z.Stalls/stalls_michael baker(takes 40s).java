//michael baker
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
	private static int[] stalls;

	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("stalls.dat"));
		int times=file.nextInt();
		file.nextLine();
		for(int go=0;go<times;go++)
		{
			stalls=new int[file.nextInt()];
			Arrays.fill(stalls,0);
			int cases=file.nextInt();
			file.nextLine();
			int passes=0;
			for(int cas=0;cas<cases;cas++)
			{
				String[] t=file.nextLine().split(" ");
				if(t[0].equals("C"))
				{
					int s=Integer.parseInt(t[1])-1;
					int e=Integer.parseInt(t[2]);
					for(int x=s;x<e;x++)
					{
						stalls[x]+=1;
					}
				}
				if(t[0].equals("I"))
				{
					int s=Integer.parseInt(t[1])-1;
					int e=Integer.parseInt(t[2]);
					int v=Integer.parseInt(t[3]);
					int cows=0;
					for(int x=s;x<e;x++)
					{
						cows+=stalls[x];
					}
					if(cows<=v)
						passes++;
				}
			}
			System.out.println(passes);
		}
	}

	public static void main(String[] args)throws Exception
	{
		template a=new template();
		a.run();
	}
}