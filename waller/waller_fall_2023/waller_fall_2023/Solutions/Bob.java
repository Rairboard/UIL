import java.io.*;
import java.util.*;
import java.math.*;

public class Bob {
	public static void main(String[] args) throws Exception {
		new Bob().run();
	}

	Scanner file;

	public void solve() {
		BigInteger a = new BigInteger(file.next().trim());
		BigInteger b = new BigInteger(file.next().trim());
		char op = file.nextLine().trim().charAt(0);
		System.out.printf("%s%n", (op == '+' ? a.add(b) : a.multiply(b)).toString());
	}

	public void run() throws Exception {
		file = new Scanner(new File("bob.dat"));
		int t = Integer.parseInt(file.nextLine().trim());
		for (int i = 1; i <= t; ++i)
			solve();
		file.close();
	}
}