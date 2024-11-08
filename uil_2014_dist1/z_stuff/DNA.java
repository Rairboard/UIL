//DNA - Solution
import java.io.*;
import java.util.*;

// This solution ensures every location is one of the four valid pairs.
// If all locations are valid, the pair is good, otherwise it is bad.
public class DNA {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("dna.dat"));
		int numcases = Integer.parseInt(in.nextLine().trim());
		while (numcases-- > 0) {
			String a = in.nextLine().trim();
			String b = in.nextLine().trim();
			boolean good = true;
			for (int i = 0; i < a.length(); i++) {
				char ai = a.charAt(i);
				char bi = b.charAt(i);
				// if ith position is not matching pair of correct letters, string is bad
				if (!(ai == 'A' && bi == 'T' || ai == 'T' && bi == 'A' ||
						ai == 'G' && bi == 'C' || ai == 'C' && bi == 'G')) {
					good = false;
					break;
				}
			}
			System.out.println(good ? "GOOD" : "BAD");
		}
	}
}
/*
Test data:
7
ATGC
TACG
ATGC
CGTA
AGQ
TCF
CGATAGAT
CCTATCTA
CTTGCTTCGGAAGTCCCGGTGGACC
GAACGAAGCCTTCAGGGCCACCTGG
GGTCGTATCGCT
CCAGCATAGCGG
GTATTAAGGATCCAATTGGTTTCCAATGTATTGAAGCGTCCTCCGGCCATACTCAAGGACGCTGTTAAG
CATAATTCCTAGGTTAACCAAAGGTTACATAACTTCGCAGGAGGCCGGTATGAGTTCCTGCGACAATTC

Output:
GOOD
BAD
BAD
BAD
GOOD
BAD
GOOD

*/
