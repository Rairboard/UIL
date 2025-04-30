import static java.lang.System.out;
import java.io.*;
import java.util.Scanner;

public class Kai {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("kai.dat"));
        String b1 = " _  ";
        String b2 = "(*> ";
        String b3 = "//\\ ";
        String b4 = "V_/_";

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            out.print(b1);
        }
        out.println();
        for (int i = 0; i < n; i++) {
            out.print(b2);
        }
        out.println();
        for (int i = 0; i < n; i++) {
            out.print(b3);
        }
        out.println();
        for (int i = 0; i < n; i++) {
            out.print(b4);
        }
        out.println();

    }
}
