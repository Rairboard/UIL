import java.io.*;
import java.util.*;
public class Civilization {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new File("civilization.in"));
		int cases = in.nextInt();
		
		for(int tc = 0; tc < cases; tc++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int k = in.nextInt();
			int e = in.nextInt();
			
			int[] mcgee = new int[m];
			int[][] graph = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				Arrays.fill(graph[i], Integer.MAX_VALUE/3);
				graph[i][i] = 0;
			}
			
			for(int i = 0; i < m; i++) {
				mcgee[i] = in.nextInt()-1;
			}
			
			for(int i = 0; i < e; i++) {
				int s = in.nextInt()-1;
				int d = in.nextInt()-1;
				int w = in.nextInt();
				graph[s][d] = graph[d][s] = w;
			}
			for(int i = 0; i < n; i++) {
				for(int s = 0; s < n; s++) {
					for(int d = 0; d < n; d++) {
						graph[s][d] = Math.min(graph[s][d],graph[s][i] + graph[i][d]);
					}
				}
			}
			
			for(int i = 0; i < n; i++) {
				boolean flag = false;
				for(int j = 0; j < m; j++) {
					if(graph[i][mcgee[j]] <= k) {
						System.out.printf("Village %d: All hail the holy city\n",i+1);
						flag = true;
						break;
					}
				}
				if(!flag)
					System.out.printf("Village %d: Let out the creepers\n",i+1);
			}
			System.out.println();
		}
	}
}
