/*
 *UIL Computer Science 2020
 *Region Packet Solution
 */
import java.io.*;
import java.util.*;

public class Terry {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("terry.dat"));
        int T = scan.nextInt();
        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int n = scan.nextInt();
            int k = scan.nextInt();

            assert 1 <= n && n <= 100;
            assert 1 <= k && k <= 10000;

            double[] dp = new double[k + 1];
            dp[0] = 1.0;
            for (int i = 0; i < n; i++) {
                int v = scan.nextInt();
                assert 1 <= v && v <= 10000;
                double p = (100 - scan.nextInt()) / 100.0;
                assert 0.0 <= p && p <= 1.0;
                for (int j = k; j >= 0; j--) {
                    int newVal = Math.min(k, j + v);
                    dp[newVal] = Math.max(dp[newVal], dp[j] * p);
                }
            }

            System.out.printf("Case #%d: %.06f%n", caseNum, 100.0 * (1.0 - dp[k]));
        }
    }
}
