import java.io.*;
import java.util.*;
import java.math.*;

public class Ian {
	public static void main(String[] args) throws Exception {
		new Ian().run();
	}

	Scanner file;

	public void solve() {
		System.out.printf("%.2f%n", Double.parseDouble(file.next().trim()) * (1 - Double.parseDouble(file.nextLine().trim()) / 100.0) * 1.1);
	}

	public void run() throws Exception {
		file = new Scanner(new File("ian.dat"));
		int t = Integer.parseInt(file.nextLine().trim());
		for (int i = 1; i <= t; ++i)
			solve();
		file.close();
	}
}