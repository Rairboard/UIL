/*
 * UIL Computer Science 2025
 * Invitational B Packet Solution
 */

import java.io.*;
import java.util.*;

public class Varsha {
	public static void main(String[]args)throws Exception{
		new Varsha().run();
	}
	
	char[][][] mat;
	boolean[][][] smat;
	
	public void run()throws Exception{
		Scanner file = new Scanner(new File("varsha.dat"));
		int times = file.nextInt();
		file.nextLine();
		while(times-- > 0) {
			int dd = file.nextInt();
			int rr = file.nextInt();
			int cc = file.nextInt();
			file.nextLine();
			mat = new char[dd][rr][cc];
			smat = new boolean[dd][rr][cc];
			for(int d = 0; d < dd; d++)
				for(int r = 0; r < rr; r++)
					mat[d][r] = file.nextLine().trim().toCharArray();
			int max = 0;
			for(int d = 0; d < dd; d++)
				for(int r = 0; r < rr; r++)
					for(int c = 0; c < cc; c++)
						max = Math.max(max, solve(d, r, c));
			System.out.println(max);
		}
		file.close();
	}
	
	public int solve(int d, int r, int c) {
		if(d < 0 || c < 0 || r < 0 || d >= mat.length || r >= mat[d].length 
				|| c >= mat[d][r].length || smat[d][r][c]) return 0;
		smat[d][r][c] = true;
		if(mat[d][r][c] != 'V') return 0;
		return 1 + solve(d + 1, r, c) + solve(d - 1, r, c) 
				 + solve(d, r + 1, c) + solve(d, r - 1, c) 
				 + solve(d, r, c + 1) + solve(d, r, c - 1);
	}
}
