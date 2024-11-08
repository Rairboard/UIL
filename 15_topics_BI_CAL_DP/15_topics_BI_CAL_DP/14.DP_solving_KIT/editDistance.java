import java.io.*;
import java.util.*;

public class editDistance 
{
	int[][] dp;
	public static void main(String[] args) throws Exception
	{
		new editDistance().run();
	}
	void run() throws Exception
	{
		//edit distance is how many operations are needed to transform one string into another
		//the operations allowed are removing a letter, adding a letter, or replacing a letter
		//there is a stupid way and a dp way to do this problem
		//with many dp problems it can be useful to start with the stupid version and change it to a dp version
		//first lets just try all the possible combinations of operations and see how it works
		String a = "abcaa";
		String b = "abeaaq";
		System.out.println("Answer = " +  bruteForce(a,b,a.length(),b.length()));
		//problem is this code doesnt work well for longer strings
		String a1 = "aaaaaaaaaaaaaoaaa";
		String b1 = "daawdawdawdkbnawu";
		long t = System.currentTimeMillis();
		System.out.println("Answer = " + bruteForce(a1,b1,a1.length(),b1.length()));
		System.out.println("Runtime = " + (System.currentTimeMillis()-t) + " Milliseconds");
		//make sure to understand how the brute force solution works before going on to the dp one
		
		//we can solve this problem with memoization
		//our method bruteForce has two useful properties
		//1: brute force always returns the same outputs for the same inputs
		//2: brute force repeats a lot of method calls
		//so, we can memoize this method by storing method calls and returning the data when requested instead of 
		//recalculating it
		//the value in the matrix dp at i,j will be equal to the value returned by the method recur(a,b,i,j)
		t = System.currentTimeMillis();
		dp = new int[a1.length()+1][b1.length()+1];
		for(int i=0;i<dp.length;i++) for(int j=0;j<dp[i].length;j++) dp[i][j] = -1;
		System.out.println("Answer = " + dp(a1,b1,a1.length(),b1.length()));
		System.out.println("Runtime = " + (System.currentTimeMillis()-t) + " Milliseconds");
		
	}
	//n-1 is the current character in string a, m-1 is the character in string b
	//the method is done when n and m are zero
	//we use n and m instead of actually changing the string because string operations are slow
	int bruteForce(String a,String b,int n,int m)
	{
		if(n == 0)
		{
			return m;
			//if n is zero there is m more operations to go
		}
		if(m == 0)
		{
			//if m is zero there is n more operations to go
			return n;
		}
		if(a.charAt(n-1) == b.charAt(m-1))
		{
			//if the chars are the same we dont have to do anything, just skip
			return bruteForce(a,b,n-1,m-1);
		}
		else
		{
			//try all 3 operations, add 1 to the number of operations
			return Math.min(bruteForce(a,b,n-1,m),Math.min(bruteForce(a,b,n,m-1), bruteForce(a,b,n-1,m-1))) + 1;
		}
	}
	//just the exact same thing but with the dp matrix storing results
	//-1 means that answer has not been computed yet
	int dp(String a,String b,int n,int m)
	{
		if(dp[n][m] != -1) return dp[n][m];
		if(n == 0)
		{
			dp[n][m] = m;
			return m;
		}
		if(m == 0)
		{
			dp[n][m] = n;
			return n;
		}
		if(a.charAt(n-1) == b.charAt(m-1))
		{
			dp[n][m] = dp(a,b,n-1,m-1);
			return dp[n][m];
		}
		else
		{
			dp[n][m] = Math.min(dp(a,b,n-1,m),Math.min(dp(a,b,n,m-1), dp(a,b,n-1,m-1))) + 1;
			return dp[n][m];
		}
	}
}
//by tristan
//ask me if this doesnt make sense