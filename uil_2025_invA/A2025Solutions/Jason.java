/*
 * UIL Computer Science 2025
 * Invitational A Packet Solution
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Jason {
    public static void main(String[] args) throws Exception {
        new Jason().run();
    }

    public void run() throws Exception {
        Scanner input = new Scanner(new File("jason.dat"));

        String[] months = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        int[] daysInMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        String fullRow = "*****";
        String emptyRow = "     ";

        double[] days = new double[365];
        double[] monthAvg = new double[12];

        for (int x = 0; x < 365; x++) {
            double rainFall = input.nextDouble();
            days[x] = rainFall;
        }
        int day = 0;
        for (int month = 0; month < 12; month++) {
            for (int x = 0; x < daysInMonth[month]; x++, day++) {
                monthAvg[month] += days[day];
            }
            monthAvg[month] /= daysInMonth[month];
            monthAvg[month] = Math.round(monthAvg[month]); // round to the nearest inch
        }

        boolean done = false;

        ArrayList<String> outputList = new ArrayList<>();

        while (!done) {
            done = true;
            String out = "";
            for (int month = 0; month < 12; month++) {
                if (monthAvg[month] != 0) {
                    done = false;
                    out += fullRow;
                    monthAvg[month] -= 1;
                } else {
                    out += emptyRow;
                }
                out += " ";
            }
            outputList.add(out.replaceAll("\\s+$", ""));
        }

        for (int x = outputList.size() - 2; x >= 0; x--) {
            System.out.println(outputList.get(x));
        }
        StringBuilder lastrow = new StringBuilder(" ");

        for (String monthName : months) {
            lastrow.append(monthName).append("   ");
        }
        System.out.println(lastrow.toString().replaceAll("\\s+$", ""));
        input.close();
    }
}
