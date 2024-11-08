import java.util.Scanner;

public class Quartermaster {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double total = in.nextDouble();
        int people = in.nextInt();
        in.nextLine();
        int[] highest = {5, 4, 11, 10, Math.max(5, ("$" + String.format("%.2f", total)).length())};
        String[][] printData = new String[people][5];
        int totalShares = 0;
        for(int i = 0; i < people; i++) {
            String[] data = in.nextLine().split(" ");
            System.arraycopy(data, 0, printData[i], 0, data.length);
            totalShares += Integer.parseInt(data[2]);
        }
        // update # of shares, total, and money
        for (int i = 0; i < printData.length; i++) {
            int shares = Integer.parseInt(printData[i][2]);
            double shareProp = 1.0 * shares / totalShares;
            printData[i][3] = String.format("%.2f", shareProp * 100) + "%";
            double money = total * shareProp;
            printData[i][4] = "$" + String.format("%.2f", money);
        }
        // update highest
        for (String[] printDatum : printData) {
            for (int j = 0; j < printData[0].length; j++) {
                highest[j] = Math.max(highest[j], printDatum[j].length());
            }
        }
        String format = "| %-" + highest[0] + "s | %-" + highest[1] + "s | %-" + highest[2] + "s | %-" + highest[3] + "s | " + "%-" + highest[4] + "s |%n";
        System.out.printf(format, "Name", "Role", "# of Shares", "% of Total", "Money");
        System.out.print("|");
        for(int i = 0; i < 5; i++) {
            System.out.print(" " + "-".repeat(highest[i]) + " |");
        }
        System.out.println();
        for (String[] printDatum : printData) {
            System.out.printf(format, printDatum[0], printDatum[1], printDatum[2], printDatum[3], printDatum[4]);
        }
        System.out.printf(format, "Total", "", "", "", String.format("$%.2f", total));
    }
}
