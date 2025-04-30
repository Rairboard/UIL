/*
 * UIL Computer Science 2025
 * Invitational B Packet Solution
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Hulin {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner kb = new Scanner(new File("hulin.dat"));
        int N = Integer.parseInt(kb.nextLine().trim());

        int [] time = new int[90_000];

        while(N-->0) {
            String[] s = kb.nextLine().split("\\s+");

            for(int x = 0; x < 6; x+=2) {
                int start = Integer.parseInt(s[x]);
                int end = Integer.parseInt(s[x + 1]);

                for(int i = start; i <= end; i++) {
                    time[i]++;
                }
            }
        }
        Arrays.sort(time);
        System.out.println(time[89_999]);
        kb.close();
    }
}
