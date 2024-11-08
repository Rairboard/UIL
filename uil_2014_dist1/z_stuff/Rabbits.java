import java.io.*;
import java.util.*;


// new formula is simple modification to old : f(n) = f(n-1) + f(n-3)
public class Rabbits {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("rabbits.dat"));
		int T = in.nextInt();
		while (T-- > 0) {
			int N = in.nextInt();
			if (N <= 2) {
				System.out.println(1);
				continue;
			}
			long prev3;
			long prev2 = 1;
			long prev1 = 1;
			long next = 1;
			// iterates from 3 to n and keeps track of f(i-3), f(i-2), and f(i-1),
			// so that f(i) can be computed in constant time.
			for (int i = 3; i <= N; i++) {
				prev3 = prev2;
				prev2 = prev1;
				prev1 = next;
				next = prev1 + prev3;
			}
			System.out.println(next);
		}
	}

	// this is the naive method, and not a good enough solution. This will call the function f more than f(n) times.
	// in other words, since f(115) = 7536815746437618530, a 19 digit number,
	// this would not finish in the time allotted for the contest, let alone the time limit for each problem.
	static long f(int n) {
		if (n <= 1) return 1;
		return f(n-1) + f(n-3);
	}
}
/*
Test data:
10
1
2
3
5
14
6
8
30
15
115

Output:
1
1
2
4
129
6
13
58425
189
7536815746437618530

*/
