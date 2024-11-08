import java.io.*;
import java.util.*;

public class Crossing {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(new File("crossing.in"));
     // Scanner in = new Scanner(System.in);
    int cases = in.nextInt();
    for(int tc = 0; tc < cases; tc++) {
      int n = in.nextInt();
      int c = in.nextInt();

      int[] weights = new int[n];
      int[] expense = new int[n];

      for(int i = 0; i < n; i++) {
        in.next();
        weights[i] = in.nextInt();
        expense[i] = in.nextInt();
      }

      int[] dp = new int[c+1];
      for(int i = 1; i <= c; i++) {
        for(int j = 0; j < n; j++) {
          if(i >= weights[j])
            dp[i] = Math.max(dp[i],dp[i-weights[j]] + expense[j]);
        }
      }

      System.out.println(dp[c]);
    }
  }
}