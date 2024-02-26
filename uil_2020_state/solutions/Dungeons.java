import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
public class Dungeons {
	public static void main(String[]args)throws Exception{
		new Dungeons().run();
	}
	public void run()throws Exception{
		Scanner file=new Scanner(new File("dungeons.dat"));
		int times=file.nextInt();
		file.nextLine();
		while(times-->0) {
			int n = file.nextInt(), mw = file.nextInt(), na = file.nextInt(), ac = file.nextInt();
			int[] weights = new int[n];
			int[] vals = new int[n];
			for(int y = 0; y < n; y++) {
				file.next();
				String t = file.next();
				vals[y] = file.nextInt();
				weights[y] = file.nextInt();
				if(t.equals("weapon"))
					vals[y] *= na * 2;
				else if(t.equals("armor"))
					vals[y] *= (22 - ac);
			}
			System.out.println(solve(mw, weights, vals, n));
		}
	}
	   
    int knapsack(int W, int wt[], int val[], int n, int[][] dp) { 
        if (n == 0 || W == 0) 
            return 0; 
        if (dp[n][W] != -1) 
            return dp[n][W]; 
        if (wt[n - 1] > W)  
            return dp[n][W] = knapsack(W, wt, val, n - 1, dp); 
        else 
            return dp[n][W] = Math.max((val[n - 1] 
                       + knapsack(W - wt[n - 1], wt, val, n - 1, dp)), 
                      knapsack(W, wt, val, n - 1, dp)); 
    } 
  
    public int solve(int W, int wt[], int val[], int N) 
    { 
        int dp[][] = new int[N + 1][W + 1]; 
        for (int i = 0; i < N + 1; i++) 
            Arrays.fill(dp[i], -1);
        return knapsack(W, wt, val, N, dp); 
    } 
}
