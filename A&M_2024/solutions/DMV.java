import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
public class DMV {
	public static void main(String[]args)throws Exception{
		new DMV().run();
	}
    static int min(int x, int y, int z){
        if (x <= y && x <= z)
            return x;
        if (y <= x && y <= z)
            return y;
        else
            return z;
    }
	public void run()throws Exception{
		Scanner file=new Scanner(new File("dmv.dat"));
		while(file.hasNext()) {
            String s1 = file.nextLine().trim();
            String s2 = file.nextLine().trim();
            int m = s1.length(), n = s2.length();
			int dp[][] = new int[m + 1][n + 1];
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i == 0)
                        dp[i][j] = j; 
                    else if (j == 0)
                        dp[i][j] = i; 
                    else if (s1.charAt(i - 1)
                            == s2.charAt(j - 1))
                        dp[i][j] = dp[i - 1][j - 1];
                    else
                        dp[i][j]
                            = 1
                            + min(
                                dp[i][j - 1], 
                                dp[i - 1][j], 
                                dp[i - 1][j - 1]); 
                }
            }
            System.out.println(dp[m][n]);
		}
	}
}

