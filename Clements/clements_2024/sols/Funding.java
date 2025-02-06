import java.io.*;                                                                                                                  
import static java.lang.System.*;                                                                                                  
import java.lang.*;                                                                                                                
import java.util.*;                                                                                                                
import java.math.*;                                                                                                                
import java.text.*;                                                                                                                
public class Funding {                                                                                                            
	public static void main(String[]args)throws Exception{                                                                         
		new Funding().run();                                                                                                      
	}                                                                                                                              
	public void run()throws Exception{                                                                                             
		Scanner file = new Scanner(new File("funding.dat"));                                                                      
		int times = file.nextInt();                                                                                                
		file.nextLine();                                                                                                           
		while(times-- > 0) {                                                                                                       
			 int m = file.nextInt(), a = file.nextInt();
			 file.nextLine();
			 boolean[] dp = new boolean[a + 1];
			 String[] st = file.nextLine().trim().split("\\s+");
			 int[] coins = new int[m];
			 for(int i = 0; i < m; i++)
				 coins[i] = Integer.parseInt(st[i]);
			 dp[0] = true;
			 for(int coin:coins)
			 	for(int i = a; i >= 0; i--)
					 if(i - coin >= 0 && dp[i - coin])
						 dp[i] = true;
			 //System.out.println(Arrays.toString(dp));
			 System.out.println(dp[a]? "Put the money in the bag.": "We're gonna need a bigger loan.");
		}                                                                                                                          
	}                                                                                                                              
}                                                                                                                                  
                                                                                                                                   