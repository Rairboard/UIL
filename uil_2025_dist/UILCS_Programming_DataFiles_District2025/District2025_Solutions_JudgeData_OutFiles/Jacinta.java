/*
 * UIL Computer Science 2025
 * District Packet Solution
 */

import java.io.*;
import java.util.*;

public class Jacinta {
	public static void main(String[]args)throws Exception{
		new Jacinta().run();
	}
	
	public void run()throws Exception{
		Scanner file = new Scanner(new File("jacinta.dat"));
		int times = file.nextInt();
		file.nextLine();
		while(times-->0) {
			String[] st = file.nextLine().trim().split("\\s+");
			int[] in = new int[st.length];
			for(int y = 0; y < st.length; y++)
				in[y] = Integer.parseInt(st[y]);
			System.out.println(part(in)? "Job secured.": "Indeed here I come.");
		}
		file.close();
	}
	
	boolean part(int[] arr) { 
        int sum = 0; 
        for (int num : arr) 
            sum += num;
        if (sum % 2 != 0)
            return false;
        sum = sum / 2;
        int n = arr.length;
        boolean[] prev = new boolean[sum + 1];
        boolean[] curr = new boolean[sum + 1];
        prev[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j < arr[i - 1])
                    curr[j] = prev[j];
                else
                    curr[j] = (prev[j] || prev[j - arr[i - 1]]);
            }
            for (int j=0; j<=sum; j++) {
                prev[j] = curr[j];
            }
        }
        return prev[sum];
    }
}
