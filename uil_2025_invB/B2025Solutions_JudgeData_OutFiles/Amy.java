/*
 * UIL Computer Science 2025
 * Invitational B Packet Solution
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class Amy {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner kb = new Scanner(new File("amy.dat"));

        String possibleCharacters = "36";

        int N = kb.nextInt();

        while(N-->0) {
            String s = kb.next();
            String v = kb.next();

            BigInteger b = new BigInteger(possibleCharacters);
            b = b.pow(s.length());

            System.out.println(b.divide(new BigInteger(v)));
        }
        kb.close();
    }
}
