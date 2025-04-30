/*
 * UIL Computer Science 2025
 * District Packet Solution
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Dean {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner kb = new Scanner(new File("dean.dat"));

        int N = Integer.parseInt(kb.nextLine().trim());

        while(N-->0) {
            String s = kb.nextLine();
            solve(s);
        }
        kb.close();
    }

    // takes about 242 milliseconds
    public static void solve(String s) {
        int total = 0;

        for(int i = 0; i < s.length(); i++) {
            total += expand(s, i, i);
            total += expand(s, i, i + 1);
        }
        System.out.println(total);
    }

    // takes over 5 minutes, stopped running
    public static void bruteForceSolve(String s) {
        int total = 0;

        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length(); j++) {
                if(isPalindrome(s.substring(i, j + 1)))
                    total++;
            }
        }

        System.out.println(total);
    }

    public static int expand(String s, int left, int right) {
        int n = s.length(), count = 0;
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }

    public static boolean isPalindrome(String s) {
        StringBuilder reverse = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            reverse.insert(0, s.charAt(i));
        }

        return reverse.toString().equals(s);
    }
}
