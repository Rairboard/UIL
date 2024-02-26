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
import java.util.regex.Pattern.*;


class pandorasBox
{
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("pandorasbox.dat"));
	beingAwesome:
		for(int zz = 0;true;zz++)
		{
			int start = file.nextInt();
			int goal = file.nextInt();
			int e = file.nextInt();
			int[] ints = new int[10000];
			Arrays.fill(ints,Integer.MAX_VALUE);
			boolean[] shad = new boolean[10000];
			if(start==goal&&goal==e&&e==0)
				return;
			int[] buttons = new int[e];
			for(int i = 0;i<buttons.length;i++)
				buttons[i] = file.nextInt();
			ints[start] = 0;
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(start);
			while(!q.isEmpty())
			{
				int i = q.poll();
				int n = ints[i];	
				if(i==goal)
				{
					System.out.printf("Case %d: %d%n",zz+1,n);
					continue beingAwesome;
				}
				for(int a:buttons)
				{
					int b = (i+a)%10000;
					if(ints[b]>=n+1&&!shad[b])
					{
						shad[b] = true;
						ints[b] = n+1;
						q.add(b);
					}
				}
			}
			System.out.printf("Case %d: Cannot be opened%n",zz+1);		
		}
	}
	public static void main(String[] args)throws Exception
	{
		//testGen(4,11);
		pandorasBox a=new pandorasBox();
		a.run();
	}
}