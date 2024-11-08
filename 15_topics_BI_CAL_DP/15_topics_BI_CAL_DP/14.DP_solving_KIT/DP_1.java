import java.util.*;

public class DP_1
{
   public static int fibo1(int n)
   {
      if (n == 0)
         return 0;
      if (n == 1)
         return 1;
      return fibo1(n - 1) + fibo1(n - 2);
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
