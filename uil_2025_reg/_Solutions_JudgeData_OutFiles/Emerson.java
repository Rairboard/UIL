import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Emerson {
	public static void main(String[]args)throws Exception{
		new Emerson().run();
	}
	
	int[][][]smat;
	char[][]mat;
	
	public void run()throws Exception{
		Scanner file = new Scanner(new File("emerson.dat"));
		int times = file.nextInt();
		file.nextLine();
		while(times-- > 0) {
			int rr = file.nextInt(), cc = file.nextInt(), p = file.nextInt();
			int sr = -1, sc = -1, er = -1, ec = -1;
			file.nextLine();
			smat = new int[p + 1][rr][cc];
			mat = new char[rr][cc];
			for(int r = 0; r < rr; r++) {
				for(int i = 0; i <= p; i++)
					Arrays.fill(smat[i][r], Integer.MAX_VALUE);
				mat[r] = file.nextLine().trim().toCharArray();
				for(int c = 0; c < cc; c++) {
					if(mat[r][c] == 'S') {
						sr = r;
						sc = c;
					}
					if(mat[r][c] == 'E') {
						er = r;
						ec = c;
					}
				}
			}
			for(int r = 0; r < rr; r++) {
				for(int c = 0; c < cc; c++) {
					if(mat[r][c] == '<') {
						if(c + 1 < cc && !("<>^v").contains(""+mat[r][c + 1]))
							mat[r][c + 1] = '#';
						if(c + 2 < cc && !("<>^v").contains(""+mat[r][c + 2]))
							mat[r][c + 2] = '#';
						mat[r][c] = '#';
					}
					if(mat[r][c] == '^') {
						if(r + 1 < rr && !("<>^v").contains(""+mat[r + 1][c])) 
							mat[r + 1][c] = '#';
						if(r + 2 < rr && !("<>^v").contains(""+mat[r + 2][c]))
							mat[r + 2][c] = '#';
						mat[r][c] = '#';
					}
					if(mat[r][c] == '>') {
						if(c - 1 >= 0 && !("<>^v").contains(""+mat[r][c - 1]))
							mat[r][c - 1] = '#';
						if(c - 2 >= 0 && !("<>^v").contains(""+mat[r][c - 2]))
							mat[r][c - 2] = '#';
						mat[r][c] = '#';
					}
					if(mat[r][c] == 'v') {
						if(r - 1 >= 0 && !("<>^v").contains(""+mat[r - 1][c]))
							mat[r - 1][c] = '#';
						if(r - 2 >= 0 && !("<>^v").contains(""+mat[r - 2][c]))
							mat[r - 2][c] = '#';
						mat[r][c] = '#';
					}
				}
			}
//			for(char[] f:mat)
//				System.out.println(f);
			solve(sr, sc, p, 0);
			int min = Integer.MAX_VALUE;
			for(int[][] s:smat)
				min = Math.min(s[er][ec], min);
			System.out.println(min == Integer.MAX_VALUE? -1: min);
		}
	}
	
	public void solve(int r, int c, int p, int s) {
		//System.out.println(p+" "+r+" "+c+" "+mat[0].length);
		if(r < 0 || c < 0 || r >= mat.length || c >= mat[r].length || mat[r][c] == '#' ||smat[p][r][c] <= s)
			return;
		smat[p][r][c] = s;
		if(p != 0) {
			solve(r + 2, c, p - 1, s);
			solve(r + 1, c + 1, p - 1, s);
			solve(r + 1, c - 1, p - 1, s);
			solve(r - 2, c, p - 1, s);
			solve(r, c + 2, p - 1, s);
			solve(r - 1, c + 1, p - 1, s);
			solve(r - 1, c - 1, p - 1, s);
			solve(r, c - 2, p - 1, s);
		}
		solve(r + 1, c, p, s + 1);
		solve(r - 1, c, p, s + 1);
		solve(r, c + 1, p, s + 1);
		solve(r, c - 1, p, s + 1);
	}
}
