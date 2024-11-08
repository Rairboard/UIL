import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.nextLine().toUpperCase();
            n = ((n % 26) + 26) % 26;
            for (int i = 1; i < s.length(); i++) {
                if (!Character.isAlphabetic(s.charAt(i))) {
                    System.out.print(s.charAt(i));
                    continue;
                }
                int x = s.charAt(i) - 'A';
                x = (x + n) % 26 + 65;
                System.out.print((char) x);
            }
            System.out.println();
        }
        sc.close();
    }

}