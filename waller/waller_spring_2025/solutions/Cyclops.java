import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Cyclops {
	public static void main(String[]args)throws Exception{
		new Cyclops().run();
	}
	public void run()throws Exception{
		Scanner file = new Scanner(new File("cyclops.dat"));
		int times = file.nextInt();
		file.nextLine();
		while(times-- > 0) {
			int rr = file.nextInt(), cc = file.nextInt(), num = file.nextInt();
			file.nextLine();
			int[] count = new int[10];
			int min = (rr * cc + 1) / 2;
			//System.out.println(min);
			for(int r = 0; r < rr; r++) {
				char[] row = file.nextLine().trim().toCharArray();
				for(int c = 0; c < cc; c++)
					count[row[c] - '0']++;
			}
			int i = 0;
			while(num > 0 && min > 0) {
				if(count[i] == 0)i++;
				else {
					num -= i;
					min--;
					count[i]--;
				}
			}
			System.out.println(min != 0 || (min == 0 && num < 0)? "Better Call Iceman.": "Made it with "+num+" power to spare.");
		}
	}
}
 