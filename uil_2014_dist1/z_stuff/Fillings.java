//Fillings - solution
//Fillings - solution
import java.io.*;
import java.util.*;

public class Fillings {

	public static void main(String[] args) throws FileNotFoundException {
		// read in number of test cases
		Scanner sc = new Scanner(new File("fillings.dat"));

		int t = sc.nextInt();

		while(t-- > 0){
			// read in two values then run through simulation
			int n = sc.nextInt();
			int m = sc.nextInt();
			System.out.println(calculate(n, m));
		}
	}
	private static int calculate(int n, int m) {
                int ans = 1;
                if(m < n)return 0;
                for(int i=0,j=m;i<n;i++,j--)
                        ans = ans * j;
                return ans;
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
