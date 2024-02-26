import java.io.*;
import java.util.*;
import java.math.*;

public class Albert {
	public static void main(String[] args) throws Exception {
		new Albert().run();
	}

	Scanner file;

	public void solve() {
		String s = file.nextLine().trim();
		System.out.printf("%s!!!%n", s);
	}

	public void run() throws Exception {
		file = new Scanner(new File("albert.dat"));
		int t = Integer.parseInt(file.nextLine().trim());
		for (int i = 1; i <= t; ++i)
			solve();
		file.close();
	}
}