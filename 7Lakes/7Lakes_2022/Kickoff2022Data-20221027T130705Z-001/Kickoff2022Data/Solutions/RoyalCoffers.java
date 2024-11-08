import java.util.*;
import java.lang.*;
import java.io.*;

public class RoyalCoffers {
    static int N;
    static long C;
    static int[][] minions;

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        C = scan.nextLong();

        minions = new int[N][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                minions[i][j] = scan.nextInt();
            }
        }

        long low = 0l;
        long high = Long.MAX_VALUE-1;
        long mid = 0l;
        while (low < high) {
            mid = (low + high + 1) / 2;

            if (check(mid)) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        //System.out.println(low);
        if (check(low)) {
            System.out.println(low);
        } else {
            System.out.println(low + 1);
        }

    }

    static boolean check(long T) {
        long total = 0l;
        for (int i = 0; i < N; i++) {
            total += (T - minions[i][0]) / (minions[i][2]) * (minions[i][1]);
            //System.out.println(total);
        }
        return total >= C;
    }
}