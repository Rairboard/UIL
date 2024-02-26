import java.io.*;
import java.util.*;
import java.math.*;

public class Hellen {
	public static void main(String[] args) throws Exception {
		new Hellen().run();
	}

	Scanner file;

	public void solve() {
		int n = Integer.parseInt(file.next().trim()), m = Integer.parseInt(file.nextLine().trim());
		int[] f = Arrays.stream(file.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
		boolean[] b = new boolean[n + 1];
		for (int x : f)
			for (int y = x; y <= n; y += x)
				b[y] ^= true;
		int ans = 0;
		for (int i = 1; i <= n; ++i)
			if (!b[i])
				++ans;
		System.out.println(ans);
	}

	public void run() throws Exception {
		file = new Scanner(new File("hellen.dat"));
		int t = Integer.parseInt(file.nextLine().trim());
		for (int i = 1; i <= t; ++i)
			solve();
		file.close();
	}
}