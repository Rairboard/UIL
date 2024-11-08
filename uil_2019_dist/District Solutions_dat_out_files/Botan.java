//UIL 2019 District Solution
import java.io.*;
import java.util.*;

public class Botan {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("botan.dat"));
        int T = scan.nextInt();
        int[] primes = {2, 3, 5, 7};
        int num;
        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int x = scan.nextInt();
            num=x;
            boolean botanPrime = true;
            while (x > 0) {
                int lastDigit = x % 10;
                boolean isPrime = false;
                for (int p : primes) {
                    isPrime |= p == lastDigit;
                }
                botanPrime &= isPrime;
                x /= 10;
            }

            String output = botanPrime ? "BOTAN-PRIME" : "NOT BOTAN-PRIME";
            System.out.printf("Case #%d: %d - %s%n", caseNum, num,output);
        }
    }
}

/*
Case #1: 3 - BOTAN-PRIME
Case #2: 1 - NOT BOTAN-PRIME
Case #3: 15 - NOT BOTAN-PRIME
Case #4: 35 - BOTAN-PRIME
Case #5: 3892 - NOT BOTAN-PRIME
Case #6: 1000000 - NOT BOTAN-PRIME
Case #7: 272557 - BOTAN-PRIME
Case #8: 937202 - NOT BOTAN-PRIME
Case #9: 51779 - NOT BOTAN-PRIME
Case #10: 463077 - NOT BOTAN-PRIME
Case #11: 140061 - NOT BOTAN-PRIME
Case #12: 752 - BOTAN-PRIME
Case #13: 334830 - NOT BOTAN-PRIME
Case #14: 733250 - NOT BOTAN-PRIME
Case #15: 5 - BOTAN-PRIME
Case #16: 293137 - NOT BOTAN-PRIME
Case #17: 208485 - NOT BOTAN-PRIME
Case #18: 293946 - NOT BOTAN-PRIME
Case #19: 525 - BOTAN-PRIME
Case #20: 2 - BOTAN-PRIME
Case #21: 506669 - NOT BOTAN-PRIME

*/