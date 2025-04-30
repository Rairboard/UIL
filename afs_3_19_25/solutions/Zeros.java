import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Zeros {
	public static void main(String[] args) throws IOException {
		new Zeros().run();
	}

	public final int MAX_W = 100_000;
	public final int MOD = 1_000_000_007;
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("Zeros/zeros.dat"));
		PrintWriter out = new PrintWriter(new File("Zeros/zeros.out"));
		
		int[] dp = new int[MAX_W+1];
		dp[0] = 1;
		dp[1] = 2;
		for (int i = 2; i <= MAX_W; i++) {
			dp[i] = (dp[i-2] + dp[i-1]) % MOD;
		}
		
		int n = Integer.parseInt(file.readLine());
		while (n-->0) {
			out.println(dp[Integer.parseInt(file.readLine())]);
		}
		
		file.close();
		out.close();
	}
}
