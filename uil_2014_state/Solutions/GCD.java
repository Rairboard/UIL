import java.io.*;
import java.util.*;

public class GCD {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("gcd.dat"));
		int T = in.nextInt();
		while (T-- > 0) {
			int N = in.nextInt();
			int[] vals = new int[N];
			for (int i = 0; i < N; i++) {
				vals[i] = in.nextInt();
			}
			System.out.println(gcd(vals));
		}
	}
	
	// most efficient way, using euclid's theorem
	public static int euclid(int a, int b) {
		if (b == 0) return a;
		return euclid(b, a % b);
	}
	public static int gcd(int[] vals) {
		int ret = vals[0];
		for (int i = 1; i < vals.length; i++) {
			ret = euclid(ret, vals[i]);
		}
		return ret;
	}
	
	// this problem is technically brute forceable, since you can just iterate through all possible divisors and check,
	// meaning you do not need to know euclid's to do this problem
	public static int gcd2(int[] nums) {
		int min  = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < min) {
				min = nums[i];
			}
		}
		int ret = 1;
		for (int i = 2; i <= min; i++){
			boolean dividesAll = true;
			for (int j = 0; j < nums.length; j++) {
				if (nums[j] % i != 0) {
					dividesAll = false;
					break;
				}
			}
			if (dividesAll) {
				ret = i;
			}
		}
		return ret;
	}
}
