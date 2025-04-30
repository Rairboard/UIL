/*
 * UIL Computer Science 2025
 * Invitational B Packet Solution
 */

import java.io.File;
import java.util.Scanner;

public class Ruth {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("ruth.dat"));

        int N = Integer.parseInt(kb.nextLine().trim());

        while(N-->0) {
            String [] s = kb.nextLine().split("\\s+");
            int [] arr = new int[s.length];

            for(int x = 0; x < arr.length; x++) {
                arr[x] = Integer.parseInt(s[x]);
            }

            int leftMax = arr[0];
            int rightMax = arr[arr.length - 1];

            int left = 1;
            int right = arr.length - 2;

            long total = 0;

            while(left <= right) {
                if(leftMax < rightMax) {
                    int diff = leftMax - arr[left];
                    if(diff > 0)
                        total+= diff;
                    leftMax = Math.max(leftMax, arr[left]);
                    left++;
                } else {
                    int diff = rightMax - arr[right];
                    if(diff > 0)
                        total+= diff;
                    rightMax = Math.max(rightMax, arr[right]);
                    right--;
                }
            }

            System.out.println(total);
        }
        kb.close();
    }
}
