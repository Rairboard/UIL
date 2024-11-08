import java.util.Scanner;

public class UniformMilkProduction {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();

        for (int i = 0; i < n; i++) {
            int a = in.nextInt(), b = in.nextInt();
            in.nextLine();
            int[] goats = new int[a];

            for (int j = 0; j < a; j++) {
                goats[j] = in.nextInt();
            }

            int index = -1;
            double globalMaxDiff = -1;

            for (int j = 0; j < a - b; j++) {
                double sum = 0;
                int diffIndex = -1;
                for (int k = 0; k < b; k++) {
                    sum += goats[j + k];
                }
                double avg = sum / (double)b;
                double maxDiff = -1;

                for (int k = 0; k < b; k++) {
                    double diff = Math.abs(goats[j + k] - avg);
                    if (diff > maxDiff) {
                        diffIndex = j + k;
                        maxDiff = diff;
                    }
                }

                if (maxDiff > globalMaxDiff) {
                    index = diffIndex;
                    globalMaxDiff = maxDiff;
                }
            }
            System.out.println(index + 1);
        }
    }
}
