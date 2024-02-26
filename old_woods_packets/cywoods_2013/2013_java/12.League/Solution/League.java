import java.util.*;
import java.io.*;

public class League{
	public static void main(String[] args) throws Exception{
		new League().run();
	}
	public void run() throws Exception{
		Scanner file = new Scanner(new File("league.dat"));
		int times = file.nextInt(); file.nextLine();
		for(int asdf = 0; asdf<times; asdf++){
			int n = file.nextInt();
			int M = 5, N = 2+M+n, S = 0, E = N-1, P = 1, R = n+1;
			int[][] m = new int[N][N];
			for(int i = 0; i<M; i++)
				m[R+i][E] = file.nextInt();
			for(int i = 0; i<n; i++){
				m[S][P+i]++;
				for(char c : file.next().toCharArray())
					m[P+i][R+c-'A']++;
			}
			int f = 0;
			L: while(true){
				boolean[] v = new boolean[N];
				Queue<Object[]> que = new LinkedList<Object[]>();
				que.add(new Object[]{S, null});
				while(!que.isEmpty()){
					Object[] ar = que.remove();
					int c = (Integer)ar[0];
					if( c == E){
						f++;
						while(ar[1] != null){
							ar = (Object[])ar[1];
							int p = (Integer)ar[0];
							m[p][c]--;
							m[c][p]++;
							c = p;
						}
						continue L;
					}
					for(int i = 0; i<N; i++)
						if( !v[i] && m[c][i] > 0){
							v[i] = true;
							que.add(new Object[]{i, ar});
						}
				}
				break;
			}
			System.out.println(f);
		}
	}
}