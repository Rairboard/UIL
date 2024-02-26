//Solution - UIL Region 2019
import java.io.*;
import java.util.*;

public class Vova {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("vova.dat"));
        int T = Integer.parseInt(scan.nextLine());
        for (int caseNum = 1; caseNum <= T; ++caseNum) {
            int x1 = scan.nextInt();
            int y1 = scan.nextInt();
            int x2 = scan.nextInt();
            int y2 = scan.nextInt();
            long L = scan.nextLong();

            int dx = Math.abs(x1 - x2);
            int dy = Math.abs(y1 - y2);
            boolean valid = (dx + dy <= L) && ((L - dx - dy) % 2 == 0);
            System.out.printf("Case #%d: %s%n", caseNum, valid ? "YES" : "NO");
        }
    }
}
