import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import static java.lang.System.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String s = sc.nextLine();
            s = s.toLowerCase();
            String x = "argh matey";
            boolean good = true;
            for (int i = 0; i < s.length(); i++) {
                if (!x.contains("" + s.charAt(i))) {
                    good = false;
                    break;
                }
            }
            if (good) out.println("Yes");
            else out.println("No");
        }
    }
}
