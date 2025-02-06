/*
 * UIL Computer Science 2025
 * Invitational A Packet Solution
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Danielle {
	public static void main(String[] args) throws IOException {
		new Danielle().run();
	}

	private void run() throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("danielle.dat"));
		PrintWriter out = new PrintWriter(System.out);

		solve(file, out);

		file.close();
		out.close();
	}

	public void solve(BufferedReader file, PrintWriter out) throws IOException {
		int n = Integer.parseInt(file.readLine());
		while (n-- > 0) {
			int[] parts = Arrays.asList(file.readLine().split(",")).stream().map(str -> Integer.parseInt(str))
					.mapToInt(Integer::intValue).toArray();
			int d1 = parts[0] - 1;
			int d2 = parts[1] - 2;
			int d3 = parts[2] - 3;
			int d4 = parts[3] - 4;

			int total = 1 + d1 + (d2 * 9) + (d3 * 72) + (d4 * 504);
			out.println(total);
		}
	}
}
