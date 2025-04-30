/*
 * UIL Computer Science 2025
 * Invitational B Packet Solution
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Nicolas {
	public static void main(String[] args) throws IOException {
		new Nicolas().run();
	}

	private void run() throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("nicolas.dat"));
		PrintWriter out = new PrintWriter(System.out);

		solve(file, out);

		file.close();
		out.close();
	}

	public void solve(BufferedReader file, PrintWriter out) throws IOException {
		int n = Integer.parseInt(file.readLine());
		while(n-->0) {
			StringTokenizer st = new StringTokenizer(file.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			char[][] m = new char[r][c];
			int startR = -1, startC = -1;
			int endR = -1, endC = -1;
			for(int i = 0; i < r; i++) {
				m[i] = file.readLine().toCharArray();
				for(int j = 0; j < c; j++) {
					if(m[i][j] == 'S') {
						startR = i;
						startC = j;
					} else if(m[i][j] == 'E') {
						endR = i;
						endC = j;
					}
				}
			}

			out.println(bfs(m, r, c, startR, startC, endR, endC));
		}
	}

	private class Query {
		public String path;
		public int r, c;

		public Query(int r, int c, String p) {
			this.r = r;
			this.c = c;
			this.path = p;
		}
	}
	
	private static final String DIRECTIONS = "ENSW";

	private String bfs(char[][] m, int r, int c, int startR, int startC, int endR, int endC) {
		Queue<Query> toSearch = new LinkedList<Query>();
		boolean[][] visited = new boolean[r][c];

		toSearch.offer(new Query(startR, startC, ""));
		visited[startR][startC] = true;
		while(!toSearch.isEmpty()) {
			Query curr = toSearch.poll();

			int currR = curr.r;
			int currC = curr.c;
			String currP = curr.path;

			int[][] moves = getMoves(m, r, c, currR, currC);
			
			for(int i = 0; i < 4; i++) {
				int[] move = moves[i];
				if(visited[move[0]][move[1]]) {
					continue;
				}
				String newPath = String.format("%s%c", currP, DIRECTIONS.charAt(i));
				if(move[0] == endR && move[1] == endC) {
					return newPath;
				}
				visited[move[0]][move[1]] = true;
				toSearch.offer(new Query(move[0], move[1], newPath));
			}
		}
		
		return null;
	}

	private int[][] getMoves(char[][] m, int rMax, int cMax, int r, int c) {
		// Search in lexicographical order 'E', 'N', 'S', then 'W'
		int[][] ans = new int[4][2];

		// East
		int[] ansE = null;
		for(int i = c+1; i < cMax; i++) {
			if(m[r][i] == '#' || m[r][i] == 'E') {
				ansE = new int[] {r, i - (m[r][i] == '#' ? 1 : 0)};
				break;
			}
		}
		ans[0] = (ansE == null) ? (new int[] {r, cMax-1}) : ansE;

		// North
		int[] ansN = null;
		for(int i = r-1; i >= 0; i--) {
			if(m[i][c] == '#' || m[i][c] == 'E') {
				ansN = new int[] {i + (m[i][c] == '#' ? 1 : 0), c};
				break;
			}
		}
		ans[1] = (ansN == null) ? (new int[] {0, c}) : ansN;

		// South
		int[] ansS = null;
		for(int i = r+1; i < rMax; i++) {
			if(m[i][c] == '#' || m[i][c] == 'E') {
				ansS = new int[] {i - (m[i][c] == '#' ? 1 : 0), c};
				break;
			}
		}
		ans[2] = (ansS == null) ? (new int[] {rMax-1, c}) : ansS;

		// West
		int[] ansW = null;
		for(int i = c-1; i >= 0; i--) {
			if(m[r][i] == '#' || m[r][i] == 'E') {
				ansW = new int[] {r, i + (m[r][i] == '#' ? 1 : 0)};
				break;
			}
		}
		ans[3] = (ansW == null) ? (new int[] {r, 0}) : ansW;
		
		return ans;
	}
}
