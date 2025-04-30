import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gopher {
	public static void main(String[] args) throws IOException {
		new Gopher().run();
	}

	private char[][][] board;

	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("Gopher/gopher.dat"));
		PrintWriter out = new PrintWriter(new File("Gopher/gopher.out"));

		int n = Integer.parseInt(file.readLine());
		while(n-->0) {
			StringTokenizer st = new StringTokenizer(file.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			board = new char[2][R][C];
			int[] h = new int[2];
			for(int i = 0; i < R; i++) {
				board[0][i] = file.readLine().toCharArray();
				for(int j = 0; j < C; j++) {
					if(board[0][i][j] == 'H') {
						h[0] = i;
						h[1] = j;
					} 
				}
			}
			for(int i = 0; i < R; i++) {
				board[1][i] = file.readLine().toCharArray();
			}
			int ans = solve(h, R, C);
			out.println(ans == -1 ? "Nowhere left to go-pher." : ans);
		}

		file.close();
		out.close();
	}

	private int[] dr = new int[] {0, -1, 0, 1};
	private int[] dc = new int[] {-1, 0, 1, 0};

	private int solve(int[] start, int R, int C) {
		boolean[][][] visited = new boolean[2][R][C];
		visited[0][start[0]][start[1]] = true;

		Queue<int[]> toSearch = new LinkedList<int[]>();
		toSearch.offer(new int[] {0, start[0], start[1], 0});
		while(!toSearch.isEmpty()) {
			int[] curr = toSearch.poll();
			int l = curr[0];
			int r = curr[1];
			int c = curr[2];

			for(int i = 0; i < 4; i++) {
				int newR = r + dr[i];
				int newC = c + dc[i];
				if(inRange(newR, newC, R, C) && !visited[l][newR][newC]) {
					switch(board[l][newR][newC]) {
					case 'G': {
						return curr[3] + 1;
					}
					case '#': {
						continue;
					}
					default: {
						toSearch.offer(new int[] {l, newR, newC, curr[3]+1});
						visited[l][newR][newC] = true;
					}
					}
				}
			}
			if(board[l][r][c] == 'O' && !visited[l ^ 1][r][c]) {
				toSearch.offer(new int[] {l ^ 1, r, c, curr[3]});
				visited[l ^ 1][r][c] = true;
			}
		}

		return -1;
	}

	private boolean inRange(int r, int c, int R, int C) {
		return 0 <= r && r < R && 0 <= c && c < C;
	}
}
