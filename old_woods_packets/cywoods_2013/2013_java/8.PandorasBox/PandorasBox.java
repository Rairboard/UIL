import java.io.*;
import java.util.*;
import java.text.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Character.*;
import static java.util.Collections.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import java.math.BigInteger;


public class PandorasBox
{
	
	public void run()throws Exception
	{
		final int oo = 1000000000;
    	int[] button = new int[10];
   	 	int[] dist = new int[10000];
        Scanner file = new Scanner(new File("pandorasbox.dat"));
        int caso = 1;
        
        while(file.hasNextInt())
        {
            int X = file.nextInt();
            int Y = file.nextInt();
            int Z = file.nextInt();
            
            if ( X==0 && Y==0 && Z==0 ) break;
            
            for (int i=0; i<Z; i++)
            	 button[i] = file.nextInt();
            Arrays.fill( dist, oo );
            
            // BFS
            Queue< Integer > Q = new LinkedList<Integer>();
            Q.add(X);
            dist[X] = 0;
            while(Q.size() > 0)
            {
                int u = Q.poll();
                for (int i=0; i<Z; i++)
                {
                    int nu = (u + button[i]) % 10000;
                    if (dist[u]+1 < dist[nu])
                    {
                        dist[nu] = dist[u] + 1;
                        Q.add(nu);
                    }
                }
            }
            
            if (dist[Y] == oo) 
            	System.out.println("Case "+(caso++)+": Cannot be Opened");
            else 
            	System.out.println("Case "+(caso++)+": "+dist[Y]);
        }
	}
	
	public static void main(String[] args)throws Exception
	{
		PandorasBox a=new PandorasBox();
		a.run();
	}	
}