/*
 *UIL Computer Science 2020
 *District Packet Solution
 */
import java.io.*;
import java.util.*;

public class Wojtek {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("wojtek.dat"));
        int T = scan.nextInt();
        assert 1 <= T && T <= 50;

        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int ans = solve(scan);
            System.out.printf("Case #%d: %d%n", caseNum, ans);
        }
    }

    private static int solve(Scanner scan) throws IOException {
        int[] a = new int[4];
        for (int i = 0; i < 4; i++) {
            a[i] = scan.nextInt();
            assert -100000 <= a[i] && a[i] <= 100000;
        }

        int ans = 0;
        while (!isAllZero(a)) {
            ans++;
            a = step(a);
        }

        return ans;
    }

    private static boolean isAllZero(int[] a) {
        for (int x : a) {
            if (x != 0) {
                return false;
            }
        }

        return true;
    }

    private static int[] step(int[] a) {
        int[] b = new int[4];
        for (int i = 0; i < 4; ++i) {
            int j = (i + 1) % 4;
            b[i] = Math.abs(a[i] - a[j]);
        }

        return b;
    }
}
