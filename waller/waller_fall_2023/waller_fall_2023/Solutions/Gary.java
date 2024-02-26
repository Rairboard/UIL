import java.io.*;
import java.util.*;
import java.math.*;

public class Gary {
	public static void main(String[] args) throws Exception {
		new Gary().run();
	}

	Scanner file;

	final int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

	int r, c, k, T, sx, sy, ex, ey;
	char[][] mat;
	int[][][] shad;

	public boolean inb(int x, int y) {
		return x >= 0 && y >= 0 && x < r && y < c;
	}

	public void search(int x, int y, int s, int charge) {
		if (!inb(x, y) || mat[x][y] == '#' || shad[x][y][charge] <= s)
			return;
		shad[x][y][charge] = s;
		for (int i = 0; i < 4; ++i) {
			int nd = charge == k ? k : charge + 1;
			search(x + dx[i], y + dy[i], s + 1, nd);
			if (charge == k && inb(x + dx[i], y + dy[i]) && mat[x + dx[i]][y + dy[i]] != '#')
				search(x + dx[i] * 2, y + dy[i] * 2, s + 1, 0);
		}
	}

	public void solve() {
		r = Integer.parseInt(file.next().trim());
		c = Integer.parseInt(file.next().trim());
		k = Integer.parseInt(file.next().trim()) - 1;
		T = Integer.parseInt(file.nextLine().trim());
		mat = new char[r][c];
		for (int i = 0; i < r; ++i) {
			mat[i] = file.nextLine().trim().toCharArray();
			for (int j = 0; j < c; ++j)
				if (mat[i][j] == 'G') {
					sx = i; sy = j;
				} else if (mat[i][j] == 'C') {
					ex = i; ey = j;
				}
		}
		shad = new int[r][c][k + 1];
		for (int i = 0; i < r; ++i)
			for (int j = 0; j < c; ++j)
				Arrays.fill(shad[i][j], Integer.MAX_VALUE);
		search(sx, sy, 0, 0);
		int best = shad[ex][ey][0];
		for (int i = 1; i <= k; ++i)
			best = Math.min(best, shad[ex][ey][i]);
		System.out.println(best <= T ? "Dashing!" : "Cat :(");
	}

	public void run() throws Exception {
		file = new Scanner(new File("gary.dat"));
		int t = Integer.parseInt(file.nextLine().trim());
		for (int i = 1; i <= t; ++i)
			solve();
		file.close();
	}
}