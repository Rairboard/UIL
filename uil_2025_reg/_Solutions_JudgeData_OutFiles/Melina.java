import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Melina {
	
	public void run() throws Exception{
		Scanner file = new Scanner(new File("melina.dat"));
		int times = file.nextInt();
		file.nextLine();
		while(times-- > 0) {
			double amt = file.nextDouble() , total = file.nextDouble() ;
			file.nextLine();
			String[] st = file.nextLine().trim().split(" ");
			int[] in = new int[st.length];
			for(int y = 0; y < in.length; y++)
				in[y] = (int)(Double.parseDouble(st[y]) * 100);
			int sum = (int)(100 * (amt - total));
			System.out.println(solve(in, sum));
		}
	}
	
	public static void main(String[]args)throws Exception{
		new Melina().run();
	}
	
	long solve(int[] coins, int sum) {
        long[] dp = new long[sum + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++)
            for (int j = coins[i]; j <= sum; j++)
                dp[j] += dp[j - coins[i]];
        return dp[sum];
    }
}
