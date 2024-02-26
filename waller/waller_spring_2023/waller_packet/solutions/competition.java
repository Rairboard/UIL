import java.util.*;
import java.io.*;

public class competition {
    public void run() throws Exception {
        Scanner bob = new Scanner(new File("competition.dat"));
        // Scanner bob = new Scanner(System.in);
        int n = bob.nextInt();
        bob.nextLine();
        while(n-->0) {
            String[] line = bob.nextLine().split(" ");
            int[] lifts = new int[line.length];
            for(int i =0 ; i < line.length; i++) {
                lifts[i] = Integer.parseInt(line[i]);
            }
            int[] dp = new int[lifts.length];
            Arrays.fill(dp,1);
            //LIS FORMULA MEMORIZE THIS !!!!
            for(int i = 1; i < dp.length; i++) {
                for(int j = 0; j < i; j++) {
                    if(lifts[i] >= lifts[j] && dp[i] < dp[j]+1) {
                        dp[i] = dp[j]+1;
                    }
                }
            }
            int max = 0;
            for(int i =0 ; i < dp.length; i++) {
                max = Math.max(max,dp[i]);
            }
            System.out.println(dp.length-max);
        }
    }

    public static void main(String[] args) throws Exception {
        new competition().run();
    }
}
