import java.io.*;
import java.util.*;

public class Irene {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("irene.dat"));
        int T = scan.nextInt();
        assert 1 <= T && T <= 20;

        while (T --> 0) {
            int R = scan.nextInt();
            int C = scan.nextInt();
            assert 1 <= R && R <= 10;
            assert 1 <= C && C <= 10;

            boolean[] isDefective = new boolean[R * C];
            for (int i = 0; i < R; i++) {
                String s = scan.next();
                for (int j = 0; j < C; j++) {
                    isDefective[C * i + j] = s.charAt(j) == '*';
                }
            }

            System.out.println(solve(R, C, isDefective));
        }
    }

    public static long solve(int R, int C, boolean[] isDefective) {
        // example mask when C = 7
        //    edcb
        // a987654
        // 3210
        int maskSize = 2 * C + 1;
        int fullMask = (1 << maskSize) - 1;
        int iMask = (1 << 0) | (1 << C) | (1 << (2 * C));
        int uMask = iMask | (1 << (C - 2)) | (1 << (2 * C - 2));
        // lMask is the same as iMask

        // Can we place a U, I, or L with bottom left corner at i, j?
        // check the mask and the two cells to the right
        boolean[][] can = new boolean[R * C][3];
        {
            int curMask = fullMask;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    int cell = C * i + j;

                    curMask = (curMask << 1) & fullMask;
                    if (isDefective[cell]) {
                        curMask |= 1;
                        continue;
                    }

                    can[cell][1] = (iMask & curMask) == 0;
                    if (j + 2 < C) {
                        boolean clearRight = !isDefective[cell + 1] && !isDefective[cell + 2];
                        can[cell][0] = clearRight && (uMask & curMask) == 0;
                        can[cell][2] = clearRight && can[cell][1];
                    }
                }
            }
        }

        // how many ways are there to end up in this cell with this prior mask?
        long[][] dp = new long[R * C + 1][fullMask + 1];
        dp[0][fullMask] = 1;
        for (int cell = 0; cell < R * C; ++cell) {
            for (int mask = 0; mask <= fullMask; mask++) {
                if (dp[cell][mask] == 0) {
                    continue;
                }

                int newMask = ((mask << 1) & fullMask) | (isDefective[cell] ? 1 : 0);

                // don't place anything
                {
                    dp[cell + 1][newMask] += dp[cell][mask];
                }

                // place something
                if (can[cell][0] && (newMask & uMask) == 0) {
                    int newUMask = (((newMask | uMask) << 2) & fullMask) | 3;
                    dp[cell + 3][newUMask] += dp[cell][mask];
                }
                if (can[cell][1] && (newMask & iMask) == 0) {
                    int newIMask = newMask | iMask;
                    dp[cell + 1][newIMask] += dp[cell][mask];
                }
                if (can[cell][2] && (newMask & iMask) == 0) {
                    int newLMask = (((newMask | iMask) << 2) & fullMask) | 3;
                    dp[cell + 3][newLMask] += dp[cell][mask];
                }
            }
        }

        long ans = 0;
        for (int mask = 0; mask <= fullMask; mask++) {
            ans += dp[R * C][mask];
        }

        // subtract out not placing any letters
        return ans - 1;
    }
}
