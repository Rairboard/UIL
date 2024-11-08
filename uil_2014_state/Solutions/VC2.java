import java.io.*;
import java.util.*;

public class VC2 {
	static Pair[][] prev;
	static int[][][] VCs;
	static boolean[][] done;
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("vc2.dat"));
		int T = Integer.parseInt(in.nextLine().trim());
		while (T-- > 0) {
			int P = Integer.parseInt(in.nextLine().trim());
			ArrayList<String>[] processes = new ArrayList[P];
			HashMap<Integer, Pair> senders = new HashMap<Integer, Pair>();// message number to sender process/num
			for(int i = 0; i < P; i++) {
				StringTokenizer st = new StringTokenizer(in.nextLine().trim());
				processes[i] = new ArrayList<String>();
				int evnum = 0;
				while (st.hasMoreTokens()) {
					evnum++;
					String e = st.nextToken();
					processes[i].add(e);
					if (e.charAt(0) == 'S') {
						senders.put(Integer.parseInt(e.substring(1)), new Pair(i, evnum));
					}
				}
			}
			prev = new Pair[P][];
			for (int i = 0; i < P; i++) prev[i] = new Pair[processes[i].size() + 1];
			
			for (int i = 0; i < P; i++) {
				for (int j = 1; j < prev[i].length; j++) {
					prev[i][j] = null;
					String e = processes[i].get(j-1);
					if (e.charAt(0) == 'R') {
						prev[i][j] = senders.get(Integer.parseInt(e.substring(1)));
					}
				}
			}

			VCs = new int[P][][];
			for (int i = 0; i < P; i++) VCs[i] = new int[processes[i].size() + 1][P];
			done = new boolean[P][];
			for (int i = 0; i < P; i++) done[i] = new boolean[processes[i].size() + 1];
			for (int i = 0; i < P; i++) {
				done[i][0] = true;
				VCs[i][0] = new int[P];
			}
			int N = Integer.parseInt(in.nextLine().trim());
			while (N-- > 0) {
				StringTokenizer st = new StringTokenizer(in.nextLine().trim());
				int p = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());
				int[] vc = getVC(p, k, P);
				System.out.print('[');
				System.out.print(vc[0]);
				for (int i = 1; i < P; i++) {
					System.out.print(',');
					System.out.print(vc[i]);
				}
				System.out.println(']');
			}
		}
	}
	static int[] getVC(int p, int k, int P) {
		if (done[p][k])
			return VCs[p][k];
		int[] vc = new int[P];
		int[] l = getVC(p, k-1, P);
		if (prev[p][k] == null) {
			for (int i = 0; i < P; i++) {
				vc[i] = l[i];
			}
		} else {
			int[] s = getVC(prev[p][k].a, prev[p][k].b, P);
			for (int i = 0; i < P; i++) {
				vc[i] = Math.max(l[i], s[i]);
			}
		}
		vc[p]++;
		VCs[p][k] = vc;
		done[p][k] = true;
		return vc;
	}
	static class Pair {
		int a, b;
		Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
		public String toString() {
			return "(" + a + "," + b + ")";
		}
	}
}