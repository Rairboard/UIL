import java.io.*;
import java.util.*;

public class LCS 
{
	public static void main(String[] args) throws Exception
	{
		new LCS().run();
	}
	void run() throws Exception
	{
		String a = "ABCQDEN";
		String b = "ACOON";
		//LCS is the longest common subsequence of two strings. This is a string that is located 
		//in both strings in the same order
		//for example, the string "ABCQDEN" and "ACOON" the longest common string is "ACN" because both strings 
		//contain those letters in that order
		String[][] dp = new String[a.length()+1][b.length()+1];
		//the dp array is defined as
		//the value dp[i][j] = the longest subsequence from index 0 to i in string a and 0 to j in string b
		//make sure to fill the dp array with blanks strings, not null
		for(int i=0;i<dp.length;i++) for(int j=0;j<dp[i].length;j++) dp[i][j] = "";
		for(int i=1;i<dp.length;i++) //start i and j at 1 because the substring from 0 to 0 is nothing
		{
			for(int j=1;j<dp[i].length;j++)
			{
				//if the string at location i-1 is equal to the string at location j-1 then the LCS is equal to the
				//lcs at dp[i-1][j-1] + the common character between the two strings
				if(a.charAt(i-1) == b.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + a.charAt(i-1);
				else
				{
					//if the string isn't the same just pick the longest string you can
					String s1 = dp[i-1][j];
					String s2 = dp[i][j-1];
					String s3 = dp[i-1][j-1];
					if(s1.length() > s2.length() && s1.length() > s3.length()) dp[i][j] = s1;
					else if(s2.length() > s1.length() && s2.length() > s3.length()) dp[i][j] = s2;
					else dp[i][j] = s3;
				}
			}
		}
		//all this just prints out the dp array in a pretty way
		//the left column is String a
		//top row is String b
		//interior is dp[][]
		//formatting garbage
		int len = dp[a.length()][b.length()].length()+1;
		System.out.print("       ");
		for(int i=0;i<b.length();i++)
		{
			System.out.print("   " + b.charAt(i) + " ");
		}
		System.out.println();
		for(int i=0;i<dp.length;i++)
		{
			//formatting garbage
			if(i > 0) System.out.print(a.charAt(i-1)+ " " );
			else System.out.print("  ");
			for(int j=0;j<dp[i].length;j++)
			{
				
				if(dp[i][j] == "") dp[i][j] = "_";
				System.out.printf("%"+len + "s ",dp[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println(dp[a.length()][b.length()]);
	}
	
}
//by tristan
//ask me if this doesnt make sense