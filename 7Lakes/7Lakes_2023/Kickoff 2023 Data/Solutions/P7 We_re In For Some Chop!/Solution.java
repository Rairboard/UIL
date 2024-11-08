import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tc = in.nextInt();
        while(tc-- > 0) {
            int spaces = in.nextInt();
            int[] waves = new int[spaces];
            for(int i = 0; i < spaces; i++) {
                waves[i] = in.nextInt();
            }
            int count = 0;
            for(int i = 1; i < waves.length - 1; i++) {
                if(waves[i] > waves[i-1] && waves[i] > waves[i+1]) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
