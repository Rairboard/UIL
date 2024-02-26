/*
 *UIL Computer Science 2020
 *Invitational A Packet Solution
 */
import java.io.*;
import java.util.*;

public class Brian {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("brian.dat"));
        int T = scan.nextInt();
        assert 1 <= T && T <= 20;

        while (T --> 0) {
            int year = scan.nextInt();
            assert 1995 <= year && year < 3000;
            int version = (year - 1995) / 2;

            System.out.printf("In the year %d, Brian will be coding in Java %d!%n", year, version);
        }
    }
}

