import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;


public class Knight {

	static int n;
	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("knight.dat"));
		n = sc.nextInt();
		int p = sc.nextInt();
		int[][] best = new int[n][n];
		HashSet<Point> pieces = new HashSet<Point>();
		for(int i = 0; i < p; i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			pieces.add(new Point(x,y));
		}
		System.out.println(calc(0, 0, best, pieces));
	}

	private static int calc(int x, int y, int[][] best, HashSet<Point> pieces) {
		if(best[x][y] != 0)
			return best[x][y];
		int max = 0;
		if(x+2 < n && y + 1 < n)
			max = Math.max(max, calc(x+2, y+1, best, pieces));
		if(x+2 < n && y - 1 >= 0)
			max = Math.max(max, calc(x+2, y-1, best, pieces));
		if(x+1 < n && y + 2 < n)
			max = Math.max(max, calc(x+1, y+2, best, pieces));
		if(x+1 < n && y - 2 > 0)
			max = Math.max(max, calc(x+1, y-2, best, pieces));
		if(pieces.contains(new Point(x,y)))
			max++;
		best[x][y] = max;
		return max;
	}

}
