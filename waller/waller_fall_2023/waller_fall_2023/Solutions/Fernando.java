import java.io.*;
import java.util.*;
import java.math.*;

public class Fernando {
	public static void main(String[] args) throws Exception {
		new Fernando().run();
	}

	Scanner file;

	public void solve() {
		int lll = 0, ll = 0, l = 0, n = Integer.parseInt(file.next().trim());
		for (int i = 0; i < n; ++i) {
			if (i > 0)
				System.out.print(' ');
			lll = ll; ll = l; l = Integer.parseInt(file.next().trim());
			System.out.print(lll + ll + l);
		}
		System.out.println();
	}

	public void run() throws Exception {
		file = new Scanner(new File("fernando.dat"));
		int t = Integer.parseInt(file.nextLine().trim());
		for (int i = 1; i <= t; ++i)
			solve();
		file.close();
	}
}