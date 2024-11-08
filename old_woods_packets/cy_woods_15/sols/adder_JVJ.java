import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;
public class JVJ_adder
{
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("adderj.dat"));
		int times = file.nextInt(); 
		file.nextLine();
		for(int asdf = 0; asdf<times; asdf++)
		{
			int block = file.nextInt();
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int x = 0; x < block; x++)
			{
				int next = file.nextInt();
				list.add(next);
			}
			int temp = file.nextInt();
			if (hateMethods(0, list, temp))
			{
				System.out.println("Yes.");
			}
			else
			{
				System.out.println("Not Possible.");
			}
		}
	}
	public boolean hateMethods(int spot, ArrayList<Integer> numbers, int fav) {
		if (spot >= numbers.size())
		{
    		if(fav == 0)
    		{
    			return true;
    		}
    		else
    		{
    			return false;
    		}
  		} 
		return hateMethods(spot + 1, numbers, fav) || hateMethods(spot + 1, numbers, fav - numbers.get(spot));
	}

	public static void main(String[] args) throws Exception
	{
		new JVJ_adder().run();
	}	
	
}