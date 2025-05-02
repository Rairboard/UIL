import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
public class Rod {
	public static void main(String[]args)throws Exception{
		new Rod().run();
	}
	public void run()throws Exception{
		Scanner file=new Scanner(new File("rod.dat"));
		int times=file.nextInt(), r = file.nextInt();
		file.nextLine();
		int[] prices = new int[r];
		for(int y = 0; y < r; y++)
			prices[y] = file.nextInt();
		while(times-->0) {
			int len = file.nextInt();
			int[] T = new int[len + 1];
	        for (int i = 1; i <= len; i++)
	            for (int j = 1; j <= i; j++) 
	                T[i] = Integer.max(T[i], prices[j - 1] + T[i - j]);
	        System.out.println(T[len]);
		}
	}
}
