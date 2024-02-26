import java.io.*;
import java.util.*;
import java.math.*;

public class Kathleen {
	public static void main(String[] args) throws Exception {
		new Kathleen().run();
	}

	Scanner file;

	public void solve() {
		int n = Integer.parseInt(file.next().trim()), m = Integer.parseInt(file.nextLine().trim());
		Object[] c = Arrays.stream(file.nextLine().trim().split(" ")).toArray();
		HashMap<String, Integer> h = new HashMap<String, Integer>();
		for (int i = 0; i < n; ++i)
			h.put(c[i].toString(), i);
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; ++i)
			adj.add(new ArrayList<Integer>());
		for (int i = 0; i < m; ++i) {
			int x = h.get(file.next().trim()), y = h.get(file.next().trim());
			adj.get(x).add(y); adj.get(y).add(x);
		}
		boolean[] v = new boolean[n];
		int u = n;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		while (!q.isEmpty()) {
			int x = q.poll();
			if (v[x])
				continue;
			v[x] = true;
			--u;
			for (int y : adj.get(x))
				q.add(y);
		}
		System.out.println(u == 0 ? "Yes" : "No");
	}

	public void run() throws Exception {
		file = new Scanner(new File("kathleen.dat"));
		int t = Integer.parseInt(file.nextLine().trim());
		for (int i = 1; i <= t; ++i)
			solve();
		file.close();
	}
}