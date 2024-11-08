import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Exponentiation {
	public static final int REAL = 0;
	public static final int IM = 1;

	public static void main (String[] args) throws FileNotFoundException {
	
		Scanner in = new Scanner (new File ("exponentiation.dat"));
		int noTests = in.nextInt();
		for (int i = 0; i < noTests; i++) {
			double real = in.nextDouble();
			double im = in.nextDouble();
			double [] num = {real, im};
			int exp = in.nextInt();
			double [] exponent = exponentiate(num, exp);
			System.out.println("(" + exponent[REAL] + "," + exponent[IM] + ")");
		}
		in.close();
	}
	
	public static double [] multiply (double [] a, double b[]) {
		double real = a[REAL]*b[REAL] - a[IM]*b[IM];
		double im = a[REAL]*b[IM] + a[IM]*b[REAL];
		double [] product = {real, im};
		return product;
	}
	
	public static double [] exponentiate (double a [], int n) {
		double [] unity = {1.0, 0.0};
		if (n==0) return unity;
		else return multiply(a, exponentiate(a, n-1));
	}
}
/*
Test data:
10
5.0 1.0 2
4.5 -7.5 3
-1.0 10 5
2.0 3.0 1
2.0 3.5 2
2.5 4.5 3
0.0 2.0 1
0.1 2.0 3
0.25 2.0 4
3.0 2.0 4

Output:
(24.0,10.0)
(-668.25,-33.75)
(-49001.0,90050.0)
(2.0,3.0)
(-8.25,14.0)
(-136.25,-6.75)
(0.0,2.0)
(-1.199,-7.94)
(14.50390625,-7.875)
(-119.0,120.0)

*/

