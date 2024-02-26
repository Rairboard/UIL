import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-- > 0) {
            int x = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (x <= a) out.println("Plastic");
            else if (x <= b) out.println("Wood");
            else out.println("Metal");
        }
        out.close();
    }

}