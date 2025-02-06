import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Isamu {
    static int ans;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("isamu.dat"));
        int T = scan.nextInt();
        assert 1 <= T && T <= 20;
        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int C = scan.nextInt();
            int R = scan.nextInt();
            assert 1 <= C && C <= 8;
            assert C - 1 <= R && R <= C * (C - 1) / 2;

            dist = new int[C][C];
            Map<String, Integer> cityNames = new HashMap<>();
            for (int i = 0; i < C; i++) {
                String cityName = scan.next();
                assert Pattern.matches("^[a-z]{1,15}$", cityName);

                cityNames.put(cityName, i);
                // If we used max value as is, would run into overflow problems
                Arrays.fill(dist[i], Integer.MAX_VALUE / 3);
                dist[i][i] = 0;
            }

            for (int i = 0; i < R; i++) {
                String city1 = scan.next();
                String city2 = scan.next();
                int w = scan.nextInt();

                assert cityNames.containsKey(city1);
                assert cityNames.containsKey(city2);
                assert !city1.equals(city2);

                int u = cityNames.get(city1);
                int v = cityNames.get(city2);
                assert u != v;
                assert 1 <= w && w <= 100;

                dist[u][v] = dist[v][u] = w;
            }

            // All-Pairs Shortest Path
            for (int k = 0; k < C; k++) {
                for (int i = 0; i < C; i++) {
                    for (int j = 0; j < C; j++) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }

            ans = Integer.MAX_VALUE;
            dfs(0, 1, 0);

            // Check possible
            assert ans != Integer.MAX_VALUE;
            System.out.printf("Case #%d: %d%n", caseNum, ans);
        }
    }

    public static void dfs(int cur, int visited, int traveled) {
        // Optimization, not strictly needed for this problem
        /*
        if (traveled > ans) {
            return;
        }
        */

        if (visited == (1 << dist.length) - 1) {
            ans = Math.min(ans, traveled);
            return;
        }

        for (int i = 0; i < dist.length; i++) {
            if ((visited & (1 << i)) > 0) {
                continue;
            }

            dfs(i, visited | (1 << i), traveled + dist[cur][i]);
        }
    }
}
