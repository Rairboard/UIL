import java.util.*;
import java.io.*;

public class Boats {
  public static void main(String[] args) throws IOException {
    Scanner kb=new Scanner(new File("boats.in"));
    int t=kb.nextInt();
    for(int g=0; g<t; g++)
    {
      int n=kb.nextInt(), m=kb.nextInt();
      ArrayList[] edges=new ArrayList [n];//adjacency list
      long[] distance=new long[n];//distance to source
      Arrays.fill(distance, 987654321123456789L);//infinity
      distance[0]=0;//source is node 0
      for(int i=0; i<n; i++)
      {
        edges[i]=new ArrayList<Edge>();
      }
      for(int i=0; i<m; i++)
      {
        int u=kb.nextInt();
        int v=kb.nextInt();
        int w=kb.nextInt();
        u--;
        v--;
        edges[u].add(new Edge(w, v));
        edges[v].add(new Edge(w, u));
      }
      PriorityQueue<Edge> nodes=new PriorityQueue<>();//distance to source, node number
      nodes.offer(new Edge(0, 0));//distance from source to itself is 0
      while(!nodes.isEmpty())
      {
        long dist=nodes.peek().length;
        int node=nodes.peek().node;
        nodes.poll();
        if(dist!=distance[node])//there exists a shorter path to the node
          continue;
        if(node==n-1)//we've found the shortest path
          break;
        for(Edge e: (ArrayList<Edge>)(edges[node]))//relax the edges of node
        {
          if(dist+e.length<distance[e.node])
          {
            distance[e.node]=dist+e.length;
            nodes.offer(new Edge(distance[e.node], e.node));
          }
        }
      }
      System.out.println(distance[n-1]);
    }
  }

  static class Edge implements Comparable<Edge>
  {
    long length;
    int node;

    public Edge(long l, int n)
    {
      length=l; 
      node=n;
    }
    
    public int compareTo(Edge o)
    {
      if(length==o.length)
        return node-o.node;
      return (int)(length-o.length);
    }
  }
}