import java.io.*;
import java.util.*;
import static java.lang.System.out;

public class Mayank {

	public static void main(String[] args) throws FileNotFoundException {
		final String charvals = "0123456789 ABCDEFGHI JKLMNOPQR _STUVWXYZ";
		final int [] posweight = { 8, 7, 6, 5, 4, 3, 2, 10, 0, 9, 8, 7, 6, 5, 4, 3, 2 };
		Scanner s = new Scanner(new File("mayank.dat"));
		int T = s.nextInt();
		for (int t = 1; t <= T; t++) {
			String vin = s.next();
			int sum = 0;
			for (int v = 0; v < vin.length(); v++)
				sum += charvals.indexOf(vin.charAt(v)) % 10 * posweight[v];
			out.print("#" + t + ": ");
			if (sum % 11 == 10 && vin.charAt(8) == 'X' || sum % 11 == charvals.indexOf(vin.charAt(8)))
				out.println("VALID");
			else
				if (sum % 11 == 10) out.println("INVALID X");
				else out.println("INVALID " + sum % 11);
		}
	}
}
