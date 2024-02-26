import java.util.Scanner;

public class TheWall {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();

        for (int i = 0; i < n; i++) {
            int L = in.nextInt(), A = in.nextInt(), B = in.nextInt();
            in.nextLine();

            char[] line = in.nextLine().toCharArray();

            int gap = 0;
            boolean onX = false;
            boolean wallStarted = false;
            int cost = 0;
            for (int j = 0; j < line.length; j++) {
                char c = line[j];
                if (c == 'X') {
                    wallStarted = true;
                    if (onX) {
                        cost += A;
                    } else {
                        if (gap > 0) {
                            cost += Math.min(B + A, A * gap + A);
                            gap = 0;
                        } else {
                            cost += B + A;
                        }
                    }
                    onX = true;
                } else {
                    onX = false;
                    if (wallStarted)
                        gap++;
                }
            }

            System.out.println(cost);
        }
    }
}
