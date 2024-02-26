import java.io.*;
import java.util.*;
import java.math.*;

public class Cindy {
	public static void main(String[] args) throws Exception {
		new Cindy().run();
	}

	Scanner file;

	public void solve() {
		int n = Integer.parseInt(file.next().trim()), m = Integer.parseInt(file.nextLine().trim());
		int[] a = Arrays.stream(file.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(a);
		for (int x : a)
			if (m >= x)
				m -= x;
			else
				--n;
		System.out.println(n);
	}

	public void run() throws Exception {
		file = new Scanner(new File("cindy.dat"));
		int t = Integer.parseInt(file.nextLine().trim());
		for (int i = 1; i <= t; ++i)
			solve();
		file.close();
	}
}