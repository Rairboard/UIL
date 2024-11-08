//M and Ms - Solution
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Calculate the number of steps required to reduce a number N to 0, given that
 * at each step, you can either subtract 1, or subtract M such that N-M is a
 * non-trivial factor of N.
 */
public class MandMs {
	public static void main (String[] args) throws FileNotFoundException {
		Scanner infile = new Scanner (new File ("mandms.dat"));
		int tests = infile.nextInt();
		for (int i = 0; i < tests; i++) {
			System.out.println(calcAnswer(infile));
		}
	}
	
	public static int calcAnswer (Scanner in) {
		int n = in.nextInt();
		if (n == 1) return 1;
		if (n == 2) return 2;
		if (n == 3) return 3;
		if (n%2 ==0) return 3;
		else return 4;		
	}
}
/*
Test data:
10
1
2
3
5
100
6
7
8
9
101

Output:
1
2
3
4
3
4
3
4
3
4

*/