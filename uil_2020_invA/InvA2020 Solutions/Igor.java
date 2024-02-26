/*
 *UIL Computer Science 2020
 *Invitational A Packet Solution
 */
import java.io.*;
import java.util.*;

public class Igor {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("igor.dat"));
        int T = scan.nextInt();
        assert 1 <= T && T <= 20;

        while (T --> 0) {
            String s = scan.next();

            assert 1 <= s.length() && s.length() <= 2000;
            int[] freq = new int[26];
            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
            }

            int cores = 0;
            int evens = 0;
            for (int k = 0; k < 26; ++k) {
                if (freq[k] % 2 == 1) {
                    cores++;
                }

                evens += (freq[k] / 2);
            }

            int ans;
            if (cores == 0) {
                ans = s.length() * s.length();
            } else {
                // put all the doubles on the first core, then add remaining cores
                ans = (2 * evens + 1) * (2 * evens + 1) + (cores - 1);
            }

            System.out.println(ans);
        }
    }
}
