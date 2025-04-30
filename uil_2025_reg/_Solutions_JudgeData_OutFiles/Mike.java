import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Mike {
    public static void main(String[] args) throws Throwable {
        Scanner kb = new Scanner(new File("mike.dat"));

        int testCases = kb.nextInt();

        while (testCases-- > 0) {
            int feedings = kb.nextInt(); kb.nextLine();

            HashMap<String, Double> requiredFood = new HashMap<>();

            while (feedings-- > 0) {
                final String [] feeding = kb.nextLine().trim().split("\\s+");
                final String brandName = feeding[2];
                final double feedWeight = Double.parseDouble(feeding[1]);
                requiredFood.put(brandName, requiredFood.getOrDefault(brandName, 0.0) + feedWeight);
            }

            double totalCost = 0;

            for (int times = 0; times < requiredFood.size(); times++) {
                String [] line = kb.nextLine().trim().split("\\s+");

                double [] cost = new double[1_000_001];
                Arrays.fill(cost, -1);

                for(int x = 1; x < line.length; x++) {
                    String [] s = line[x].split(":");
                    int cans = Integer.parseInt(s[0]);
                    int ouncesPerCan = Integer.parseInt(s[1]);
                    double pricePerPack = Double.parseDouble(s[2]);

                    int weight = cans * ouncesPerCan - 1;

                    if(cost[weight] != -1.0) {
                        cost[weight] = Math.min(cost[weight], pricePerPack);
                    } else {
                        cost[weight] = pricePerPack;
                    }
                }

                int W = (int) Math.ceil(requiredFood.get(line[0]));
                totalCost += minCost(cost, cost.length, W);
            }

            System.out.printf("Total cost to feed all cats: $%,.2f%n", totalCost);
        }
        kb.close();
    }

    public static double minCost(double [] cost, int n, int W) {
        ArrayList<Double> val = new ArrayList<>();
        ArrayList<Integer> weights = new ArrayList<>();

        int size = 0;
        for(int i = 0; i < n; i++) {
            if (cost[i] != -1) {
                val.add(cost[i]);
                weights.add(i + 1);
                size++;
            }
        }
        n = size;
        double [][] min_cost = new double[n + 1][1_000_001]; // allow for overflow
        Arrays.fill(min_cost[0], Double.POSITIVE_INFINITY);

        for(int x = 1; x <= n; x++) {
            min_cost[x][0] = 0;
        }

        double minAnswer = Double.POSITIVE_INFINITY;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= 1_000_000; j++) {
                if(weights.get(i - 1) > j) {
                    min_cost[i][j] = min_cost[i - 1][j];
                } else {
                    min_cost[i][j] = Math.min(min_cost[i-1][j], min_cost[i][j-weights.get(i-1)] + val.get(i-1));
                }
            }
        }

        for(int i = W; i <= 1_000_000; i++) {
            minAnswer = Math.min(minAnswer, min_cost[n][i]);
        }

        return minAnswer;
    }
}
