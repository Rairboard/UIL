import java.io.*;
import java.util.*;
import java.math.*;

public class Ella {
	public static void main(String[] args) throws Exception {
		new Ella().run();
	}

	Scanner file;

	public void solve() {
		int n = Integer.parseInt(file.next().trim()), m = Integer.parseInt(file.nextLine().trim());
		int[] l = Arrays.stream(file.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray(),
			  f = Arrays.stream(file.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
		boolean[] v = new boolean[m];
		for (int i = 0; i < n; ++i) {
			if (i > 0)
				System.out.print(' ');
			int ret = m;
			for (int j = 0; j < m; ++j)
				if (f[j] <= l[i] && !v[j])
					v[j] = true;
				else
					--ret;
			System.out.print(ret);
		}
		System.out.println();
	}

	public void run() throws Exception {
		file = new Scanner(new File("ella.dat"));
		int t = Integer.parseInt(file.nextLine().trim());
		for (int i = 1; i <= t; ++i)
			solve();
		file.close();
	}
}