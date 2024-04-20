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


public class Threes
{
	public void run()throws Exception
	{
		Scanner file = new Scanner(new File("threes.dat"));
		int zz = file.nextInt();
		for(int z = 0;z<zz;z++)
		{
			long a = file.nextLong();
			long b = file.nextLong();
			double total = b-a+1;
			System.out.printf("%.3f%%%n",(threesFromZero(b)-threesFromZero(a-1))/total*100);
		}
	}
	
	public long threesFromZero(long n)
	{
		if(n<=0)
			return 0;
		int len = (int)(Math.log10(n)+1);
		long[][] dp = new long[len][10];
		for(int i = 0;i<dp.length;i++)
		{
			dp[i][1] = (long)(Math.pow(10,i)-Math.pow(9,i));
			for(int j = 2;j<10;j++)
			{
				dp[i][j] = dp[i][j-1]+(long)(Math.pow(10,i)-Math.pow(9,i));
				if(j==3)
					dp[i][j]++;
				if(j==4)
					dp[i][j]=dp[i][j-1]+(long)Math.pow(10,i)-1;
			}
		}
		long sum = 0;
		while(n!=0)
		{
			int left = (int)(n/Math.pow(10,len-1));
			sum+=dp[len-1][left];
			n%=left*Math.pow(10,len-1);
			len = (int)(Math.log10(n)+1);
			if(left==3)
				return sum+n;
		}
		return sum;
	}

	public static void main(String[] args)throws Exception
	{
		Threes a=new Threes();
		a.run();
	}

}