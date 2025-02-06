import java.io.*;
import java.util.*;

public class Paaus {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("paaus.dat"));
        int T = scan.nextInt();
        assert 1 <= T && T <= 60;

        int[] bases = new int[]{2, 8, 10, 16};
        String[] prefixes = new String[]{"0b", "0", "", "0x"};

        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int n = scan.nextInt();
            String k = scan.next();

            assert 0 <= n && n <= 1_000_000_000;
            assert k.length() == 1 && "0123456789abcdef".contains(k);

            String answer = null;

            for (int i = 0; i < 4; i++) {
                String option = prefixes[i] + Integer.toString(n, bases[i]);
                if (!option.contains(k) && (answer == null || option.length() < answer.length())) {
                    answer = option;
                }
            }

            if (answer == null) {
                answer = "Impossible";
            }

            System.out.printf("Case #%d: %s\n", caseNum, answer);
        }
    }
}
