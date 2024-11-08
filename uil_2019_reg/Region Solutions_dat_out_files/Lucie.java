//Solution - UIL Region 2019
import static java.lang.System.*;
import java.io.*;
import java.util.*;

public class Lucie {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner data = new Scanner(new File("lucie.dat"));
		int S = data.nextInt();
		data.useDelimiter("[\\r\\n,]+");
		for (int s = 1; s <= S; s++) {
			int P = data.nextInt();
			int T = data.nextInt();
			int [][] scores = new int[T+1][P+1];
			int t, p;
			for (t = 0; t < T; t++)
				scores[t][P] = 0;
			for (p = 0; p < P; p++) {
				scores[T][p] = 0;
				for (t = 0; t < T; t++) {
					scores[t][p] = data.nextInt();
					scores[T][p] += scores[t][p];
					scores[t][P] += scores[t][p];
				}
			}
			for (t = 0; t < T; t++) {
				for (p = 0; p < P; p++) 
					out.print(scores[t][p] + ",");
				out.println(scores[t][P]);
			}
			for (p = 0; p < P-1; p++)
				out.print(scores[t][p] + ",");
			out.println(scores[t][P-1]);
			out.println("************");
		}
		data.close();
	}

}
