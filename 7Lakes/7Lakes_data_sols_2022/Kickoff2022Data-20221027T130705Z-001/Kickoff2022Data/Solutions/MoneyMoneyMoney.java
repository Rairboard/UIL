import java.util.Scanner;

public class MoneyMoneyMoney
{
    public static void main(String[] args)
    {
        //1000, 100, 50, 20, 10, 5, 1
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            String ans = "";
            
            ans += x / 1000;
            x %= 1000;
            ans += ":";
            
            ans += x / 100;
            x %= 100;
            ans += ":";
            
            ans += x / 50;
            x %= 50;
            ans += ":";
            
            ans += x / 20;
            x %= 20;
            ans += ":";
            
            ans += x / 10;
            x %= 10;
            ans += ":";
            
            ans += x / 5;
            x %= 5;
            ans += ":";
            
            System.out.println(ans + x);
        }
    }
}
