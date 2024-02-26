import java.io.*;
import java.util.*;
import java.math.*;

public class Duke {
	public static void main(String[] args) throws Exception {
		new Duke().run();
	}

	Scanner file;

	public void solve() {
		int r = Integer.parseInt(file.next().trim()), c = Integer.parseInt(file.next().trim());
		char f = file.nextLine().trim().charAt(0);
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j)
				System.out.print(f);
			System.out.println();
		}
	}

	public void run() throws Exception {
		file = new Scanner(new File("duke.dat"));
		int t = Integer.parseInt(file.nextLine().trim());
		for (int i = 1; i <= t; ++i)
			solve();
		file.close();
	}
}