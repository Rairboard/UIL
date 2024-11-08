import java.util.*;
import java.io.*;

public class Territorial {
  static char [][] grid; static boolean [][] disputed;
  static int [][][] visited; static int N, M;
  static final int [] dx = new int[] {-1, 1, 0, 0};
  static final int [] dy = new int[] {0, 0, -1, 1};
  static LinkedList<Integer> queue = new LinkedList<Integer> ();
  
  public static void main(String [] args) throws IOException {
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  
	  StringTokenizer st = new StringTokenizer(br.readLine());
	  N = Integer.parseInt(st.nextToken());
	  M = Integer.parseInt(st.nextToken());
	  grid = new char[N][M];
	  for (int i = 0; i < N; i++) grid[i] = br.readLine().toCharArray();
	  
	  System.out.println(disputes());
	  
	  br.close();
  }
  
  public static int disputes() {
    disputed = new boolean[N][M]; visited = new int[N][M][2];
    LinkedList<int []> perimeter = new LinkedList<int []>();
    int component = 1;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (grid[i][j] != '#' && visited[i][j][0] == 0) floodFill(i, j, component ++);
        if (grid[i][j] != '#' && isPerimeter(i, j)) perimeter.add(new int[] {i, j, visited[i][j][0], 0});
      }
    } 
    
    @SuppressWarnings("unchecked")
    HashSet<Integer> [] disputedSet = new HashSet[component];
    for (int i = 0; i < component; i++) disputedSet[i] = new HashSet<Integer> ();
    
    int [][] territory = new int [component][2]; // i: [undisputed, disputed]
    while (!perimeter.isEmpty()) {
      int [] cell = perimeter.poll();
      int row = cell[0], col = cell[1], comp = cell[2], dist = cell[3];
      for (int i = 0; i < 4; i++) {
        int r = row + dx[i], c = col + dy[i];
        if (isValid(r, c)) {
          if (visited[r][c][0] == 0) {
            visited[r][c][0] = comp; visited[r][c][1] = dist + 1;
            perimeter.add(new int[] {r, c, comp, dist + 1});
          } else if (visited[r][c][1] == dist + 1 && visited[r][c][0] != comp && !disputedSet[comp].contains(r * 1000 + c)) { 
            disputed[r][c] = true; territory[comp][1] ++; disputedSet[comp].add(r * 1000 + c);
            perimeter.add(new int[] {r, c, comp, dist + 1});          
          }
        }
      }
    } 
    
    int count = 0;
    for (int i = 0; i < N; i++) {
    	for (int j = 0; j < M; j++) {
    		if (!disputed[i][j]) count ++;
    	}
    } return count;
  }
  public static boolean isValid(int r, int c) { return r >= 0 && c >= 0 && r < N && c < M; }
  public static boolean isPerimeter(int row, int col) {
    for (int i = 0; i < 4; i++) {
      int r = row + dx[i], c = col + dy[i];
      if (!isValid(r, c) || grid[r][c] == '#') return true;
    } return false;
  }
  public static void floodFill(int row, int col, int component) {
    queue.add(row * 1000 + col); visited[row][col][0] = component;
    while (!queue.isEmpty()) {
      int front = queue.poll(); row = front / 1000; col = front % 1000; 
      for (int i = 0; i < 4; i++) {
        int r = row + dx[i], c = col + dy[i];
        if (isValid(r, c) && visited[r][c][0] == 0 && grid[r][c] != '#') {
          visited[r][c][0] = component; queue.add(r * 1000 + c);
        }
      }
    }
  }
}