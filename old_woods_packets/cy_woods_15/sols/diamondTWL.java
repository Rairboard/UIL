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


class diamond
{
	//instance variables go here
	long[][] mat;
	long num;
	public void run()throws Exception
	{
		Scanner file = new Scanner(new File("diamond.in"));
		
		long times = file.nextLong();
		
		file.nextLine();
		
		for(long asdf = 0; asdf < times; asdf++)
		{
			num = file.nextLong();
			mat = new long[(int)num*2-1][(int)num*2-1];
			
			solve(mat.length/2,mat[0].length/2,num-1);
			
			for(long[] r : mat)
			{
				for(long c : r)
				{
					if(c == 0)
					{
						String s = "";
						while(s.length() < ("" + (long)Math.pow(num,num-1)).length()+1)
						{
							s += " ";
						}
						System.out.print(s);
						continue;
					}
					String s = "" + c;
					while(s.length() < ("" + (long)Math.pow(num,num-1)).length()+1)
					{
						s += " ";
					}
					System.out.print(s);
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	
	void solve(long r, long c, long exp)
	{
		
		if(r >= 0 && c >= 0 && r < mat.length &&  c < mat[(int)r].length && mat[(int)r][(int)c] < ((long)Math.pow(num,exp)))
		{
			mat[(int)r][(int)c] = (long)Math.pow(num,exp--);
			solve(r,c+1,exp);
			solve(r,c-1,exp);
			solve(r-1,c,exp);
			solve(r+1,c,exp);
		}
		
	}

	public static void main(String[] args)throws Exception
	{
		diamond a=new diamond();
		a.run();
	}
}