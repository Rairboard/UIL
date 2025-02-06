import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class combinations
{
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("combinations.dat"));
		int times =file.nextInt();file.nextLine();
		while(times-->0){
			//see infinite and finite first
			int nc=file.nextInt();

			int[]coins=new int[nc];
			for(int y=0;y<nc;y++)coins[y]=file.nextInt();

			int tar=file.nextInt();

			//stores how many ways to make each value
			//stores coin combinations in the indexes,
			//the indexes are the values, and the in-array
			//numbers store the number of ways to make a 
			//value given the denominations

			int[]dp=new int[tar+1];
			dp[0]=1;

			for(int c:coins) {

				//starts checking from the back as you only have a 
				//given number of coin denominations

				for(int i=tar;i>=0;i--)

					//checks to see if you have created a combo so that
					//if you added the current coin value you could create
					//the current combo value, adds the number of ways to make each combo

					if(i>=c)dp[i]+=dp[i-c];
			}

			//dp[tar] stores number of combinations equal to tar
			System.out.println(dp[tar]);
		}
	}

	public static void main(String[] args) throws Exception
	{
		new combinations().run();
	}	
	
}