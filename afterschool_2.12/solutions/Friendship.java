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


public class Friendship
{
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("friendship.dat"));
		int reps = file.nextInt();
		file.nextLine();
		for(int q=0; q<reps; q++)
		{
			int[] nums = new int[5];
			
			for(int a = 0; a < 5; a++) {
				nums[a] = file.nextInt();
			}
			
			int max = 0;
			
			for(int a = 0; a < 5; a++) {
				if(nums[a]>max) {
					max=nums[a];
				}
			}
			System.out.println("Hottest Temp – "+max);
		}
	}

	public static void main(String[] args)throws Exception
	{
		Friendship a=new Friendship();
		a.run();
	}

}