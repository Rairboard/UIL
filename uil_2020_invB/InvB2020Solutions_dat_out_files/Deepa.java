/*
 *UIL Computer Science 2020
 *Invitational B Packet Solution
 */
import java.io.*;
import java.util.*;

public class Deepa {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("deepa.dat"));
        int T = scan.nextInt();
        assert 1 <= T && T <= 20;

        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int N = scan.nextInt();
            int X = scan.nextInt();

            assert 1 <= N && N <= 20;
            assert 1 <= X && X <= 1000000;

            int[] val = new int[N];
            int[] percent = new int[N];
            for (int i = 0; i < N; i++) {
                val[i] = scan.nextInt();
                percent[i] = scan.nextInt();

                assert 0 <= val[i] && val[i] <= 1000000;
                assert 0 <= percent[i] && percent[i] < 100;

                if (i > 0) {
                    assert val[i] > val[i - 1];
                    assert percent[i] > percent[i - 1];
                } else {
                    assert val[0] == 0;
                }
            }

            int tax = 0;
            int rem = X;
            for (int i = 1; i < N; i++) {
                int gap = val[i] - val[i - 1];
                int take = Math.min(gap, rem);
                tax += take * percent[i - 1];
                rem -= take;
            }

            tax += rem * percent[N - 1];

            System.out.printf("Case #%d: $%,d.%02d %.3f%%%n", caseNum, tax / 100, tax % 100, 1.0 * tax / X);
        }
    }
}
