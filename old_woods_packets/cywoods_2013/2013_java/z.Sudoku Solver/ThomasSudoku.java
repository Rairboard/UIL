import java.io.*;
import java.util.*;
import java.text.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Character.*;
import static java.util.Collections.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;


class SudokuSolver
{
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("SudokuGrids.dat"));
		int cases = file.nextInt();file.nextLine();
		for(int xx = 0; xx<cases; xx++){
			int xa = file.nextInt();file.nextLine();
			char[][] mat = new char[9][];
			for(int y =0; y<9; y++){
				mat[y] = file.nextLine().toCharArray();
			}
			boolean[][] row = new boolean[9][10];
			boolean[][] col = new boolean[9][10];
			boolean[][] block = new boolean[9][10];
			int[][] blockStart = {{0,3,6},{0,3,6}};
			int[][] whichBlock = new int[9][9];
			List[] unfilled = new ArrayList[9];
			for(int r = 0; r<9;r++)unfilled[r] = new ArrayList<Integer>();
			for(int r = 0; r<9; r++){
				for(int c = 0; c<9; c++){
					if(mat[r][c]=='0')unfilled[r].add(c);
					if(mat[r][c]!='0')row[r][(int)(mat[r][c]-'0')] = true;
					if(mat[r][c]!='0')col[c][(int)(mat[r][c]-'0')] = true;
				}
			}
			for(int r = 0; r<3; r++){
				for(int c = 0; c<3; c++){
					int rr = blockStart[0][r], cc = blockStart[1][c];
					for(int i = rr; i<rr+3; i++){
						for(int j = cc; j<cc+3; j++){
							whichBlock[i][j] = r*3+c;
							if(mat[i][j]!='0')block[r*3+c][mat[i][j]-'0'] = true;
						}
					}
				}
			}
			boolean changed = true;
			while(changed){
				changed = false;
				for(int r = 0; r<9; r++){
					for(int a = unfilled[r].size()-1;a>-1;a--){
						int c = (int)unfilled[r].get(a);
						boolean[] all = new boolean[10];
						for(int x = 1; x<10; x++){
							if(row[r][x]==false&&col[c][x]==false&&block[whichBlock[r][c]][x]==false){
								all[x]=true;
							}
						}
						int cnt = 0, num = -1;
						for(int x = 1; x<10; x++){
							if(all[x]){
								cnt++;
								num = x;
							}
						}
						if(cnt==1){
							mat[r][c] = (""+num).charAt(0);
							row[r][num] = true;
							col[c][num] = true;
							block[whichBlock[r][c]][num] = true;
							changed = true;
						}
					}
				}
			}
			for(int xb = 0; xb<xa; xb++){
				System.out.println(mat[file.nextInt()-1][file.nextInt()-1]);
			}
		}
	}

	public static void main(String[] args)throws Exception
	{
		SudokuSolver a=new SudokuSolver();
		a.run();
	}
}