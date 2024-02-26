import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
public class Lucky {
	public static void main(String[]args)throws Exception{
		new Lucky().run();
	}
	
	int[][] T;
	
	public int c(int i, int j)
    {
        if (i <= j) 
            return T[i][j];
        return 0;
    }
	
	public void run()throws Exception{
		Scanner file=new Scanner(new File("lucky.dat"));
		int times=file.nextInt();
		file.nextLine();
		while(times-->0) {
			String[] str = file.nextLine().trim().split("\\s+");
			int[] charms = new int[str.length];
			int sum = 0;
			for(int y = 0; y < str.length; y++) {
				charms[y] = Integer.parseInt(str[y]);
				sum += charms[y];
			}
			int n = charms.length, fin = 0;
	        if (n == 1) 
	            fin = charms[0];
	        if (n == 2) 
	            fin = Integer.max(charms[0], charms[1]);
	        else {
		        T = new int[n][n];
		        for (int iteration = 0; iteration < n; iteration++){
		            for (int i = 0, j = iteration; j < n; i++, j++){
		                int start = charms[i] + Integer.min(c(i + 2, j), c(i + 1, j - 1));
		                int end = charms[j] + Integer.min(c(i + 1, j - 1), c(i, j - 2));
		                T[i][j] = Integer.max(start, end);
		            }
		        }
		        fin = T[0][n - 1];
	        }
	        int diff = sum - fin;
	        if(diff >= fin)
	        	System.out.println("Scams R Us.");
	        else
	        	System.out.println("Those are my Lucky Charms: " + fin);
		}
	}
}
