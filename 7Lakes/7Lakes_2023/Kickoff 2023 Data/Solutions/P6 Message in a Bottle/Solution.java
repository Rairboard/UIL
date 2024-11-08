import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String message = in.nextLine();
        int tc = Integer.parseInt(in.nextLine());
        double highest = 0;
        for(int i = 0; i < tc; i++) {
            String theirMessage = in.nextLine();
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < theirMessage.length(); j++) {
                if(theirMessage.charAt(j) == '#') {
                    sb.deleteCharAt(sb.length()-1);
                } else {
                    sb.append(theirMessage.charAt(j));
                }
            }
            int charsCorrect = 0;
            for(int j = 0; j < Math.min(sb.length(), message.length()); j++) {
                if(sb.charAt(j) == message.charAt(j))
                    charsCorrect++;
            }
            int seconds = Integer.parseInt(in.nextLine());
            double pwpm = 1.0 * charsCorrect / 5 / (1.0 * seconds / 60);
            if(pwpm > highest) {
                highest = pwpm;
            }
            System.out.printf("%.2f%n", pwpm);
        }
        System.out.printf("The highest pirate words per minute is %.2f", highest);
    }
}
