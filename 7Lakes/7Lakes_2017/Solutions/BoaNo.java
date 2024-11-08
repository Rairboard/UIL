import java.util.*;
import java.io.*;

public class BoaNo {
	static final int[] dx = { 0, 1, 0, -1 };
	static final int[] dy = { 1, 0, -1, 0 };

	public static Integer[] pos(char[][] grid, int n, int m, char c) {
		Integer[] res = new Integer[2];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				res[0] = i;
				res[1] = j;
				if (grid[i][j] == c)
					return res;
			}
		}
		return res;
	}

	public static int BFS(char[][] grid, int n, int m) {
		int[][] dist = new int[n][m];
		boolean[][] vis = new boolean[n][m];
		LinkedList<Integer[]> q = new LinkedList<Integer[]>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		Integer[] cur = pos(grid, n, m, 'C');
		q.add(cur);
		dist[cur[0]][cur[1]] = 0;
		vis[cur[0]][cur[1]] = true;

		while (q.size() > 0) {
			cur = q.pollFirst();
			vis[cur[0]][cur[1]] = true;
			for (int i = 0; i < 4; i++) {
				Integer[] adj = new Integer[2];
				adj[0] = cur[0] + dx[i];
				adj[1] = cur[1] + dy[i];
				if (adj[0] >= 0 && adj[1] >= 0 && adj[0] < n && adj[1] < m) {
					if (dist[adj[0]][adj[1]] > dist[cur[0]][cur[1]] + 1)
						dist[adj[0]][adj[1]] = dist[cur[0]][cur[1]] + 1;
					if (grid[adj[0]][adj[1]] != '#' && !vis[adj[0]][adj[1]])
						q.addLast(adj);
				}
			}
		}

		Integer[] p = pos(grid, n, m, 'E');
		return dist[p[0]][p[1]];
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("boa.in"));
		int sets = sc.nextInt();
		for (int set = 0; set < sets; set++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			sc.nextLine();
			char[][] grid = new char[n][m];
			for (int i = 0; i < n; i++) {
				char[] c = sc.nextLine().toCharArray();
				for (int j = 0; j < m; j++) {
					grid[i][j] = c[j];
				}
			}
			int steps = BFS(grid, n, m);
			if (steps == Integer.MAX_VALUE)
				System.out.println("Squish.");
			else
				System.out.println(steps);
		}
		sc.close();
	}
}