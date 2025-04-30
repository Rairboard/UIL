/*
 * UIL Computer Science 2025
 * District Packet Solution
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Becker {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner kb = new Scanner(new File("becker.dat"));

        while(kb.hasNext()) {
            String [] s = kb.nextLine().split("\\s+");
            long A   = Long.parseLong(s[0]);
            double r = Double.parseDouble(s[1]) / 100;
            long n = Long.parseLong(s[2]);
            long t = Long.parseLong(s[3]);

            System.out.println(solve(A, r, n, t));
        }
        kb.close();
    }

    public static long solve(long A, double r, long n, long t) {
        double ans = Math.pow(1 + (r / n), n * t);

        return (long) Math.ceil(A / ans);
    }
}
