import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class finiteknapsack
{

	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("knapsack.dat"));

		int times = file.nextInt();
		file.nextLine();

		for (int asdf = 0; asdf < times; asdf++)
		{
			String[] sa1 = file.nextLine().split(" ");
			String[] sa2 = file.nextLine().split(" ");
			int most = file.nextInt();
			file.nextLine();
			int[] weights = new int[sa1.length]; //stores the weights of each value
			int[] values = new int[sa2.length]; // stores the coin value

			for(int i = 0; i < sa1.length; i++) weights[i] = Integer.parseInt(sa1[i]);
			for(int i = 0; i < sa2.length; i++) values[i] = Integer.parseInt(sa2[i]);

			int[][] dp = new int[weights.length+1][most+1];
			//each row in the knapsack represents the value in the position r-1 in the value array and each column represents the weight you are attempting to find the maximum for

			//we start the loops at (1,1) because you cannot have any value if the weight allowed is 0 or if the coin/value you are using is 0
			for(int r = 1; r < dp.length; r++)
			{
				for(int c = 1; c < dp[r].length; c++)
				{
					//each position in the matrix is the maximum amount with the coins previously used and the weight in that given column
					if(weights[r-1] <= c) //If weight of the rth item is less than the allowed weight in that column, then this item can be included
						dp[r][c] = Math.max(dp[r-1][c], dp[r-1][c-weights[r-1]]+values[r-1]);
									//The options that you have to choose from would be dp[r-1][c]:
									//You would pick dp[r-1][c] if it is already the maximum value that can be made (you don't include the item)
									//otherwise you would include the rth item (because it is greater and you want to find the maximum)
									// THE ONLY DIFFERENCE BETWEEN INFINITE AND FINITE IS THE (r-1) in dp[r-1][c-weights[r-1]]+coins[r-1]
									//We do this r-1 so that after it picks/uses the previous value, it automatically goes to the row above so that it avoids using that value again
				}
			}
			for(int i = 0; i < dp.length; i++) System.out.println(Arrays.toString(dp[i]));
			//to better understand it write out the matrix it creates and remember that: 
			//this solution is trying to find the MAXIMUM amount that can be made under the weight limit
		}
	}

	public static void main(String[] args) throws Exception
	{

		new finiteknapsack().run();

	}

}
