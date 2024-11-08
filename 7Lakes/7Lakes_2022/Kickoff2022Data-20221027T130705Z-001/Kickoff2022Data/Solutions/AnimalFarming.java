import java.util.Scanner;

public class AnimalFarming {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        for (int i = 0; i < n; i++) {
            int a, b, c, d;

            a = in.nextInt();
            b = in.nextInt();
            c = in.nextInt();
            d = in.nextInt();

            if (a == b && b == c && c == d) {
                System.out.println("sheep");
            } else if (a == c && b == d) {
                System.out.println("cattle");
            } else {
                System.out.println("pigs");
            }
        }
    }
}
