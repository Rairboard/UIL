/*
 * UIL Computer Science 2025
 * District Packet Solution
 */

import java.io.*;
import java.util.*;

public class Kassie {
	public static void main(String[]args)throws Exception{
		new Kassie().run();
	}
	
	public void run()throws Exception{
		Scanner file = new Scanner(new File("kassie.dat"));
		int times = file.nextInt();
		file.nextLine();
		while(times-- > 0) {
			String[] s = file.nextLine().trim().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[2]);
			int x = 0;
			switch(s[1]) {
			case "+": x = a + b;break;
			case "-": x = a - b;break;
			case "*": x = a * b;break;
			case "/": x = a / b;break;
			}
			System.out.println(x);
		}
		file.close();
	}
}
