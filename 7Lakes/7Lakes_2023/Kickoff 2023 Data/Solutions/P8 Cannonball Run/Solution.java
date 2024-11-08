import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int total = sc.nextInt() * sc.nextInt();
            sc.nextLine();
            for (String c : sc.nextLine().split(" ")) {
                total -= Integer.parseInt(c);
            }
            int cost = sc.nextInt();
            int bulknum = sc.nextInt();
            System.out.println((total + bulknum - 1) / bulknum * cost + " coins");
        }
    }
}