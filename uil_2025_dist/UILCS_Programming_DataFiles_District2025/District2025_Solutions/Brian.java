/*
 * UIL Computer Science 2025
 * District Packet Solution
 */

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Brian {
    public static void main(String[] args) throws Throwable {
        Scanner kb = new Scanner(new File("brian.dat"));

        int N = Integer.parseInt(kb.nextLine().trim());

        while(N-->0) {
            int D = Integer.parseInt(kb.next().trim()), S = Integer.parseInt(kb.next().trim());

            HashMap<String, Integer> map = new HashMap<>();
            int x = 0;

            int [][] edges = new int[S][3];

            for(int i = 0; i < S; i++) {
                String a = kb.next();
                String b = kb.next();
                int weight = kb.nextInt();
                if(!map.containsKey(a))
                    map.put(a, x++);
                if(!map.containsKey(b))
                    map.put(b, x++);
                edges[i] = new int[]{map.get(a), map.get(b), weight};
            }
            String start = kb.next();
            String end = kb.next();

            int source = map.get(start);
            int dest = map.get(end);

            long[] ans = bellmanFord(D + 1, edges, source);

            if(Arrays.equals(ans, new long[] {-1})) {
                System.out.println("Take as long as you need.");
            } else {
                System.out.println(ans[dest]);
            }
        }
        kb.close();
    }

    static long[] bellmanFord(int V, int[][] edges, int src) {

        // Initially distance from source to all other vertices
        // is not known(Infinite).
        long[] dist = new long[V];
        Arrays.fill(dist, (long)1e15);
        dist[src] = 0;

        // Relaxation of all the edges V times, not (V - 1) as we
        // need one additional relaxation to detect negative cycle
        for (int i = 0; i < V; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {

                    // If this is the Vth relaxation, then there is
                    // a negative cycle
                    if (i == V - 1)
                        return new long[]{-1};

                    // Update shortest distance to node v
                    dist[v] = dist[u] + wt;
                }
            }
        }
        return dist;
    }
}
