/*
 * UIL Computer Science 2025
 * Invitational B Packet Solution
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Sarac {
	public static void main(String[] args) throws IOException {
		new Sarac().run();
	}

	private void run() throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("sarac.dat"));
		PrintWriter out = new PrintWriter(System.out);

		solve(file, out);

		file.close();
		out.close();
	}

	public void solve(BufferedReader file, PrintWriter out) throws IOException {
		int n = Integer.parseInt(file.readLine());
		while(n-->0) {
			StringTokenizer st = new StringTokenizer(file.readLine());
			
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			HashMap<String, HashSet<String>> G = new HashMap<String, HashSet<String>>();
			st = new StringTokenizer(file.readLine());
			for(int i = 0; i < V; i++) {
				String v = st.nextToken();
				G.put(v, new HashSet<String>());
			}
			
			st = new StringTokenizer(file.readLine());
			for(int i = 0; i < E; i++) {
				String[] e = st.nextToken().split("->");
				G.get(e[0]).add(e[1]);
			}
			
			out.println(hasCycle(G) ? "Deadlock exists; not good..." : "Deadlock free; all is well");
		}
	}
	
	private boolean hasCycle(HashMap<String, HashSet<String>> G) {
		HashSet<String> visited = new HashSet<String>();
		HashSet<String> currPath = new HashSet<String>();
		
		for(String v : G.keySet()) {
			if(!visited.contains(v) && dfs(G, v, visited, currPath)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean dfs(HashMap<String, HashSet<String>> G, String u, HashSet<String> visited, HashSet<String> currPath) {
		if(!visited.contains(u)) {
			visited.add(u);
			currPath.add(u);
			
			for(String v : G.get(u)) {
				if(!visited.contains(v) && dfs(G, v, visited, currPath)) {
					return true;
				} else if(currPath.contains(v)) {
					return true;
				}
			}
		}
		
		currPath.remove(u);
		return false;
	}
}
