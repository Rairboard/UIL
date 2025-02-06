import java.io.*;
import java.util.*;

public class Manasa {
    static final int MAX = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("manasa.dat"));

        int T = scan.nextInt();
        assert 1 <= T && T <= 50;

        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int v1 = scan.nextInt();
            int t1 = scan.nextInt();
            int v2 = scan.nextInt();
            int t2 = scan.nextInt();
            int d = scan.nextInt();

            assert 1 <= v1 && v1 <= MAX;
            assert 1 <= t1 && t1 <= MAX;
            assert 1 <= v2 && v2 <= MAX;
            assert 1 <= t2 && t2 <= MAX;
            assert 1 <= d && d <= MAX;

            long d1 = 1L * v1 * t1;
            long d2 = 1L * v2 * t2;
            long ans = solve(d1, d2, d);
            long ans2 = solve2(d1, d2, d);
            assert ans == ans2;
            System.out.printf("Case #%d: ", caseNum);
            if (ans == -1) {
                System.out.println("Impossible");
            } else {
                System.out.println(ans2);
            }
        }
    }

    private static long solve(long d1, long d2, long d) {
        if (d1 >= d) {
            return 1;
        } else if (d1 <= d2) {
            return -1;
        }

        long lo = 1;
        long hi = (long)1e9;
        while (lo + 1 < hi) {
            long mid = (lo + hi) / 2;
            long dist = mid * d1 - (mid - 1) * d2;
            if (dist >= d) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        return hi;
    }

    private static long solve2(long d1, long d2, long d) {
        if (d1 >= d) {
            return 1;
        } else if (d1 <= d2) {
            return -1;
        }

        // find smallest x such that x * d1 - (x - 1) * d2 >= d
        // find smallest x such that x * d1 - x * d2 + d2 >= d
        // find smallest x such that x * (d1 - d2) >= d - d2
        // x >= (d + d2) / (d1 - d2)
        long dd = d1 - d2;
        return (d - d2 + dd - 1) / dd;
    }
}
