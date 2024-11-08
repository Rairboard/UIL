/*
 *UIL Computer Science 2020
 *Region Packet Solution
 */
import java.io.*;
import java.util.*;
import static java.lang.System.out;

public class Esteban {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("esteban.dat"));
		int N = s.nextInt();
		s.nextLine();
		for (int n = 1; n <= N; n++) {
			char type = s.next().charAt(0);
			int temp = s.nextInt();
			double h = s.nextInt();
			//s.nextLine();
			double t = temp;
			double heatindex = 0;
			double adjust;

			if (type == 'C') t = temp * 9.0 / 5.0 + 32.0;
			heatindex = -42.379 + 2.04901523 * t + 10.14333127 * h - 0.22475541 * t * h 
						- 6.83783e-3 * t * t - 5.481717e-2 * h * h + 1.22874e-3 * t * t * h
						+ 8.5282e-4 * t * h * h - 1.99e-6 * t * t * h * h;
			if (h < 13) {
				adjust = (13.0 - h) * Math.sqrt( (17.0 - Math.abs(t - 95.0)) / 17.0) / 4.0;
				heatindex = heatindex - adjust;
			}
			else if (h > 85) {
				adjust = (h - 85.0) * (87.0 - t) / 50.0;
				heatindex = heatindex + adjust;
			}
			boolean invalid = t < 80 || heatindex < t && h >= 40 || heatindex > 140;
			if (type == 'C') {
				heatindex = (heatindex - 32.0) * 5.0 / 9.0;
			}
			out.printf("#%d:%3.1f%c", n, heatindex, type);
			if (invalid) out.println(" INVALID");
			else out.println();
		}
	}
}
