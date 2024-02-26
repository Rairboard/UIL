import java.util.*;
import java.io.*;

public class Potato {

	public static long MOD = 100003;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("potato.dat"));
		int t = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int i = 1; i <= t; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			long ways = solve(n, k);
			System.out.println(ways);
		}

		br.close();
	}

	public static long solve(int n, int k) {
		long[] ways = new long[2];
		ways[0] = 1;
		for (int i = 0; i < k; i++) {
			long w0 = ways[0], w1 = ways[1];
			//ways[0] = (n * ways[1]) % MOD;
			ways[0] = 0;
			for (int j = 0; j < n; j++) {
				ways[0] += w1;
				ways[0] %= MOD;
			}

			//ways[1] = (temp + (n - 1) * ways[1]) % MOD;
			ways[1] = w0;
			for (int j = 0; j < n - 1; j++) {
				ways[1] += w1;
				ways[1] %= MOD;
			}
		}
		return ways[0];
	}
}
