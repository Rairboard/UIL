import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Inflation {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("inflation.in"));

		int cases = in.nextInt();
		in.nextLine();

		for (int a = 0; a < cases; a++) {
			int coins = in.nextInt();
			double r = in.nextDouble();
			int t = in.nextInt();
			double n = in.nextDouble();

			int o = in.nextInt();
			int aTot = 0;
			for (int i = 0; i < o; i++) {
				aTot += in.nextInt();
			}

			long totWealth = coins + aTot;

			double rebellion = Math.pow(2 - r, 0.5);
			double transport = Math.log10(t);

			n = Math.pow(n, 1.5);

			double p = (totWealth * rebellion * transport) / n;

			p = Math.sqrt(p);

			System.out.printf("%.2f%n", p);
		}
	}
}