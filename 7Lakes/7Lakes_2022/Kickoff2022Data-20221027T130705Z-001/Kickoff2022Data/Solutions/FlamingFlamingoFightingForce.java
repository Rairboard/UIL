import java.util.Scanner;

public class FlamingFlamingoFightingForce {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();

        for (int i = 0; i < n; i++) {
            int M = in.nextInt(), L = in.nextInt(), K = in.nextInt();
            int wetCount = 0;
            boolean crossed = true;
            for (int j = 0; j < M; j++) {
                if (in.nextInt() > L) {
                    wetCount++;
                    if (wetCount > K) {
                        crossed = false;
                        System.out.println("No");
                        in.nextLine();
                        break;
                    }
                }
            }
            if (crossed) {
                System.out.println("Yes");
                in.nextLine();
            }
        }
    }
}
