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


public class Nbonacci
{
	public void run()throws Exception
	{
		Scanner file = new Scanner(new File("Nbonacci.dat"));
		int zz = file.nextInt();
		for(int z = 0;z<zz;z++)
		{
			int n = file.nextInt();
			int m = file.nextInt();
			long[] dp = new long[m+1];
			for(int i = 0;i<n;i++)
				dp[i] = file.nextInt();
			for(int i = n;i<dp.length;i++)
				for(int j = 1;j<=n;j++)
					dp[i]+=dp[i-j];
			System.out.println(dp[m]);
		}
	}

	public static void main(String[] args)throws Exception
	{
		Nbonacci a=new Nbonacci();
		a.run();
	}

}