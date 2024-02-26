import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
public class Doors {
	public static void main(String[]args)throws Exception{
		new Doors().run();
	}
	
	char[][] mat;
	int[][][] smat;
	String doors;
	
	public void run()throws Exception{
		Scanner file=new Scanner(new File("doors.dat"));
		int times=file.nextInt();
		file.nextLine();
		while(times-->0) {
			int r = file.nextInt(), c = file.nextInt(), s = file.nextInt();
			int sr = -1, sc = -1, er = 0, ec = 0, cnt = 0;
			doors = "";
			file.nextLine();
			mat = new char[r][c];
			for(int rr = 0; rr < r; rr++) {
				mat[rr] = file.nextLine().trim().toCharArray();
				for(int cc = 0; cc < c; cc++) {
					if(mat[rr][cc] == '[') {
						er = rr;
						ec = cc;
					}
					if(mat[rr][cc] == ']') {
						sr = rr;
						sc = cc;
					}
					if(Character.isLowerCase(mat[rr][cc])) {
						doors += Character.toUpperCase(mat[rr][cc]);
						mat[rr][cc] = (char)(cnt++);
					}
				}
			}
			smat = new int[(1 << cnt)][r][c];
			for(int i = 0; i < smat.length; i++)
				for(int j = 0; j < r; j++)
					Arrays.fill(smat[i][j], Integer.MAX_VALUE);
			solve(0, sr, sc, 0, "");
			int step = steps(er, ec);
			if(step <= s)
				System.out.println("Amazeing Job. Escaped in "+step+" steps.");
			else
				System.out.println("Mother knows best.");
		}
	}
	
	public int steps(int r, int c) {
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < smat.length; i++)
			min = Math.min(smat[i][r][c], min);
		return min;
	}
	
	public void solve(int level, int r, int c, int steps, String d) {
		if(r < 0 || c < 0 || r >= mat.length || c >= mat[r].length || mat[r][c]=='#' || smat[level][r][c] <= steps
				|| (Character.isUpperCase(mat[r][c]) && !d.contains(""+mat[r][c])) )return;
		smat[level][r][c] = steps;
		if(mat[r][c] <= 25) {
			int i = (int)mat[r][c];
			level |= (1 << i);
			d += doors.charAt(i);
			mat[r][c] = '.';
			solve(level, r, c, steps, d);
			mat[r][c] = (char)i;
		}
		else {
			solve(level, r + 1, c, steps + 1, d);
			solve(level, r - 1, c, steps + 1, d);
			solve(level, r, c + 1, steps + 1, d);
			solve(level, r, c - 1, steps + 1, d);
		}
	}
}
