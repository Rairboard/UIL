/*
 *UIL Computer Science 2020
 *Invitational B Packet Solution
 */
import java.io.*;
import java.util.*;

public class Maciej {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("maciej.dat"));
        int T = scan.nextInt();
        assert 1 <= T && T <= 20;

        for (int caseNum = 1; caseNum <= T; caseNum++) {
            String s = scan.next();
            String t = scan.next();

            int[] a = convert(s);
            int[] b = convert(t);

            int[] c = new int[3];
            for (int i = 0; i < 3; i++) {
                c[i] = (a[i] + b[i]) / 2;
            }

            System.out.printf("Case #%d: %s%n", caseNum, toHex(c));
        }
    }

    private static int[] convert(String hexColor) {
        assert hexColor.length() == 7;
        assert hexColor.charAt(0) == '#';

        int[] result = new int[3];
        for (int i = 0; i < 3; i++) {
            String sub = hexColor.substring(1 + 2 * i, 1 + 2 * i + 2);
            result[i] = Integer.parseInt(sub, 16);
            assert 0 <= result[i] && result[i] <= 255;
        }

        return result;
    }

    private static String toHex(int[] color) {
        String result = String.format("#%02x%02x%02x", color[0], color[1], color[2]);
        return result.toUpperCase();
    }
}
