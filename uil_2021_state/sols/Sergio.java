import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Sergio
{
	public static class graph
	{
		int V;
		int[][] adjMatrix;

		public graph(int numVert)
		{
			V=numVert;
			adjMatrix=new int[numVert][numVert];
		}

		public void addEdge(int src, int dest)
		{
			adjMatrix[src][dest]=1;
		}

		private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack)  
	    {     
	        if (recStack[i]) 
	            return true; 
	  
	        if (visited[i]) 
	            return false; 
	              
	        visited[i] = true; 
	  
	        recStack[i] = true; 

	        int[] children= adjMatrix[i]; 
	        for (int loopC=0;loopC<V;loopC++)
	        { 
	            if (children[loopC]==1&&isCyclicUtil(loopC, visited, recStack)) 
	                return true; 
	        }         
	        recStack[i] = false; 
	  
	        return false; 
	    }

		public boolean isCyclic()
		{
			boolean[] visited = new boolean[V]; 
	        boolean[] recStack = new boolean[V]; 
	           
	        for (int i = 0; i < V; i++) 
	            if (isCyclicUtil(i, visited, recStack)) 
	                return true; 
	  
	        return false;
		}
	}

	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner s = new Scanner(new File("sergio.dat"));
        
        int N = s.nextInt();
        s.nextLine();
        for ( int n = 0; n < N; n++ )
        {
        	int numVert=s.nextInt();
        	int numEdges=s.nextInt();

			graph myGraph=new graph(numVert);

			for(int loopC=0;loopC<numEdges;loopC++)
			{
				int x=s.nextInt();
				int y=s.nextInt();
				myGraph.addEdge(x,y);
			}

			System.out.println(myGraph.isCyclic()? "Cycle" : "No cycle");
		}
	}
}