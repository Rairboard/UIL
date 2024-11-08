import java.util.*;
import java.io.*;

public class Solution {

    static boolean good;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            good = false;
            int n = sc.nextInt();
            int m = sc.nextInt();
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) arr.add(new ArrayList<>());
            for (int i = 0; i < m; i++) {
                int x = sc.nextInt() - 1;
                int y = sc.nextInt() - 1;
                arr.get(x).add(y);
                arr.get(y).add(x);
            }
            boolean[] visited = new boolean[n];
            dfs(arr, a, b, visited, 0);
            if (good) {
                System.out.println("We meet at last.");
            }
            else {
                System.out.println("Lost at sea.");
            }
        }
        sc.close();
    }

    public static void dfs(ArrayList<ArrayList<Integer>> arr, int i, int b, boolean[] visited, int len) {
        if (visited[i] || good) return;
        if (i == b && len % 2 == 0) {
            good = true;
            return;
        }
        else if (i == b) return;
        visited[i] = true;
        for (int j : arr.get(i)) {
            dfs(arr, j, b, visited, len + 1);
        }
        visited[i] = false;
    }

}