import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
public class Eggs {
	public static void main(String[]args)throws Exception{
		new Eggs().run();
	}
	char[][]mat;
	boolean[][]smat;
	public void run()throws Exception{
		Scanner file=new Scanner(new File("eggs.dat"));
		int times=file.nextInt();
		file.nextLine();
		while(times-->0) {
			int r = file.nextInt(), c = file.nextInt();
			file.nextLine();
			mat = new char[r][c];
			smat = new boolean[r][c];
			int max = 0;
			for(int i=0;i<r;i++)
				mat[i] = file.nextLine().trim().toCharArray();
			for(int i=0;i<r;i++)
				for(int j=0;j<c;j++)
					if(!smat[i][j] && mat[i][j]!='_')
						max = Math.max(max, blob(i, j));
			System.out.println(max);
		}
	}
	public int blob(int r, int c){
		if(r < 0 || c < 0 || r >= mat.length || c >= mat[r].length || smat[r][c] || mat[r][c] == '_')return 0;
		smat[r][c] = true;
		return 1 + blob(r+1,c) + blob(r-1,c) + blob(r,c-1) + blob(r,c+1);
	}
}
