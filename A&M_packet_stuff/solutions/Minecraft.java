import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
public class Minecraft {
	public static void main(String[]args)throws Exception{
		new Minecraft().run();
	}
	
	int[][] smat;
	char[][] mat;
	boolean boots;
	
	public void run()throws Exception{
		Scanner file=new Scanner(new File("minecraft.dat"));
		int times=file.nextInt();
		file.nextLine();
		while(times-->0) {
			int rr = file.nextInt(), cc = file.nextInt(), h = file.nextInt();
			int sr = -1, sc = -1, er = 0, ec = 0;
			boots = file.nextBoolean();
			file.nextLine();
			smat = new int[rr][cc];
			mat = new char[rr][cc];
			ArrayList<Integer> mobs = new ArrayList<Integer>();
			for(int r = 0; r < rr; r++) {
				mat[r] = file.nextLine().trim().toCharArray();
				Arrays.fill(smat[r], 1);
				for(int c = 0; c < cc; c++) {
					//save locations of mobs, starting and ending points.
					if(mat[r][c] == 'S') {
						sr = r;
						sc = c;
					}
					else if(mat[r][c] == 'O') {
						er = r;
						ec = c;
					}
					else if(mat[r][c] == 'G') {
						mobs.add(3);
						mobs.add(r);
						mobs.add(c);
					}
					else if(mat[r][c] == 'b' || (!boots && mat[r][c] =='p')) {
						mobs.add(2);
						mobs.add(r);
						mobs.add(c);
					}
				}
			}
			//mark off mob areas
			mark(mobs);
			//solve the problem
			solve(sr, sc, h, 0, 0);
			//now check ending location to see if maze is solvable
			System.out.println(smat[er][ec] != 1? "Nether gonna give you up.": "Anether one.");
			//System.out.println(Arrays.deepToString(smat));
		}
	}
	
	//method for marking off area around impassable mobs.
	public void mark(ArrayList<Integer> mobs) {
		while(!mobs.isEmpty()) {
			int d = mobs.remove(0);
			int r = mobs.remove(0);
			int c = mobs.remove(0);
			int rl = r - d < 0? 0: r - d;
			int rh = r + d >= mat.length? mat.length - 1: r + d;
			int cl = c - d < 0? 0: c - d;
			int ch = c + d >= mat[r].length? mat[r].length - 1: c + d;
			for(int i = -d; i <= d; i++) {
				int ci = c + i;
				int ri = r + i;
				if(ci < 0) ci = 0;
				if(ci >= mat[r].length) ci = mat[r].length - 1;
				if(ri < 0) ri = 0;
				if(ri >= mat.length) ri = mat.length - 1;
				mat[rl][ci] = mat[rh][ci] = mat[ri][cl] = mat[ri][ch] = '#';
			}
		}
	}
	
	public void solve(int r, int c, int h, int fs, int s) {
		//check that we're in bounds, on the optimal path, and allowed to be in the current position
		if(r < 0 || c < 0 || r >= mat.length || c >= mat[r].length || smat[r][c] > h ||
				"p#W".contains(""+mat[r][c]) || h < 2) return;
		//mark our position with the number of hunger bars we have left
		smat[r][c] = h;
		//subtract hunger based on steps
		if(s >= 4) {
			h--;
			s -= 5;
		}
		//check for special outputs
		if(mat[r][c] == 'H') {
			mat[r][c] = '.';
			solver(r, c, h + 6, fs, s + 1);
			mat[r][c] = 'H';
		}
		else if(mat[r][c] == 's') {
			if(boots)
				solver(r, c, h, fs, s + 1);
			else
				solver(r, c, h, fs, s + 2);
		}
		else if (mat[r][c] == 'f') {
			if(fs == 4) {
				h--;
				fs -= 5;
			}
			solver(r, c, h, fs + 1, s + 1);
		}
		else {
			solver(r, c, h, fs, s + 1);
		}
	}
	
	//method to make my life a little easier.
	public void solver(int r, int c, int h, int fs, int s) {
		solve(r + 1, c, h, fs, s);
		solve(r - 1, c, h, fs, s);
		solve(r, c + 1, h, fs, s);
		solve(r, c - 1, h, fs, s);
	}
}
