import java.io.*;
import java.util.*;
import static java.lang.System.*;
public class Treasure {

    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, 1, -1, 1, -1};
    static char[][] grid;
    static int[][] bombs;
    static ArrayList<Bomb> arr;
    static int n, m, L, S;
    static int starti, startj, endi, endj;

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(f.readLine());
        long a = System.currentTimeMillis();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());
            grid = new char[n][m];
            bombs = new int[n][m];
            arr = new ArrayList<>();
            starti = 0; startj = 0; endi = 0; endj = 0;
            for (int i = 0; i < n; i++) {
                String s = f.readLine();
                for (int j = 0; j < m; j++) {
                    grid[i][j] = s.charAt(j);
                    if (grid[i][j] == 'o') {
                        starti = i;
                        startj = j;
                    }
                    if (grid[i][j] == 'x') {
                        endi = i;
                        endj = j;
                    }
                }
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(f.readLine());
                for (int j = 0; j < m; j++) {
                    bombs[i][j] = Integer.parseInt(st.nextToken());
                    if (bombs[i][j] > 0) count++;
                }
            }
            addBombs();
            int l = 0;
            int r = count;
            while (l < r) {
                int mid = (l + r) / 2;
                if (works(mid) != -1) {
                    r = mid;
                }
                else {
                    l = mid + 1;
                }
            }
            int x = works(l);
            if (x == -1) {
                out.println("We cannot make it...");
            }
            else {
                if (x == 1) out.print("We can make it in 1 step with " + l + " bomb");
                else out.print("We can make it in " + x + " steps with " + l + " bomb");
                if (l != 1) out.println("s!");
                else out.println("!");
            }
        }
        f.close();
    }

    public static void addBombs() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (bombs[i][j] > 0) {
                    arr.add(new Bomb(i, j, bombs[i][j]));
                }
            }
        }
        Collections.sort(arr);
    }

    public static int works(int mid) {
        long x = System.currentTimeMillis();
        Stack<Bomb> pending = new Stack<>();
        Queue<Bomb> q = new LinkedList<>();
        for (int i = 0; i < mid; i++) {
            pending.add(arr.get(i));
        }
        Collections.sort(pending);
        boolean[][] visited = new boolean[n][m];
        if (!pending.isEmpty()) q.add(pending.pop());
        while (!q.isEmpty()) {
            while (!pending.isEmpty() && pending.peek().R == q.peek().R) {
                q.add(pending.pop());
            }
            Bomb b = q.poll();
            if (visited[b.i][b.j]) continue;
            visited[b.i][b.j] = true;
            for (int i = 0; i < 4; i++) {
                int ni = b.i + dx[i];
                int nj = b.j + dy[i];
                if (inRange(ni, nj) && b.R > 0) {
                    q.add(new Bomb(ni, nj, b.R - 1));
                }
            }
        }
        //System.out.println("Bomb: " + );
        int yes = getToTreasure(visited);
        return yes;
    }

    public static int getToTreasure(boolean[][] wall) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(starti, startj, 0, 0));
        boolean[][][] visited = new boolean[n][m][Math.max(L, S) + 1];
        while (!q.isEmpty()) {
            Node p = q.poll();
            if (visited[p.i][p.j][p.x]) continue;
            visited[p.i][p.j][p.x] = true;
            if (grid[p.i][p.j] == 'x') {
                return p.tot;
            }
            if (grid[p.i][p.j] == 'o') {
                for (int i = 0; i < dx.length; i++) {
                    int ni = p.i + dx[i];
                    int nj = p.j + dy[i];
                    if (inRange(ni, nj) && (grid[ni][nj] != '#' && grid[ni][nj] != '*' || wall[ni][nj]))
                        q.add(new Node(ni, nj, p.x, p.tot + 1));
                }
            }
            else if (grid[p.i][p.j] == ',' || grid[p.i][p.j] == '#') {
                if (p.x >= L) continue;
                for (int i = 0; i < dx.length; i++) {
                    int ni = p.i + dx[i];
                    int nj = p.j + dy[i];
                    if (inRange(ni, nj)) {
                        int nd = p.x + (grid[ni][nj] == ',' || grid[ni][nj] == '#' ? 1 : -p.x);
                        if ((grid[ni][nj] != '#' && grid[ni][nj] != '*' || wall[ni][nj]) && !visited[ni][nj][nd])
                            q.add(new Node(ni, nj, nd, p.tot + 1));
                    }
                }
            }
            else {
                if (p.x >= S) continue;
                for (int i = 0; i < dx.length; i++) {
                    int ni = p.i + dx[i];
                    int nj = p.j + dy[i];
                    if (inRange(ni, nj)) {
                        int nd = p.x + (grid[ni][nj] == ',' || grid[ni][nj] == '#' ? -p.x : 1);
                        if (inRange(ni, nj) && (grid[ni][nj] != '#' && grid[ni][nj] != '*' || wall[ni][nj]) && !visited[ni][nj][nd])
                            q.add(new Node(ni, nj, nd, p.tot + 1));
                    }
                }
            }
        }
        return -1;
    }

    public static boolean inRange(int i, int j) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }

    static class Bomb implements Comparable<Bomb> {
        int i, j, R;

        public Bomb(int a, int b, int c) {
            i = a;
            j = b;
            R = c;
        }

        public int compareTo(Bomb b) {
            if (b.R != R) return R - b.R;
            if (b.i != i) return i - b.i;
            return j - b.j;
        }

    }

    static class Node {

        int i, j, x, tot;

        public Node (int a, int b, int c, int d) {
            i = a;
            j = b;
            x = c;
            tot = d;
        }

    }

}
