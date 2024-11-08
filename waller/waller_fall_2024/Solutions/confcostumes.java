import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class confcostumes {
    static String[][] sm;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("judges\\confcostumes.dat"));
        int runs = sc.nextInt();
        for (int test = 0; test < runs; test++) {
            int rms = sc.nextInt();
            sc.nextLine();
            sm = new String[rms][];
            for (int r = 0; r < rms; r++) {
                sc.nextLine();
                sm[r] = sc.nextLine().split(" ");
            }
            System.out.println(generate(0, new HashSet<String>()));
        }
    }

    public static boolean generate(int n, HashSet<String> used) {
        if (n == sm.length) {
            return true;
        }
        boolean unique = false;
        for (String s : sm[n]) {
            if (!used.contains(s)) {
                HashSet<String> temp = new HashSet<>(used);
                temp.add(s);
                unique = unique || generate(n + 1, temp);
            }
        }
        return unique;
    }
}