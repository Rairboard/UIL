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


public class Base
{
	public void run()throws Exception
	{
		Scanner file = new Scanner(new File("Base.dat"));
		int zz = file.nextInt();
		for(int z = 0;z<zz;z++)
		{
			int n = file.nextInt();
			System.out.println(n+" base 10");
			while(true)
			{
				int base = findMinBase(n);
				String s = Integer.parseInt(n+"",base)+"";
				if(s.equals(String.valueOf(n)))
				{
					System.out.println(s);
					System.out.println();
					break;
				}else{
					System.out.println(s+" base "+base);
					n = Integer.parseInt(s);
				}
			}
		}
	}
	
	public int findMinBase(int n)
	{
		int max = 0;
		while(n!=0)
		{
			max = Math.max(n%10,max);
			n/=10;
		}
		return max+1;
	}

	public static void main(String[] args)throws Exception
	{
		Base a=new Base();
		a.run();
	}

}