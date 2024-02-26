import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Bryan {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("bryan.dat"));
        int W = scan.nextInt();
        assert 1 <= W && W <= 30;
        for (int caseNum = 1; caseNum <= W; caseNum++) {
            int n = scan.nextInt();

            assert 1 <= n && n <= 30;
            int total = 0;
            for (int i = 0; i < n; i++) {
                String description = scan.next();
                int amount = scan.nextInt();
                assert -30 <= amount && amount <= 30;
                assert amount != 0;
                assert Pattern.matches("^[a-z]{1,20}$", description);

                total += amount;
            }


            System.out.printf("Case #%d: ", caseNum);
            if (total == 0) {
                System.out.println("Phew, broke even!");
            } else if (total > 0) {
                System.out.printf("Wow, Bryan saved $%d%n", total);
            } else {
                System.out.printf("Oh no! Bryan had to borrow $%d%n", -total);
            }
        }
    }
}
