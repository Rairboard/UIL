import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class Bridgeposts {
	//public static final int MAX_DEPTH = (int)1e6;
	public static void main (String [] args) throws FileNotFoundException {

		Scanner in = new Scanner (new File ("bridgeposts.dat"));
		int noTests = in.nextInt();
		for (int i = 0; i < noTests; i++) {
			getShallowest(in);
		}
		in.close();
	}

	public static void getShallowest (Scanner in) {
		int miles = in.nextInt();
		int [] depths = new int [miles];
		for (int i = 0; i < miles; i ++) {
			depths[i] = in.nextInt();
		}
		int ships = in.nextInt();
		int maxD = 0;
		for (int i = 0; i < ships; i ++ ) {
			int distance = in.nextInt();
			if (distance > maxD) maxD = distance;
		}
		int [] d = Arrays.copyOf(depths, maxD);
		Arrays.sort(d);
		System.out.println(d[0]);
	}
}
