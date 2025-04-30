/*
 * UIL Computer Science 2025
 * District Packet Solution
 */

import static java.lang.System.out;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sage {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("sage.dat"));
        Map<Integer,Integer> data = new HashMap<>();
        while (input.hasNext()) {
            int id = input.nextInt();
            int score = input.nextInt();
            data.put(id, score);
        }
        input.close();
        double sum = 0;
        int max = 0;
        int min = 220;
        for(Integer id : data.keySet()) {
            sum += data.get(id);
            int score = data.get(id);
            if(score > max) max = score;
            if(score < min) min = score;
        }
        double average = sum / data.size();
        int numAbove = 0;
        out.println("Average score: " + String.format("%.2f",average));
        out.println("   Highest score: " + max);
        out.println("      Students with highest score:");
        for(Integer key : data.keySet()) {
            if(data.get(key) == max)
                out.println("         " + key);
            if(data.get(key) > average)
                numAbove++;
        }

        out.println("   Lowest score: " + min);
        out.println("      Students with lowest score:");
        for(Integer key : data.keySet()) {
            if(data.get(key) == min)
                out.println("         " + key);
        }
        out.println("Number of students above the average: " + numAbove);
    }
}
