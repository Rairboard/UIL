import java.io.IOException;
import java.util.Scanner;

public class RoughSeas {
    static long x, y, m, n, A, B;
    public static double check(double a) {
        return a/(A*Math.sqrt(a*a+y*y)) - (m-x-a)/(B*Math.sqrt((m-x-a)*(m-x-a)+n*n));
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            x = sc.nextLong();
            y = sc.nextLong();
            m = sc.nextLong();
            n = sc.nextLong();
            A = sc.nextLong();
            B = sc.nextLong();
            if (m < x) {
                m = x + (x - m);
            }
            double low = 0;
            double high = m - x;
            double mid = 0;
            while (high - low > 0.0001) {
                mid = (low + high) / 2;
                if (check(mid) < 0) {
                    low = mid;
                } else {
                    high = mid;
                }
            }
            System.out.printf("%.3f\n", Math.sqrt(mid*mid+y*y)/A + Math.sqrt((m-x-mid)*(m-x-mid)+n*n)/B);
        }
    }
}
