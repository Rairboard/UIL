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


public class Cosmic
{
	public void run()throws Exception
	{
		Scanner file = new Scanner(new File("Cosmic.dat"));
		int zz = file.nextInt();file.nextLine();
		for(int z = 0;z<zz;z++)
		{
			int n = file.nextInt();
			while(true)
			{
				String s = conv(n,true);
				System.out.println((s+" is "+conv(len(s),true)).replaceAll("\\s+"," "));
				n = len(s);
				if(n==4)
				{
					System.out.println("four is cosmic");
					System.out.println();
					break;
				}	
			}
			
		}
	}
	
	public int len(String s)
	{
		return s.replaceAll(" ","").length();
	}
	
	public String conv(int i,boolean b)
	{
		if(i==0)
			return b?"zero":"";
		String[] ones = "z one two three four five six seven eight nine ten eleven twelve thirteen fourteen fifteen sixteen seventeen eighteen nineteen".split(" ");
		String[] tens = "z ten twenty thirty forty fifty sixty seventy eighty ninety".split(" ");
		if(i==1000000)
			return "one million";
		if(i<20)
			return ones[i];
		if(i<100)
			return tens[i/10]+" "+conv(i%10,false);
		if(i<1000)
			return ones[i/100]+" hundred "+conv(i%100,false);
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(i!=0){
			list.add(0,i%1000);
			i/=1000;
		}
		return conv(list.get(0),false)+" thousand "+conv(list.get(1),false);	
	}

	public static void main(String[] args)throws Exception
	{
		Cosmic a=new Cosmic();
		a.run();
	}

}