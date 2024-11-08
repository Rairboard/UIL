import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import static java.lang.System.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            double c = sc.nextDouble();
            out.printf("%.2f%n", a * a / Math.sqrt(b) + c);
        }
    }
}
