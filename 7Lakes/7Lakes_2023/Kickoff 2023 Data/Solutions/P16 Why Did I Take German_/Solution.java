import java.util.*;
import java.io.*;

public class Solution {

    static boolean good;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            double d = (int) (sc.nextDouble() * 1000) / 1000.0;
            for (int n = 1; n <= 10000; n++) {
                int m = (int) (n / d);
                double d2 = (int) ((double) n / m * 1000) / 1000.0;
                if (d2 == d) {
                    System.out.println(n + " " + m);
                    break;
                }
                m++;
                d2 = (int) ((double) n / m * 1000) / 1000.0;
                if (d2 == d) {
                    System.out.println(n + " " + m);
                    break;
                }
            }
        }
        sc.close();
    }

}