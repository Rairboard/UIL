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
import java.util.regex.Pattern.*;


class breeding
{
	char[][][] chars;
	double[][][] dubs;
	
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("breeding.in"));
		int zz = file.nextInt();file.nextLine();
		for(int z = 0;z<zz;z++)
		{
			String a = file.nextLine();
			String b = file.nextLine();
			String c = file.nextLine();
			String d = file.nextLine();
			String[] parA = a.split("-");
			String[] parB = b.split("-");
			String[] stats = d.split(",");
			boolean[] bools = new boolean[6];
			if(c.contains("HP"))
				bools[0] = true;
			if(c.contains("ATK"))
				bools[1] = true;
			if(c.contains("DEF"))
				bools[2] = true;
			if(c.contains("SPA"))
				bools[3] = true;
			if(c.contains("SPD"))
				bools[4] = true;
			if(c.contains("SPE"))
				bools[5] = true;
			String s = "";
			boolean q = false;
			for(int i = 0;i<6;i++)
			{
				if(bools[i])
				{
					if(stats[q?i-1:i].equals("1"))
						s+=(parA[i]+"-");
					else
						s+=(parB[i]+"-");
				}else
				{
					q = true;
					s+="?-";
				}
					
			}
			System.out.println(s.substring(0,s.length()-1));
			if(z!=zz-1)
			file.nextLine();
		}
	}
	public static void main(String[] args)throws Exception
	{
		//testGen(4,11);
		breeding a=new breeding();
		a.run();
	}
}