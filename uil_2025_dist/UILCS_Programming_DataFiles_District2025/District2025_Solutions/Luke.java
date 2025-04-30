/*
 * UIL Computer Science 2025
 * District Packet Solution
 */

import java.io.*;
import java.util.*;

public class Luke {
	public static void main(String[]args)throws Exception{
		new Luke().run();
	}
	
	int V;
	
	public void run()throws Exception{
		Scanner file = new Scanner(new File("luke.dat"));
		int pipes = file.nextInt(), times = file.nextInt();
		ArrayList<String[]> a = new ArrayList<String[]>();
		ArrayList<Character> nodes = new ArrayList<Character>();
		file.nextLine();
		while(pipes-- > 0) {
			String[] st = file.nextLine().trim().split(" ");
			a.add(st);
			if(!nodes.contains(st[0]))
				nodes.add(st[0].charAt(0));
			if(!nodes.contains(st[1]))
					nodes.add(st[1].charAt(0));
		}
		V = nodes.size();
		int[][] mat = new int[V][V];
		for(String[] s : a) 
			mat[nodes.indexOf(s[0].charAt(0))][nodes.indexOf(s[1].charAt(0))] = Integer.parseInt(s[2]);
		while(times-->0) {
			int i = nodes.indexOf(file.next().charAt(0));
			int j = nodes.indexOf(file.next().charAt(0));
			System.out.println(fordFulkerson(mat, i, j));
			file.nextLine();
		}
		file.close();
	}
	
	boolean bfs(int rGraph[][], int s, int t, int parent[])
    {
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; ++i)
            visited[i] = false;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = true;
        parent[s] = -1;
        while (queue.size() != 0) {
            int u = queue.poll();
            for (int v = 0; v < V; v++) {
                if (visited[v] == false && rGraph[u][v] > 0) {
                    if (v == t) {
                        parent[v] = u;
                        return true;
                    }
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }
        return false;
    }

    int fordFulkerson(int graph[][], int s, int t)
    {
        int u, v;
        int rGraph[][] = new int[V][V];
        for (u = 0; u < V; u++)
            for (v = 0; v < V; v++)
                rGraph[u][v] = graph[u][v];
        int parent[] = new int[V];
        int max_flow = 0;
        while (bfs(rGraph, s, t, parent)) {
            int path_flow = Integer.MAX_VALUE;
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                path_flow = Math.min(path_flow, rGraph[u][v]);
            }
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                rGraph[u][v] -= path_flow;
                rGraph[v][u] += path_flow;
            }
            max_flow += path_flow;
        }
        return max_flow;
    }
	
}
