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
	private static String alpha="abcdefghijklmnopqrstuvwxyz";

	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("cipher.dat"));
		int times=file.nextInt();
		file.nextLine();
		for(int go=0;go<times;go++)
		{
			String base=file.nextLine();
			String ans="";
			for(int x=0;x<base.length();x++)
			{
				if(base.charAt(x)=='a')
					ans+="a";
				else if(base.charAt(x)=='w')
					ans+="w";
				else if(base.charAt(x)=='r')
					ans+="r";
				else if(base.charAt(x)==' ')
					ans+=" ";
				else ans+="-";
			}
			for(int x=0;x<base.length();x++)
			{
				if(ans.charAt(x)=='-'&&base.charAt(x)!=' ')
				{
					int get=alpha.indexOf(""+base.charAt(x));
					get--;
					if(get<1)
						get=25;
					if(get==17)
						get=16;
					if(get==22)
						get=21;
					ans=ans.substring(0,x)+alpha.charAt(get)+ans.substring(x+1);
				}
			}
			System.out.println(ans);
		}
	}

	public static void main(String[] args)throws Exception
	{
		template a=new template();
		a.run();
	}
}