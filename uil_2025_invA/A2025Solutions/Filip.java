/*
 * UIL Computer Science 2025
 * Invitational A Packet Solution
 */

import java.io.*;
import java.util.*;
public class Filip {
	public static void main(String[]args)throws Exception{
		new Filip().run();
	}
	
	public void run()throws Exception{
		Scanner file = new Scanner(new File("filip.dat"));
		int times = file.nextInt();
		file.nextLine();
		while(times-- > 0) {
			int r = file.nextInt(), c = file.nextInt();
			char k = file.next().charAt(0);
			boolean b = file.nextBoolean();
			char[][] mat = new char[r][c];
			for(int rr = 0; rr < r; rr++)
				Arrays.fill(mat[rr], k);
			if(!b) {
				for(int rr = 1; rr < r - 1; rr++)
					Arrays.fill(mat[rr], 1, c - 1, ' ');
			}
			for(char[] cc: mat)
				System.out.println(cc);
		}
		file.close();
	}
}
