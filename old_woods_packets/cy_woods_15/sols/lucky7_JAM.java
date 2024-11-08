import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class lucky7
{
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("judges.dat"));
		int times = file.nextInt(); 
		file.nextLine();
		
		for(int asdf = 0; asdf<times; asdf++)
		{
			int cnt = 0;
			int y = file.nextInt();
			for(int x = 0; x < y; x++)
			{
				int count = 0;
				for(int z = 0; z < 3; z++)
				{
					int u = file.nextInt();
					if(u == 7)
						count = count + 1;
				}
				if(count == 3)
				{
					cnt = cnt + 1;
				}
			}
			if(cnt >= 1)
			{
				System.out.println("winner");
			}
			else
			{
				System.out.println("loser");
			}
		}
	}

	public static void main(String[] args) throws Exception
	{
		new lucky7().run();
	}	
	
}