/*
 *UIL Computer Science 2020
 *Region Packet Solution
 */
import java.io.*;
import java.util.*;

public class Olivia {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("olivia.dat"));
        int T = scan.nextInt();
        assert 1 <= T && T <= 50;

        for (int caseNum = 1; caseNum <= T; caseNum++) {
            long n = scan.nextLong();
            long m = scan.nextLong();
            long k = scan.nextLong();

            assert 1 <= n && n <= 1000000000;
            assert 1 <= m && m <= 1000000000;
            assert 1 <= k && k <= 1000000000;

            List<Long> factors = new ArrayList<>();
            for (long d = 1; d * d <= k; ++d) {
                if (k % d == 0) {
                    factors.add(d);
                    if (d * d < k)
                        factors.add(k / d);
                }
            }

            Collections.sort(factors);
            long lastRow = 0;
            long ans = 0;
            for (long row : factors) {
                if (row > n) break;
                long col = k / row;
                if (col > m) continue;
                long rows = row - lastRow;
                ans += rows * col;
                lastRow = row;
            }

            System.out.printf("Case #%d: %d%n", caseNum, ans);
        }
    }
}
