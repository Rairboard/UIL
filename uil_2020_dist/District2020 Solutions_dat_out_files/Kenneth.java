/*
 *UIL Computer Science 2020
 *District Packet Solution
 */
import java.util.*;
import java.io.*;
import static java.lang.System.out;

public class Kenneth {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("kenneth.dat"));
		int N = s.nextInt();
		for (int n = 1; n <= N; n++) {
			int[][] grid = new int[10][10];
			ArrayList<Integer> badrows = new ArrayList<Integer>();
			ArrayList<Integer> badcols = new ArrayList<Integer>();
			for (int r = 1; r <= 9; r++) {
				for (int c = 1; c <= 9; c++)
					grid[r][c] = s.nextInt();
				if (!checkDigits(grid[r])) badrows.add(r);
			}
			for (int c = 1; c <= 9; c++) {
				for (int r = 1; r <= 9; r++) 
					grid[0][r] = grid[r][c];
				if (!checkDigits(grid[0])) badcols.add(c);
			}
			if (badrows.size() == 0 && badcols.size() == 0)
				out.printf("GRID #%d: SOLUTION IS CORRECT", n);
			else {
				out.printf("GRID #%d: NOT A SOLUTION\n", n);
				out.print(">> ROWS WITH ERRORS:");
				if (badrows.size() == 0) out.print(" NONE");
				else while (badrows.size() > 0) out.printf(" %d",badrows.remove(0));
				out.print("\n>> COLUMNS WITH ERRORS:");
				if (badcols.size() == 0) out.print(" NONE");
				else while (badcols.size() > 0) out.printf(" %d",badcols.remove(0));
			}
			out.println("\n============");
		}
	}
	
	static boolean checkDigits(int[] data) {
		boolean result = true;
		int[] mydata = Arrays.copyOf(data,10);
		Arrays.sort(mydata);
		int i = 1;
		while (result && i <= 9) {
			result &= (i == mydata[i]);
			i++;
		}
		return result;
	}
}
