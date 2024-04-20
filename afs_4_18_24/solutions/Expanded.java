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


public class Expanded
{
	public void run()throws Exception
	{
		Scanner file = new Scanner(new File("Expanded.dat"));
		int zz = file.nextInt();
		for(int z = 0;z<zz;z++)
		{
			int n = file.nextInt();
			int len = (n+"").length();
			for(int i = 1;i<=len;i++)
			{
				if((n+"").charAt(i-1)-48!=0){
					System.out.printf("%"+i+"d",(n+"").charAt(i-1)-48);
					for(int j = i;j<len;j++)
						System.out.print(0);
					System.out.println();
				}		
			}
			System.out.print("+");
			for(int i = 0;i<len-1;i++)
				System.out.print("-");
			System.out.println();
			System.out.println(n);
			System.out.println();
		}
	}

	public static void main(String[] args)throws Exception
	{
		Expanded a=new Expanded();
		a.run();
	}

}