import java.util.*;
import java.io.*;

public class PrimeFactors {

	private static final int N = 1_000_000;
	private static int[] FACTOR = new int[N + 1];
	private static final int MOD = 10_000_009;

	static {
		FACTOR[0] = FACTOR[1] = 10_000_009;
		for (int p = 2; p <= N; p++) {
			if (FACTOR[p] != 0) {
				continue;
			}
			for (int c = p; c <= N; c += p) {
				if (FACTOR[c] != 0) {
					continue;
				}
				FACTOR[c] = p;
			}
		}
	}

	public static void main(String args[]) throws Exception {
		Scanner scan = new Scanner(new File("primefactors.dat"));
		int T = scan.nextInt();

		while (T-- > 0) {
			long sum = 0;
			int a = scan.nextInt();
			int b = scan.nextInt();
			for (int i = a; i <= b; i++) {
				long pf_sum = getPFSum(i) % MOD;
				sum += pf_sum;
				sum %= MOD;
			}
			System.out.println(sum);
		}
	}

	public static long getPFSum(int n) {
		long sum = 0;
		while (n != 1) {
			sum += FACTOR[n];
			n /= FACTOR[n];
		}
		return sum;
	}
}
