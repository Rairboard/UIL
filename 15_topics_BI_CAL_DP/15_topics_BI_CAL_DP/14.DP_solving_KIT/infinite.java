import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class infinite
{
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("infinite.dat"));
		int times=file.nextInt();
		while(times-->0) {
			int nc=file.nextInt();
			//stores coin denominations
			int[]coins=new int[nc];
			for(int y=0;y<nc;y++)
				coins[y]=file.nextInt();
			//the target number
			int tar=file.nextInt();
			//stores whether or not a combo is possible
			//stores coin combinations in the indexes,
			//the indexes are the values, and the in-array
			//booleans store whether or not that combo
			//is possible given the denominations
			boolean[]dp=new boolean[tar+1];
			//0 is always possible
			dp[0]=true;
			for(int c:coins) {
				//starts checking from the back as you have an 
				//infinite number of coin denominations
				for(int i=0;i<=tar;i++)
					//checks to see if you have created a combo so that
					//if you added the current coin value you could create
					//the current combo value
					if(i>=c && dp[i-c])dp[i]=true;
			}
			//the array at position tar stores whether or not
			//it is possible to create value tar with the given denominations
			System.out.println(dp[tar]?"Yes":"No");
		}
	}

	public static void main(String[] args) throws Exception
	{
		new infinite().run();
	}	
	
}