import java.io.*;
import java.util.*;

public class Maite {
    private static final int MAXV = 1000000000;

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("maite.dat"));
        int T = scan.nextInt();
        int totalN = 0;
        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int N = scan.nextInt();
            int K = scan.nextInt();

            assert 2 <= N && N <= 200000;
            assert 1 <= K && K <= N;

            totalN += N;

            int[] a = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = scan.nextInt();
                assert -MAXV <= a[i] && a[i] <= MAXV;
            }

            Map<Integer, Integer> freq = new HashMap<>();
            int ans = 1;
            int j = 0;
            for (int i = 0; i < N; i++) {
                freq.put(a[i], freq.getOrDefault(a[i], 0) + 1);
                while (freq.get(a[i]) > K) {
                    freq.put(a[j], freq.get(a[j]) - 1);
                    j++;
                }

                ans = Math.max(ans, i - j + 1);
            }

            System.out.printf("Case #%d: %d%n", caseNum, ans);
        }

        assert totalN <= 2000000;
    }
}
