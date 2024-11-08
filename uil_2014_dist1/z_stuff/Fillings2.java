//Fillings - alternate solution using permutations formula
//nPk = n!/(n-k)!

import java.io.*;
import java.util.*;

public class Fillings2 {

	//recursive method to calculate factorial
	public static int fact(int n)
	{
		if(n<=1)
			return 1;
		return n*fact(n-1);
	}
	public static void main(String[] args) throws FileNotFoundException {
		// read in number of test cases
		Scanner sc = new Scanner(new File("fillings.dat"));
		int t = sc.nextInt();
		while(t-- > 0){
			int n = sc.nextInt();
			int m = sc.nextInt();
			System.out.println(calculate(n, m));
		}
	}
	private static int calculate(int n, int m) {
                return fact(m)/fact(m-n);
	}
}

/*
Test data
10
2 3
2 10
4 9
5 7
3 6
3 9
5 8
3 4
10 10
1 2

Output:
6
90
3024
2520
120
504
6720
24
3628800
2
*/
