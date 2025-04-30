/*
 * UIL Computer Science 2025
 * Invitational B Packet Solution
 */

import java.io.*;
import java.util.*;
import java.math.*;

public class Dante {
	public static void main(String[]args)throws Exception{
		new Dante().run();
	}
	
	public void run()throws Exception{
		Scanner file = new Scanner(new File("Dante.dat"));
		int times = file.nextInt();
		file.nextLine();
		while(times-- > 0) {
			int a = file.nextInt(), b = file.nextInt(), count = 0;
			for(int x = a + 1; x < b; x++) {
				BigInteger bi = new BigInteger(""+x);
				if(bi.isProbablePrime(100))
					count++;
			}
			System.out.println(count);
		}
		file.close();
	}
}
