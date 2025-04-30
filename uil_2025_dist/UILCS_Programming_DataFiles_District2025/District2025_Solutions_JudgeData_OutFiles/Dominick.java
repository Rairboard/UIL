/*
 * UIL Computer Science 2025
 * District Packet Solution
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dominick {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner kb = new Scanner(new File("dominick.dat"));

        int N = Integer.parseInt(kb.nextLine().trim());

        while(N-->0) {
            String [] s = kb.nextLine().split("\\s+");

            int S = s.length;

            solve(S, 1, 3, 2);
            if(N > 0)
                System.out.println();
        }
        kb.close();
    }

    public static void solve(int n, int from, int to, int aux) {
        if(n == 0)
            return;
        solve(n - 1, from, aux, to);
        System.out.println("Move snail "+n+" from rock "+from+" to rock "+ to);
        solve(n - 1, aux, to, from);
    }
}
