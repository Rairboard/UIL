import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
public class Ikea {
	public static void main(String[]args)throws Exception{
		new Ikea().run();
	}
	
	char[][][]mat;
	boolean[][][][]smat;
	
	public void run()throws Exception{
		Scanner file=new Scanner(new File("ikea.dat"));
		int times=file.nextInt();
		file.nextLine();
		while(times-->0) {
			int h = file.nextInt(), r = file.nextInt(), c = file.nextInt(), f = file.nextInt();
			int sh = -1, sr = -1, sc = -1, eh = 0, er = 0, ec = 0;
			file.nextLine();
			mat = new char[h][r][c];
			smat = new boolean[f+1][h][r][c];
			for(int hh = 0; hh < h; hh++) {
				for(int rr = 0; rr < r; rr++) {
					mat[hh][rr] = file.nextLine().trim().toCharArray();
					for(int cc = 0; cc < c; cc++) {
						if(mat[hh][rr][cc] == 'S') {
							sh = hh;
							sr = rr;
							sc = cc;
						}
						if(mat[hh][rr][cc] == 'E') {
							eh = hh;
							er = rr;
							ec = cc;
						}
						if(Character.isDigit(mat[hh][rr][cc])) 
							mat[hh][rr][cc] = (char)(mat[hh][rr][cc] - '0');
					}
				}
			}
			solve(0, sh, sr, sc);
//			for(int i = 0; i < smat.length; i++) {
//				for(int j = 0; j < smat[i].length; j++)
//					System.out.println(Arrays.deepToString(smat[i][j]));
//				System.out.println(i);
//			}
			System.out.println(smat[f][eh][er][ec]? "IKEAn do it.": "IKEAnnot do it.");
		}
	}
	
	public void solve(int level, int h, int r, int c) {
		if(h < 0 || r < 0 || c < 0 || h >= mat.length || r >= mat[h].length || 
				c >= mat[h][r].length || mat[h][r][c] == '#' || smat[level][h][r][c])return;
		smat[level][h][r][c] = true;
		if(level == mat[h][r][c]) {
			//System.out.println("eififjeij");
			level++;
		}
		if(mat[h][r][c] == 'Z') {
			solve(level, h + 1, r, c);
			solve(level, h - 1, r, c);
		}
		solve(level, h, r + 1, c);
		solve(level, h, r - 1, c);
		solve(level, h, r, c + 1);
		solve(level, h, r, c - 1);
	}
}
