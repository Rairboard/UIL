/*
 * UIL Computer Science 2025
 * District Packet Solution
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Erbatur {
    public static void main(String[] args) throws IOException {
        new Erbatur().run();
    }

    private void run() throws IOException {
        BufferedReader file = new BufferedReader(new FileReader("erbatur.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        solve(file, out);

        file.close();
        out.close();
    }

    public void solve(BufferedReader file, PrintWriter out) throws IOException {
    	int t = Integer.parseInt(file.readLine());
    	while(t-->0) {
    		StringTokenizer st = new StringTokenizer(file.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            boolean[][] isLand = new boolean[n+2][m+2];
            for(int i = 1; i <= n; i++) {
                char[] line = file.readLine().toCharArray();
                for(int j = 1; j <= m; j++) {
                    isLand[i][j] = line[j-1] == '#';
                }
            }
            
            out.println(bfs(isLand, n+2, m+2));
    	}
    }
    
    private static final int[] DR = new int[] {0, -1, 0, 1};
    private static final int[] DC = new int[] {-1, 0, 1, 0};
    
    private int bfs(boolean[][] isLand, int n, int m) {
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        
        Queue<Integer> toSearch = new ArrayDeque<Integer>();
        toSearch.offer(0);
        
        int coastLength = 0;
        while(!toSearch.isEmpty()) {
            int curr = toSearch.poll();
            int r = curr / m;
            int c = curr % m;
            
            for(int i = 0; i < 4; i++) {
                int newR = r + DR[i];
                int newC = c + DC[i];
                if(inBounds(newR, newC, n, m) && !visited[newR][newC]) {
                    if(isLand[newR][newC]) {
                        coastLength++;
                    } else {
                        toSearch.offer(newR * m + newC);
                        visited[newR][newC] = true;
                    }
                }
            }
        }
        
        return coastLength;
    }
    
    private boolean inBounds(int r, int c, int maxR, int maxC) {
        return 0 <= r && r < maxR && 0 <= c && c < maxC;
    }
}
