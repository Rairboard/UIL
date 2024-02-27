/*
 *UIL Computer Science 2020
 *District Packet Solution
 */
import java.io.*;
import java.util.*;

public class Magdalena {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("magdalena.dat"));
        int T = scan.nextInt();
        assert 1 <= T && T <= 50;

        for (int caseNum = 1; caseNum <= T; caseNum++) {
            String ans = solve(scan);
            System.out.printf("Case #%d: %s%n", caseNum, ans);
        }
    }

    private static String solve(Scanner scan) throws IOException {
        int b = scan.nextInt();
        String a = scan.next();
        int n = a.length();

        assert 2 <= b && b <= 62;
        assert 1 <= n && n <= 200;
        assert a.charAt(0) != '0';

        int ans = 0;
        for (char c : a.toCharArray()) {
            int v = parseDigit(c);
            assert v < b;
            ans += v;
        }

        ans = Math.max(ans, parseDigit(a.charAt(0)) - 1 + (n - 1) * (b - 1));

        return toBase(ans, b);
    }

    private static int parseDigit(char c) {
        if ('0' <= c && c <= '9') {
            return c - '0';
        } else if ('A' <= c && c <= 'Z') {
            return c - 'A' + 10;
        } else {
            return c - 'a' + 10 + 26;
        }
    }

    private static char toDigit(int x) {
        assert 0 <= x && x < 62;
        if (x < 10) {
            return (char)(x + '0');
        } else if (10 <= x && x < 10 + 26) {
            return (char)(x - 10 + 'A');
        } else {
            return (char)(x - 10 - 26 + 'a');
        }
    }

    private static String toBase(int x, int b) {
        StringBuilder sb = new StringBuilder();
        while (x > 0) {
            sb.append(toDigit(x % b));
            x /= b;
        }

        return sb.reverse().toString();
    }
}
