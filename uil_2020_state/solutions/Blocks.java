import java.io.*;
import java.util.*;

public class Blocks {
	public void run() throws Throwable {
		Scanner file = new Scanner(new File("blocks.dat"));
		int times = file.nextInt();
		file.nextLine();
		for (int asdf = 0; asdf < times; asdf++) {
			int [][] mat = new int [3][3];
			for(int i = 0; i < 9; i++) {
				mat[i/3][i%3] = i+1;
			}
			int [][] smat = new int [3][3];
			long d = file.nextLong();
			for(int i = 0; i < d% 4; i++) {
				for(int r = 0; r < mat.length; r++) {
					for(int c = 0; c < mat[r].length; c++) {
						smat[r][c] = mat[mat.length - 1 - c][r];
					}
				}
				mat = smat;
				smat = new int [3][3];
			}
			for(int r = 0; r < mat.length; r++) {
				for(int c = 0; c < mat.length; c++) {
					System.out.print(mat[r][c] + " ");
				}
				System.out.println();
			}
			System.out.println("- - - ");
		}
	}

	public static void main(String[] args) throws Throwable {
		new Blocks().run();
	}

}