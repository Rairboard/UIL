import java.io.*;
import java.util.*;

public class Tiffany {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("tiffany.dat"));
        PrintWriter myout = new PrintWriter("tiffanya.out");
        int T = scan.nextInt();
        assert 1 <= T && T <= 50;

        int totalCells = 0;
        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int r = scan.nextInt();
            int c = scan.nextInt();

            totalCells += r * c;

            long ans = 0;

            int[][] a = new int[r][c];
            int[][] sameUp = new int[r][c];
            int[][] sameLeft = new int[r][c];
            int[][] largestSquare = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    a[i][j] = scan.nextInt();
                    assert 1 <= a[i][j];

                    sameUp[i][j] = sameLeft[i][j] = largestSquare[i][j] = 1;
                    if (i > 0 && a[i][j] == a[i - 1][j]) {
                        sameUp[i][j] += sameUp[i - 1][j];
                    }
                    if (j > 0 && a[i][j] == a[i][j - 1]) {
                        sameLeft[i][j] += sameLeft[i][j - 1];
                    }

                    if (i > 0 && j > 0 && a[i][j] == a[i - 1][j - 1]) {
                        largestSquare[i][j] = Math.min(Math.min(sameUp[i][j], sameLeft[i][j]), largestSquare[i - 1][j - 1] + 1);
                    }
                    if (largestSquare[i][j] > 1)
                    	myout.printf("\tr = %3d  c = %3d  size = %d  color = %9d\n", i, j, largestSquare[i][j]-1, a[i][j]);
                    ans += largestSquare[i][j];
                }
            }

            System.out.printf("Case #%d: %d%n", caseNum, ans);
        }
        myout.close();
        assert totalCells <= 5_000_000;
    }
}
