//DNA - alternate solution
import java.io.*;
import java.util.*;
import static java.lang.System.*;
// This solution ensures every location is one of the four valid pairs.
// If all locations are valid, the pair is good, otherwise it is bad.
public class DNA2 
{
	public static void main(String[] args) throws IOException {
		Scanner f = new Scanner(new File("dna.dat"));
		int numcases = f.nextInt();
		f.nextLine();
		while (numcases--> 0) 
		{
			String a = f.nextLine().trim();
			String b = f.nextLine().trim();
			boolean good = true;
			int N = a.length();
			for (int i = 0; i < N; i++) {
				
				char ai = a.charAt(i);
				char bi = b.charAt(i);
				// if ith position has non-matching pair of letters, string is bad, break
				if(ai=='A'&&bi=='T'||bi=='A'&&ai=='T'||ai=='G'&&bi=='C'||bi=='G'&&ai=='C')
				{
					continue;
				}
				else
				{
					good = false;
					break;
				}
			}
			out.println(good ? "GOOD" : "BAD");
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
