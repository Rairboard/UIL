import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Inside {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {
		int max = 100;
		Scanner sc = new Scanner(new File("inside.dat"));
		int t = sc.nextInt();
	while (t-- > 0){
		int c = sc.nextInt();
		int p = sc.nextInt();
		int[][] points = new int[c][2];
		for (int i = 0; i < c; i++) {
			points[i][0] = sc.nextInt();
			points[i][1] = sc.nextInt();
		}
		for (int i = 0; i < p; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int right = 0;
			int above = 0;
			for (int j = 1; j <= c; j++) {
				if (checkAbove(points, j-1, j % c, x, y)){
					above++;
				}
				if (checkLeft(points, j-1, j % c, x, y)){
					right++;
				}
			}
			if (above % 2 == 1 && right % 2 == 1)
				System.out.println("inside");
			else
				System.out.println("outside");
		}
	}
	}

	private static boolean checkAbove(int[][] points, int j, int i, int x, int y) {
		double slope = (points[j][1] - points[i][1])
				/ (double) (points[j][0] - points[i][0]);
		double b = points[j][1] - slope * points[j][0];
		if (slope * x + b > y && (x > points[j][0] && x < points[i][0] || x < points[j][0] && x > points[i][0]))
			return true;
		else
			return false;
	}

	private static boolean checkLeft(int[][] points, int j, int i, int x, int y) {
		double slope = (points[j][1] - points[i][1])
				/ (double) (points[j][0] - points[i][0]);
		double b = points[j][1] - slope * points[j][0];
		if ((y - b) / slope > x && (y > points[j][1] && y < points[i][1] || y < points[j][1] && y > points[i][1]))
			return true;
		else
			return false;
	}
}
