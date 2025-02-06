/*
 * UIL Computer Science 2025
 * Invitational A Packet Solution
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Martyn {
	public static void main(String[] args) throws IOException {
		new Martyn().run();
	}

	private void run() throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("martyn.dat"));
		PrintWriter out = new PrintWriter(System.out);

		solve(file, out);

		file.close();
		out.close();
	}

	public void solve(BufferedReader file, PrintWriter out) throws IOException {
		int n = Integer.parseInt(file.readLine());
		ArrayList<Integer> palindromicBases = new ArrayList<Integer>();
		while(n-->0) {
			palindromicBases.clear();

			int num = Integer.parseInt(file.readLine());
			for(int b = 2; b <= 64; b++) {
				// Use solution 1
				if(isPalindromic1(num, b)) {
					palindromicBases.add(b);
				}
			}

			if(palindromicBases.isEmpty()) {
				out.println("None.");
			} else {
				out.println(palindromicBases.toString().replaceAll("[\\[\\]]", ""));
			}
		}
	}

	// Solution 1: Prevents O(N) string comparison cost
	private boolean isPalindromic1(int n, int b) {
		int rev = 0;
		int remaining = n;
		while(remaining > 0) {
			rev = rev * b + remaining % b;
			remaining /= b;
		}
		return n == rev;
	}

	private static final char[] DIGITS = 
			"0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/".toCharArray();

	// Solution 2: Traditional solution with string comparison (~4x slower)
	private boolean isPalindromic2(int n, int b) {
		String forward = toString(n, b);
		StringBuilder reverse = new StringBuilder(forward).reverse();
		return forward.equals(reverse.toString());
	}

	private String toString(int n, int b) {
		StringBuilder res = new StringBuilder();

		while(n > 0) {
			res.append(DIGITS[n % b]);
			n /= b; 
		}

		return res.reverse().toString();
	}
}
