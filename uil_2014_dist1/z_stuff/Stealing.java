//Stealing Gold - Solution
import java.io.*;
import java.util.*;

public class Stealing{

	public static void main(String[] args) throws FileNotFoundException {
		// read in number of test cases
		Scanner sc = new Scanner(new File("stealing.dat"));
		int t = sc.nextInt();
		while(t-- > 0){
			// read in two values then run through simulation
			int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
			System.out.println(calculate(n, m, k));
		}
	}
	private static int calculate(int n, int m,int k) {

                    int rem  = n%m;
                    if(rem > 0)return (n/m)*2*k + k;
                    else return (n/m)*2*k - k;
	}
}
/*
Test data:
10
3 2 10
35 68 42
25 70 1
63 59 79
46 6 65
62 28 82
43 96 92
92 37 28
54 3 5
22 83 93

Output:
30
42
1
237
975
410
92
140
175
93

*/
