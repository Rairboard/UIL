import java.io.*;
import java.util.*;

// This solution ensures every location is one of the four valid pairs.
// If all locations are valid, the pair is good, otherwise it is bad.
public class RNA {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("rna.dat"));
		int numcases = Integer.parseInt(in.nextLine().trim());
		while (numcases-- > 0) {
			int N = Integer.parseInt(in.nextLine().trim());
			String dna = in.nextLine().trim();
			String rna = in.nextLine().trim();
			boolean good = true;
			for (int i = 0; i < N; i++) {
				char di = dna.charAt(i);
				char ri = rna.charAt(i);
				// if ith position is not matching pair of correct bases, string is bad
				if (!(di == 'A' && ri == 'U' || di == 'T' && ri == 'A' ||
						di == 'G' && ri == 'C' || di == 'C' && ri == 'G')) {
					good = false;
					break;
				}
			}
			System.out.println(good ? "GOOD" : "BAD");
		}
	}
}
