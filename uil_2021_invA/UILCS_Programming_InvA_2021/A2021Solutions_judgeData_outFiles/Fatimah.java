import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Fatimah {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("fatimah_student.dat"));
        int T = scan.nextInt();
        assert 1 <= T && T <= 20;
        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int n = scan.nextInt();
            int m = scan.nextInt();

            assert 1 <= n && n <= 12;
            assert 0 <= m && m <= 20;

            Map<String, Integer> names = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String name = scan.next();
                assert Pattern.matches("^[a-z]{1,20}$", name);

                names.put(name, i);
            }

            int[] badMasks = new int[m];
            for (int i = 0; i < m; i++) {
                String name1 = scan.next();
                String name2 = scan.next();

                assert names.containsKey(name1);
                assert names.containsKey(name2);
                assert !name1.equals(name2);

                int u = names.get(name1);
                int v = names.get(name2);
                badMasks[i] = (1 << u) | (1 << v);
            }

            int ans = 0;
            for (int mask = 1; mask < (1 << n); ++mask) { 
                boolean valid = true;
                for (int badMask : badMasks) {
                    if ((mask & badMask) == badMask) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    ans = Math.max(ans, Integer.bitCount(mask));
                }
            }

            System.out.printf("Case #%d: %d%n", caseNum, ans);
        }
    }
}
