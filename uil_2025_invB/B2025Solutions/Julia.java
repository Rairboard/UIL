/*
 * UIL Computer Science 2025
 * Invitational B Packet Solution
 */

import java.io.File;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Julia {
    public static void main(String[] args) throws Throwable {
        Scanner kb = new Scanner(new File("julia.dat"));

        int N = kb.nextInt();

        while(N-->0) {
            int V = kb.nextInt();
            solve(V);
            //solve2(V);
            //solve3(V);
        }
        kb.close();
    }

    // optimal solution, uses Sieve of Eratosthenes, takes about 800 milliseconds
    public static void solve(int V) {
        boolean [] prime = new boolean[V + 1];

        Arrays.fill(prime, true);

        for(int x = 2; x * x <= V; x++) {
            if(prime[x]) {
                for(int i = x * x; i <= V; i += x) {
                    prime[i] = false;
                }
            }
        }
        int count = 0;

        for(int x = 2; x <= V; x++) {
            if(prime[x])
                count++;
        }
        System.out.println(count);
    }

    // takes about 76 seconds
    public static void solve2(int V) {
        int count = 0;

        for(int x = 2; x <= V; x++) {
            if(isPrime(x))
                count++;
        }

        System.out.println(count);
    }

    // way too slow, didn't even bother letting it run to completion
    public static void solve3(int V) {
        int count = 0;

        for(int x = 2; x <= V; x++) {
            BigInteger b = new BigInteger(String.valueOf(x));
            if(b.isProbablePrime(100))
                count++;
        }
        System.out.println(count);
    }

    public static boolean isPrime(int N) {
        for(int x = 2; x <= Math.sqrt(N); x++) {
            if(N % x == 0)
                return false;
        }
        return true;
    }
}
