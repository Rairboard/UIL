import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String[] arr = sc.next().split(":");
            String[] arr2 = sc.next().split(":");
            int x1 = Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
            int x2 = Integer.parseInt(arr2[0]) * 60 + Integer.parseInt(arr2[1]);
            x1 = 720 - x1;
            System.out.println(x1 + x2 >= 480 ? "getting the ZZZs" : "gonna take a nap");
        }
        sc.close();
    }

}