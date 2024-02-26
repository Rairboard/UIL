import java.util.Scanner;
import static java.lang.System.*;

public class GoldCoins{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    String str = in.nextLine();
    if(str.toUpperCase().equals("GOLD COIN"))
        out.println("yes");
    else
        out.println("no");
  }
}