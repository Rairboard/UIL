//Solution - UIL Region 2019, solution works using Java version 11.0.1

import java.io.*;
import java.util.*;

public class Deborah {
    public static void dfs(
            Map<String, List<String>> tree,
            Map<String, Integer> depths, 
            String folder,
            int depth
    ) {
        depths.put(folder, depth);
        for (String child : tree.get(folder)) {
            dfs(tree, depths, child, depth + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("deborah.dat"));
        int T = Integer.parseInt(scan.nextLine());
        while (T-- > 0) {
            int n = Integer.parseInt(scan.nextLine());
            Map<String, List<String>> tree = new HashMap<>();
            List<String> favorites = new ArrayList<>();
            Set<String> inFolder = new HashSet<>();

            for (int i = 0; i < n; ++i) {
                StringTokenizer st = new StringTokenizer(scan.nextLine());
                String name = st.nextToken();
                boolean isFavorite = st.nextToken().equals("1");
                if (isFavorite) {
                    favorites.add(name);
                }
                int numChildren = Integer.parseInt(st.nextToken());

                tree.put(name, new ArrayList<>());
                st = new StringTokenizer(scan.nextLine());
                for (int j = 0; j < numChildren; j++) {
                    String child = st.nextToken();
                    tree.get(name).add(child);
                    inFolder.add(child);
                }
            }

            Map<String, Integer> depths = new HashMap<>();
            for (String folder : tree.keySet()) {
                if (!inFolder.contains(folder)) {
                    dfs(tree, depths, folder, 0);
                }
            }

            int bestDepth = -1;
            String bestAns = "";
            for (String fave : favorites) {
                if (depths.get(fave) > bestDepth) {
                    bestAns = fave;
                    bestDepth = depths.get(fave);
                } else if (depths.get(fave) == bestDepth) {
                    bestAns = fave.compareTo(bestAns) < 0 ? fave : bestAns;
                }
            }

            System.out.printf("%s (%d)%n", bestAns, bestDepth);
        }
    }
}
