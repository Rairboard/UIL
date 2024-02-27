/*
 *UIL Computer Science 2020
 *Region Packet Solution
 */
import java.io.*;
import java.util.*;
import java.awt.Point;

public class Guozhi {
    static String directions = "SWNE";
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("guozhi.dat"));
        int T = scan.nextInt();
        assert 1 <= T && T <= 20;

        for (int caseNum = 1; caseNum <= T; caseNum++) {
            System.out.printf("Case #%d: %d%n", caseNum, solve(scan));
        }
    }

    private static int solve(Scanner scan) {
        int R = scan.nextInt();
        int C = scan.nextInt();
        assert 1 <= R * C && R * C <= 1000;
        char[][] grid = new char[R][C];
        Point start = null, end = null;
        boolean[][][] blocked = new boolean[4][R][C];
        for (int i = 0; i < R; i++) {
            grid[i] = scan.next().toCharArray();
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 'G') {
                    start = new Point(i, j);
                    grid[i][j] = '.';
                } else if (grid[i][j] == 'H') {
                    end = new Point(i, j);
                    grid[i][j] = '#';
                } else if (grid[i][j] == '#') {
                    for (int t = 0; t < 4; t++) {
                        blocked[t][i][j] = true;
                    }
                } else {
                    // make sure cell is valid
                    assert grid[i][j] == '.' || directions.indexOf(grid[i][j]) != -1;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int d = directions.indexOf(grid[i][j]);
                if (d >= 0) {
                    for (int t = 0; t < 4; ++t, d = (d + 1) % 4) {
                        int cx = i;
                        int cy = j;
                        while (inBounds(grid, cx, cy) && grid[cx][cy] != '#') {
                            blocked[t][cx][cy] = true;
                            cx += dx[d];
                            cy += dy[d];
                        }
                    }
                }
            }
        }

        assert start != null;
        assert end != null;

        int[][][] dist = new int[4][R][C];
        for (int[][] mat : dist) {
            for (int[] row : mat) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
        }

        Queue<State> q = new LinkedList<>();
        if (!blocked[0][start.x][start.y]) {
            dist[0][start.x][start.y] = 0;
            q.add(new State(0, start.x, start.y));
        }

        while (!q.isEmpty()) {
            State s = q.poll();
            int nt = (s.t + 1) % 4;

            // stay in place
            if (!blocked[nt][s.x][s.y] && dist[nt][s.x][s.y] == Integer.MAX_VALUE) {
                dist[nt][s.x][s.y] = dist[s.t][s.x][s.y] + 1;
                q.add(new State(nt, s.x, s.y));
            }
            // move
            for (int d = 0; d < 4; d++) {
                int nx = s.x + dx[d];
                int ny = s.y + dy[d];
                if (inBounds(grid, nx, ny) && !blocked[nt][nx][ny] && dist[nt][nx][ny] == Integer.MAX_VALUE) {
                    dist[nt][nx][ny] = dist[s.t][s.x][s.y] + 1;
                    q.add(new State(nt, nx, ny));
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int t = 0; t < 4; t++) {
            ans = Math.min(ans, dist[t][end.x][end.y]);
        }

        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

    private static boolean inBounds(char[][] grid, int x, int y) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[x].length;
    }

    static class State {
        int t, x, y;
        State(int t, int x, int y) {
            this.t = t;
            this.x = x;
            this.y = y;
        }
    }
}
