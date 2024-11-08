import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PingPong {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("pingpong.dat"));
		int T = in.nextInt();
		while (T-- > 0) {
			double p1 = in.nextDouble();
			double p2 = in.nextDouble();
			double h = in.nextInt();
			double result = p1;
			for (int i = 0; i < h-1; i++) {
				result *= (1-p1)*(1-p2);
			}
			System.out.printf("%.4f\r\n", result);
		}
	}
}
