/*
 *UIL Computer Science 2020
 *Invitational B Packet Solution
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
public class Teresa {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("teresa.dat"));
		int T = s.nextInt();
		for (int t = 1; t <= T; t++) {
			System.out.println(t + ":");
			int rows = s.nextInt();
			int cols = s.nextInt();
			int [][] data = new int[rows][cols];
			for (int r = 0; r < rows; r++)
				for (int c = 0; c < cols; c++)
					data[r][c] = s.nextInt();
//			pmatrix(data);
			for (int c = 0; c < cols; c++) {
				int [] col = new int[rows];
				for (int r = 0; r < rows; r++) col[r] = data[r][c];
				Arrays.sort(col);
				for (int r = 0; r < rows; r++) data[r][c] = col[r];
			}
//			pmatrix(data);
			for (int r = 0; r < rows; r++) Arrays.sort(data[r]);
			pmatrix(data);
		}
		s.close();
	}

	static void pmatrix(int [][] mat) {
		for (int r = 0; r < mat.length; r++) {
			for (int c = 0; c < mat[r].length; c++)
				System.out.printf("%d\t", mat[r][c]);
			System.out.println();
		}
		System.out.println("++++++++++++");
	}
}
