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


public class Signs
{
	public void run()throws Exception
	{
		Scanner file = new Scanner(new File("Signs.dat"));
		int zz = file.nextInt();file.nextLine();
	loop:
		for(int z = 0;z<zz;z++)
		{
			int goal = file.nextInt();
			Queue<Integer> que = new LinkedList<Integer>();
			que.add(1);
			int cnt = 1;
			while(true)
			{
				cnt++;
				HashSet<Integer> dump = new HashSet<Integer>();
				while(!que.isEmpty())
				{
					int n = que.poll();
					if(n==goal)
					{
						System.out.println(cnt-1);
						continue loop;
					}
					dump.add(n+cnt);
					dump.add(n-cnt);
				}
				que.addAll(dump);
			}
		}
	}

	public static void main(String[] args)throws Exception
	{
		Signs a=new Signs();
		a.run();
	}

}