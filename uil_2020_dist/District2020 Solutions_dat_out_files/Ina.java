/*
 *UIL Computer Science 2020
 *District Packet Solution
 */
import java.io.*;
import java.util.*;

public class Ina {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("ina.dat"));
        int T = scan.nextInt();
        assert 1 <= T && T <= 50;

        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int ans = solve(scan);
            System.out.printf("Case #%d: %d%n", caseNum, ans);
        }
    }

    private static int solve(Scanner scan) throws IOException {
        int n = scan.nextInt();
        int s = scan.nextInt() - 1;
        int l = scan.nextInt();

        assert 1 <= n && n <= 100;
        assert 0 <= s && s < n;
        assert 1 <= l && l < 1000000;

        List<Integer>[] tree = new List[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            int u = scan.nextInt() - 1;
            int v = scan.nextInt() - 1;

            assert 0 <= u && u < n;
            assert 0 <= v && v < n;
            assert u != v;

            tree[u].add(v);
            tree[v].add(u);
        }

        assert connected(tree);

        int[] dp = new int[n];
        return dfs(tree, dp, l, s, -1);
    }

    private static int dfs(List<Integer>[] tree, int[] dp, int l, int u, int p) {
        List<Integer> childrenDP = new ArrayList<>();
        for (int v : tree[u]) {
            if (v == p) continue;
            childrenDP.add(dfs(tree, dp, l, v, u));
        }

        Collections.sort(childrenDP);
        Collections.reverse(childrenDP);
        for (int i = 0; i < childrenDP.size(); i++) {
            dp[u] = Math.max(dp[u], (i + 1) * l + childrenDP.get(i));
        }

        return dp[u];
    }

    private static boolean connected(List<Integer>[] tree) {
        int n = tree.length;
        DSU dsu = new DSU(n);
        for (int u = 0; u < n; u++) {
            for (int v : tree[u]) {
                if (u < v) {
                    boolean merged = dsu.merge(u, v);
                    if (!merged) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private static class DSU {
        int[] uf;

        public DSU(int n) {
            this.uf = new int[n];
            for (int i = 0; i < n; i++) {
                this.uf[i] = i;
            }
        }

        int find(int x) {
            return uf[x] = (uf[x] == x ? x : find(uf[x]));
        }

        boolean merge(int x, int y) {
            int xr = find(x);
            int yr = find(y);
            if (xr == yr) {
                return false;
            }

            uf[xr] = yr;

            return true;
        }
    }
}
