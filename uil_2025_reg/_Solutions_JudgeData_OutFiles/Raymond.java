import java.io.File;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;

public class Raymond {
    public static void main(String[] args) throws Throwable {
        Scanner kb = new Scanner(new File("raymond.dat"));

        int N = kb.nextInt();

        while(N-->0) {
            int M = kb.nextInt();

            HashSet<Integer> set = new HashSet<>();

            for(int i = 0; i < M; i++) {
                set.add(kb.nextInt());
            }

            BigInteger LCM = findLCM(set);

            //naiveSolution(set);

            if(LCM.equals(BigInteger.ONE)) {
                System.out.println("LCM NUMBER 1!");
            } else {
                System.out.println("Lowest Common Multiple is " + LCM);
            }
        }
    }

    public static BigInteger findLCM(HashSet<Integer> set) {
        BigInteger lcm = BigInteger.ONE;
        for(int i : set) {
            BigInteger temp = new BigInteger(String.valueOf(lcm));
            lcm = lcm.multiply(new BigInteger(String.valueOf(i))).divide(temp.gcd(new BigInteger(String.valueOf(i))));
        }
        return lcm;
    }

    // even with some optimizations this is way too slow
    public static void naiveSolution(HashSet<Integer> set) {
        BigInteger b = BigInteger.ONE;

        for(Integer x : set) {
            if(x > b.intValue()) {
                b = new BigInteger(String.valueOf(x));
            }
        }

        HashSet<BigInteger> bigInts = new HashSet<>();

        for(Integer x : set) {
            bigInts.add(new BigInteger(String.valueOf(x)));
        }

        boolean done = false;

        BigInteger lcm = new BigInteger(b.toString());
        long multiple = 1;

        while(!done) {
            done = true;
            for(BigInteger x : bigInts) {
                if(lcm.mod(x).intValue() != 0) {
                    done = false;
                    multiple++;
                    lcm = b.multiply(new BigInteger(String.valueOf(multiple)));
                    break;
                }
            }
        }
        System.out.println(lcm);
    }
}
