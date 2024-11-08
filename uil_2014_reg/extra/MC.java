/*Region UIL 2014 Solution - #7 - Monte Carlo
Test data
11 15
0.925 9.011
8.786 0.314
1.303 2.945
3.236 -2.899
-8.134 3.362
-0.342 -7.365
-4.892 4.378
-1.612 4.985
9.372 -6.558
4.042 -0.529
4.704 7.047
6 -4.715 5.868
11 0.589 4.445
4 -0.518 -4.626
2 -2.520 1.546
7 6.772 -0.035
7 4.708 -2.733
10 3.354 -4.346
6 -6.081 0.047
5 0.963 -6.185
11 1.902 -0.444
6 -4.446 -2.126
7 -5.645 2.262
4 3.523 -3.125
7 1.222 5.902
8 3.378 -2.270

Output
0.925 9.011
6.266 1.860
1.303 2.945
6.241 -10.650
-7.171 -2.823
-15.584 -3.576
-2.543 12.507
-1.612 4.985
9.372 -6.558
7.396 -4.875
7.195 11.048
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class MC {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("mc.dat"));
		int p = sc.nextInt();
		int m = sc.nextInt();
		double[] x = new double[p];
		double[] y = new double[p];
		for(int i = 0; i < p; i++){
			x[i] = sc.nextDouble();
			y[i] = sc.nextDouble();
		}for(int i = 0; i < m; i++){
			int part = sc.nextInt() - 1;
			double dx = sc.nextDouble();
			double dy = sc.nextDouble();
			if(calculate(part, dx, dy, x, y)){
				x[part] += dx;
				y[part] += dy;
			}
		}
		for(int i = 0; i < p; i++){
			System.out.printf("%.3f %.3f\n", x[i], y[i]);
		}

	}

	private static boolean calculate(int part, double dx, double dy,
			double[] x, double[] y) {
		boolean val = true;
		double testX = x[part] + dx;
		double testY = y[part] + dy;
		for(int i = 0; i < x.length; i++){
			if(i==part)
				continue;
			val &= range(testX, testY, x[i], y[i]);
		}
		return val;
	}

	private static boolean range(double testX, double testY, double x, double y) {
		return Math.sqrt(Math.pow(testX-x, 2) + Math.pow(testY-y, 2)) >= 1.0;
	}

}
