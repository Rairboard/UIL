/*
 * UIL Computer Science 2025
 * Invitational A Packet Solution
 */

import java.io.*;
import java.util.*;

public class Prachi {
	char[][] mat;
	public static void main(String[]args)throws Exception{
		new Prachi().run();
	}
	
	public void run()throws Exception{
		Scanner file = new Scanner(new File("prachi.dat"));
		int times = file.nextInt();
		file.nextLine();
		while(times-- > 0) {
			int rr = file.nextInt(), cc = file.nextInt(), sr = file.nextInt(), sc = file.nextInt();
			file.nextLine();
			mat = new char[rr][cc];
			for(int r = 0; r < rr; r++)
				mat[r] = file.nextLine().trim().toCharArray();
			fill(sr, sc);
			for(char[] c:mat)
				System.out.println(c);
		}
		file.close();
	}
	
	public void fill(int r, int c) {
		if(r < 0 || c < 0 || r >= mat.length || c >= mat[r].length || mat[r][c] != '.')return;
		mat[r][c] = '$';
		fill(r + 1, c);
		fill(r - 1, c);
		fill(r, c + 1);
		fill(r, c - 1);
	}
}
