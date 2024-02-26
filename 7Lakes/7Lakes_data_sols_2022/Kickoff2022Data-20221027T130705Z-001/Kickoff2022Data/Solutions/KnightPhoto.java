import java.util.Scanner;

public class KnightPhoto {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        long[][] mat = new long[n][2];
        for (int i = 0; i < n; i++) {
            mat[i] = new long[]{in.nextInt(), in.nextInt()};
        }

        for (int i = 0; i < n; i++) {
            boolean found = false;
            for (int j = 0; j < n; j++) {
                if (j == i) {
                    continue;
                }

                if ((mat[i][0] > mat[j][0] && mat[i][1] > mat[j][1]) ||
                        (mat[i][1] > mat[j][0] && mat[i][0] > mat[j][1])) {
                    found = true;
                    System.out.println("YES");
                    break;
                }
            }
            if (!found) {
                System.out.println("NO");
            }
        }
    }
}
