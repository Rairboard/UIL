/*
 *UIL Computer Science 2020
 *Region Packet Solution
 */
import java.io.*;
import java.util.*;
import static java.lang.System.out;

public class Yana {

	public static void main(String[] args) throws FileNotFoundException {
		final String charset = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ abcdefghijklmnopqrstuvwxyz.";
		Scanner s = new Scanner(new File("yana.dat"));
		int N = s.nextInt();
		s.nextLine();
		for (int n = 1; n <= N; n++) {
			int[] factors = new int[8];
			Scanner ls = new Scanner(s.nextLine());
			ls.useDelimiter(",");
			for (int i = 0; i < 8; i++) factors[i] = ls.nextInt() % 8;
			int msgcount = ls.nextInt();
			for (int m = 1; m <= msgcount; m++) {
				String msg = s.nextLine();
				StringBuffer result = new StringBuffer("");
				for (int i = 0; i < msg.length(); i++) {
					int pos = charset.indexOf(msg.charAt(i));
					int row = pos % 8;
					int col = pos / 8;
					int adjust = (row - factors[col] < 0) ? 8 - factors[col] : -factors[col];
					result.append(charset.charAt(pos + adjust));
				}
				out.printf("[%d:%d]--\"%s\"\n", n, m, result);
			}
			out.println("==========");
		}
	}
}