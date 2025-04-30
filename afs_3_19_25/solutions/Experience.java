import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;

public class Experience {
	public static void main(String[] args) throws IOException {
		new Experience().run();
	}
	
	private final int[] xp = {1, 3, 7, 17, 37, 73, 149, 307, 617, 1237, 2477};
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("Experience/experience.dat"));
		PrintWriter out = new PrintWriter(new File("Experience/experience.out"));
		
		int n = Integer.parseInt(file.readLine());
		int[] queries = new int[n];
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			queries[i] = Integer.parseInt(file.readLine());
			max = Math.max(max, queries[i]);
		}
		file.close();
		
		long start = System.currentTimeMillis();
		optimalSolution(max);
		long end = System.currentTimeMillis();
		long t1 = end-start;
		start = System.currentTimeMillis();
		for(int i = 0; i < n; i++) {
			int[] ans = backtracking(queries[i]);
			out.println(Arrays.toString(ans).replaceAll("[\\[\\],]", ""));
		}
		end = System.currentTimeMillis();
		long t2 = end-start;
		System.out.println(t1);
		System.out.println(t2);
		out.close();
	}
	
	private int[][] dp;
	
	private void optimalSolution(int upperBound) {
		dp = new int[upperBound + 1][2];
		for(int i = 0; i <= upperBound; i++) {
			dp[i] = new int[]{Integer.MAX_VALUE, -1};
		}
		dp[0][0] = 0;
		for(int i = 0; i < xp.length; i++) {
			for(int j = 0; j <= upperBound; j++) {
				int curr = j + xp[i];
				if(curr <= upperBound) {
					if(dp[curr][0] >= dp[j][0] + 1) {
						dp[curr][0] = dp[j][0] + 1;
						dp[curr][1] = xp[i];
					}
				} else {
					break;
				}
			}
		}
	}
	
	@SuppressWarnings("serial")
	private final HashMap<Integer, Integer> coinToIndex = new HashMap<Integer, Integer>(){{
		put(1, 0); put(3, 1); put(7, 2); put(17, 3); put(37, 4); put(73, 5); 
		put(149, 6); put(307, 7); put(617, 8); put(1237, 9); put(2477, 10);
	}};
	
	private int[] backtracking(int amount) {
		int[] amounts = new int[xp.length];
		while(amount != 0) {
			int coin = dp[amount][1];
			amounts[coinToIndex.get(coin)]++;
			amount -= coin;
		}
		return amounts;
	}
}
