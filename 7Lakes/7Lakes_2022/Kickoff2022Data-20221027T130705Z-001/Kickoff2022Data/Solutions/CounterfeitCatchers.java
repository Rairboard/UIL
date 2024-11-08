import java.util.HashMap;
import java.util.Scanner;

public class CounterfeitCatchers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        in.nextLine();
        for (int t = 0; t < T; t++) {
            int n = in.nextInt(), c = in.nextInt();
            in.nextLine();

            HashMap<String, Integer[]> lines = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String coin = "";
                for (int j = 0; j < c; j++) {
                    coin += in.nextLine();
                }

                if (lines.containsKey(coin)) {
                    lines.put(coin, new Integer[]{lines.get(coin)[0] + 1, i});
                } else {
                    lines.put(coin, new Integer[]{1, i});
                }
            }

            for (String key : lines.keySet()) {
                if (lines.get(key)[0] == 1) {
                    System.out.println("Sir, coin " + (lines.get(key)[1] + 1) + " is a counterfeit!");
                }
            }
        }
    }
}
