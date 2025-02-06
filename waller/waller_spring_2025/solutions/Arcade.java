import java.io.*;                                                                                                                  
import static java.lang.System.*;                                                                                                  
import java.lang.*;                                                                                                                
import java.util.*;                                                                                                                
import java.math.*;                                                                                                                
import java.text.*;                                                                                                                
public class Arcade {                                                                                                            
	public static void main(String[]args)throws Exception{                                                                         
		new Arcade().run();                                                                                                      
	}             
	int[][][] smat;
	char[][][] mat;
	public void run()throws Exception{    
		Scanner file = new Scanner(new File("arcade.dat"));                                                                      
		int times = file.nextInt();                                                                                                
		file.nextLine();                                                                                                           
		while(times-- > 0) {                                                                                                       
			  int r = file.nextInt(), c = file.nextInt(), t = file.nextInt();
			  file.nextLine();
			  smat = new int[4][r][c];
			  mat = new char[4][r][c];
			  int sr = 0, sc = 0;
			  int[] er = new int[4], ec = new int[4];
			  for(int rr = 0; rr < r; rr++) {
				  mat[0][rr] = file.nextLine().trim().toCharArray();
				  Arrays.fill(smat[0][rr], Integer.MAX_VALUE);
				  Arrays.fill(smat[1][rr], Integer.MAX_VALUE);
				  Arrays.fill(smat[2][rr], Integer.MAX_VALUE);
				  Arrays.fill(smat[3][rr], Integer.MAX_VALUE);
				  for(int cc = 0; cc < c; cc++) {
					  if(mat[0][rr][cc] == 'S') {
						  sr = rr;
						  sc = cc;
					  }
					  if(mat[0][rr][cc] == 'E') {
						  er[0] = rr;
						  ec[0] = cc;
					  }
				  }
			  }
			  for(int y = 1; y < 4; y++)
				  mat[y] = rotate(mat[y-1]);
			  for(int rr = 0; rr < r; rr++) 
				  for(int cc = 0; cc < c; cc++) {
					  if(mat[1][rr][cc] == 'E') {
						  er[1] = rr;
						  ec[1] = cc;
					  }
					  if(mat[2][rr][cc] == 'E') {
						  er[2] = rr;
						  ec[2] = cc;
					  }
					  if(mat[3][rr][cc] == 'E') {
						  er[3] = rr;
						  ec[3] = cc;
					  }
				  }
			  solve0(sr,sc,0);
			  int min = Math.min(Math.min(smat[0][er[0]][ec[0]],smat[1][er[1]][ec[1]]),
					             Math.min(smat[2][er[2]][ec[2]],smat[3][er[3]][ec[3]]));
			  System.out.println(min <= t? "Escaped the Arcade in "+min+" steps.": "Total Knockout.");
			  if(times == 212) {
				  print(smat[0]);
				  print(smat[1]);
				  print(smat[2]);
				  print(smat[3]);
			  }
		}                                                                                                                         
	} 
	
	void print(int[][]ss) {
		for(int[] i:ss)
			System.out.println(Arrays.toString(i));
	}
	
	char[][] rotate(char[][] m){
		char[][] m1 = new char[m.length][m[0].length], m2 = new char[m.length][m[0].length];
		for(int r = 0; r < m.length; r++)
			for(int c = 0; c < m[r].length; c++)
				m1[r][c] = m[c][r];
		for(int r = 0; r < m.length; r++) 
			for(int c = 0; c < m[r].length; c++)
				m2[r][c] = m1[r][m[r].length - c - 1];
		return m2;
	}
	
	public void solve0(int r, int c, int s) {
		if(r < 0 || c < 0 || r >= mat[0].length || c >= mat[0][r].length || s >= smat[0][r][c])return;
		smat[0][r][c] = s;
		if(mat[0][r][c] == 'J')
			solve1(r, c, s + 1);
		else{
			solve1(r, c, s + 1);
			solve1(r + 1, c, s + 1);
			solve1(r - 1, c, s + 1);
			solve1(r, c + 1, s + 1);
			solve1(r, c - 1, s + 1);
		}
	}
	
	public void solve1(int r, int c, int s) {
		if(r < 0 || c < 0 || r >= mat[1].length || c >= mat[1][r].length || s >= smat[1][r][c])return;
		smat[1][r][c] = s;
		if(mat[1][r][c] == 'J')
			solve2(r, c, s + 1);
		else{
			solve2(r, c, s + 1);
			solve2(r + 1, c, s + 1);
			solve2(r - 1, c, s + 1);
			solve2(r, c + 1, s + 1);
			solve2(r, c - 1, s + 1);
		}
	}
	
	public void solve2(int r, int c, int s) {
		if(r < 0 || c < 0 || r >= mat[2].length || c >= mat[2][r].length || s >= smat[2][r][c])return;
		smat[2][r][c] = s;
		if(mat[2][r][c] == 'J')
			solve3(r, c, s + 1);
		else{
			solve3(r, c, s + 1);
			solve3(r + 1, c, s + 1);
			solve3(r - 1, c, s + 1);
			solve3(r, c + 1, s + 1);
			solve3(r, c - 1, s + 1);
		}
	}
	
	public void solve3(int r, int c, int s) {
		if(r < 0 || c < 0 || r >= mat[3].length || c >= mat[3][r].length || s >= smat[3][r][c])return;
		smat[3][r][c] = s;
		if(mat[3][r][c] == 'J')
			solve0(r, c, s + 1);
		else{
			solve0(r, c, s + 1);
			solve0(r + 1, c, s + 1);
			solve0(r - 1, c, s + 1);
			solve0(r, c + 1, s + 1);
			solve0(r, c - 1, s + 1);
		}
	}
}                                                                                                                                  
                                                                                                                                   