//UIL District 2019 Solution
import java.io.*;
import java.util.*;

public class Tammy {
    public static int find(int[] uf, int x) {
        return uf[x] = x == uf[x] ? x : find(uf, uf[x]);
    }

    public static int merge(int[] uf, int x, int y) {
        int xRoot = find(uf, x);
        int yRoot = find(uf, y);
        if (xRoot == yRoot) {
            return 0;
        }

        uf[xRoot] = yRoot;
        return 1;
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("tammy.dat"));
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            int componentCount = n;
            int[] uf = new int[n];
            for (int i = 0; i < n; i++) {
                uf[i] = i;
            }

            for (int i = 0; i < m; i++) {
                int a = scan.nextInt() - 1;
                int b = scan.nextInt() - 1;
                componentCount -= merge(uf, a, b);
            }

            if (componentCount == n) {
                System.out.println("1 1");
            } else {
                long ways = 1L;
                for (int i = 0; i < componentCount; i++) {
                    ways *= 2L;
                }

                System.out.println("2 " + ways);
            }
        }
    }
}
