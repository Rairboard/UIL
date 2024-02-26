import java.util.Scanner;

public class CensusStatisticsOutliers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            int n = in.nextInt(), q1 = in.nextInt(), q3 = in.nextInt();

            int IQR = q3 - q1;

            boolean hasOutliers = false;
            for (int j = 0; j < n; j++) {
                int x = in.nextInt();
                if (x > q3 + IQR * 1.5 || x < q1 - IQR * 1.5) {
                    hasOutliers = true;
                    System.out.print(x + " ");
                }
            }
            System.out.println(hasOutliers ? "" : -1);
        }
    }
}
