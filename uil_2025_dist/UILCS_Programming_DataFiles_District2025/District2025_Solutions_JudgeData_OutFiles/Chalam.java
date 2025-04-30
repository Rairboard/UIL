/*
 * UIL Computer Science 2025
 * District Packet Solution
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Chalam {
	public static void main(String[] args) throws IOException {
		new Chalam().run();
	}

	private void run() throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("chalam.dat"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		solve(file, out);

		file.close();
		out.close();
	}

	public void solve(BufferedReader file, PrintWriter out) throws IOException {
		int n = Integer.parseInt(file.readLine());
		StringBuilder sb = new StringBuilder();
		while(n-->0) {
			primeFactorize(sb, Integer.parseInt(file.readLine()));
			sb.append('\n');
		}
		out.print(sb);
	}
	
	private void primeFactorize(StringBuilder sb, int n) {
		int occ = 0;
		while(n % 2 == 0) {
			occ++;
			n >>= 1;
		}
		if(occ > 0) {
			sb.append('2');
			if(occ > 1) {
				sb.append('^');
				sb.append(Integer.toString(occ));
			}
			sb.append(' ');
			occ = 0;
		}
		
		int sqrtQi = (int) Math.sqrt(n);
		for(int i = 3; i <= sqrtQi; i += 2) {
			while(n % i == 0) {
				occ++;
				n /= i;
			}
			if(occ > 0) {
				sb.append(Integer.toString(i));
				if(occ > 1) {
					sb.append('^');
					sb.append(Integer.toString(occ));
				}
				sb.append(' ');
				occ = 0;
			}
		}
		
		if(n > 1) {
			sb.append(Integer.toString(n));
		} else {
			sb.deleteCharAt(sb.length()-1);
		}
	}
}
