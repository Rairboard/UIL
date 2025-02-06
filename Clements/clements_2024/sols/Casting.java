import java.io.*;                                                                                                                  
import static java.lang.System.*;                                                                                                  
import java.lang.*;                                                                                                                
import java.util.*;                                                                                                                
import java.math.*;                                                                                                                
import java.text.*;                                                                                                                
public class Casting {                                                                                                            
	public static void main(String[]args)throws Exception{                                                                         
		new Casting().run();                                                                                                      
	}     
	
	static int max(int a, int b) { return (a > b) ? a : b; }
	
	public void run()throws Exception{                                                                                             
		Scanner file = new Scanner(new File("casting.dat"));                                                                      
		int times = file.nextInt();                                                                                                
		file.nextLine();                                                                                                           
		while(times-- > 0) {                                                                                                       
			int m = file.nextInt(), amt = file.nextInt();
			file.nextLine();
			int[] vals = new int[m], weights = new int[m];
			String[] v = file.nextLine().trim().split("\\s+");
			String[] w = file.nextLine().trim().split("\\s+");
			for(int i = 0; i < m; i++) {
				vals[i] = Integer.parseInt(v[i]);
				weights[i] = Integer.parseInt(w[i]);
			}
			int[][] dp = new int[m + 1][amt + 1];
			for(int i = 0; i <= m; i++) {
				for(int j = 0; j <= amt; j++) {
					if (i == 0 || j == 0)
	                    dp[i][j] = 0;
	                else if (weights[i - 1] <= j)
	                    dp[i][j] = max(vals[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i - 1][j]);
	                else
	                    dp[i][j] = dp[i - 1][j];
				}
			}
			System.out.println(dp[m][amt]);
		}                                                                                                                          
	}                                                                                                                              
}                                                                                                                                  
                                                                                                                                   