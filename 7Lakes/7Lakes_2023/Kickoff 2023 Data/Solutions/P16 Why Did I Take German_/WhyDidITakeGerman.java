import java.io.IOException;
import java.util.Scanner;

public class WhyDidITakeGerman {
    public static void main(String[] args) throws IOException {
        int N;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            double x = sc.nextDouble();
            for (int j = 1; j <= 1000; j++) {
                int n = (int)Math.ceil(x*j);
                double res = (double)n/j;
                if ((int)(res*1000) == (int)(x*1000)) {
                    System.out.printf("%d %d\n", n, j);
                    break;
                }
                n = (int)Math.floor(x*j);
                res = (double)n/j;
                if ((int)(res*1000) == (int)(x*1000)) {
                    System.out.printf("%d %d\n", n, j);
                    break;
                }
            }
        }
    }
}
