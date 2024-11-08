import java.util.*;

public class DP_2
{

   public static int fibo2(int n)
   {
      int[] table = new int[n + 1];
      for (int i = 0; i < table.length; i++)
      {
         if (i == 0)
            table[i] = 0;
         else if (i == 1)
            table[i] = 1;
         else
            table[i] = table[i - 2] + table[i - 1];
      }
      return table[n];
   }

   public static void main(String[] args)
   {
      //which number in the fibonacci sequence do you want?
      //1 1 2 3 5 8 13 21 34 . . .
      System.out.println( fibo2(3) );          //outs 2
      System.out.println( fibo2(5) );          //outs 5
      System.out.println( fibo2(7) );          //outs 13
   }
}
