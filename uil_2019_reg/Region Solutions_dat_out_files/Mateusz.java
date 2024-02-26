//Solution - UIL Region 2019
import java.io.*;
import java.util.*;

public class Mateusz {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("mateusz.dat"));
        int T = scan.nextInt();
        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int n = scan.nextInt();
            int[] xs = new int[n];
            int[] ys = new int[n];
            int[] ws = new int[n];
            int[] hs = new int[n];
            for (int i = 0; i < n; i++) {
                xs[i] = scan.nextInt();
                ys[i] = scan.nextInt();
                ws[i] = scan.nextInt();
                hs[i] = scan.nextInt();
            }

            long ans = 0L;
            // Inclusion exclusion: for every subset of rectangles, add its contribution.
            // Mask is in binary. Rectangle i is in subset <=> ith bit is set in mask.
            for (int mask = 1; mask < 1 << n; mask++) {
                // Intersection of all rectangles in this subset
                int leftX = Integer.MIN_VALUE;
                int rightX = Integer.MAX_VALUE;
                int botY = Integer.MIN_VALUE;
                int topY = Integer.MAX_VALUE;

                // even -> negative, odd -> positive
                int parity = -1;
                for (int i = 0; i < n; i++) {
                    // Make sure rectangle is in current subset
                    if ((mask & (1 << i)) == 0) {
                        continue;
                    }

                    parity = -parity;
                    leftX = Math.max(leftX, xs[i]);
                    rightX = Math.min(rightX, xs[i] + ws[i]);

                    botY = Math.max(botY, ys[i]);
                    topY = Math.min(topY, ys[i] + hs[i]);
                }

                long dx = rightX - leftX;
                long dy = topY - botY;
                if (dx <= 0 || dy <= 0) {
                    continue;
                }

                ans += parity * dx * dy;
            }

            System.out.printf("Case #%d: The total area is %d.%n", caseNum, ans);
        }
    }
}
