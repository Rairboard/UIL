import java.io.*;
import java.util.*;
import java.math.*;

public class Louis {
	public static void main(String[] args) throws Exception {
		new Louis().run();
	}

	Scanner file;

	public void solve() {
		int n = Integer.parseInt(file.nextLine().trim());
		int[] l = new int[n + 1];
		l[1] = 1;
		for (int i = 2; i <= n; ++i)
			l[i] = 1 + l[i/2];
		System.out.println(l[n]);
	}

	public void run() throws Exception {
		file = new Scanner(new File("louis.dat"));
		int t = Integer.parseInt(file.nextLine().trim());
		for (int i = 1; i <= t; ++i)
			solve();
		file.close();
	}
}