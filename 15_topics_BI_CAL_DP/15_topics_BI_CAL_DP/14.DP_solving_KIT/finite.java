import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class finite
{
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("finite.dat"));
		int times=file.nextInt();
		while(times-->0) {
			//check infinite before this one
			int nc=file.nextInt();
			int[]coins=new int[nc];
			for(int y=0;y<nc;y++)
				coins[y]=file.nextInt();
			int tar=file.nextInt();
			//stores whether or not a combo is possible
			//stores coin combinations in the indexes,
			//the indexes are the values, and the in-array
			//booleans store whether or not that combo
			//is possible given the denominations
			boolean[]dp=new boolean[tar+1];
			dp[0]=true;
			for(int c:coins) {
				//starts checking from the back as you only have a 
				//given number of coin denominations
				for(int i=tar;i>=0;i--)
					//checks to see if you have created a combo so that
					//if you added the current coin value you could create
					//the current combo value
					if(i>=c && dp[i-c])dp[i]=true;
			}
			System.out.println(dp[tar]?"Yes":"No");
		}
	}

	public static void main(String[] args) throws Exception
	{
		new finite().run();
	}	
	
}