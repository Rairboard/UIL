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


public class Chase
{
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("chase.dat"));
		int reps = file.nextInt();
		for(int q=0; q<reps; q++)
		{
			int size = file.nextInt();
			String[][] mat = new String[size][size];
			
			for(int x = 0; x<size;x++) {
				mat[x]=file.next().split("");
			}
			
			for(int a = 0; a<size;a++) {
				for(int b = 0; b<size; b++) {
					if(mat[a][b].equals("&")) {
						mat[a][b]="$";
						if(a+1<size && b+1<size) {
							mat[a+1][b+1]="$";
						}
						if(a<size && b+1<size) {
							mat[a][b+1]="$";
						}
						if(a+1<size && b<size) {
							mat[a+1][b]="$";
						}
						if(a-1<size && b+1<size && a-1>=0) {
							mat[a-1][b+1]="$";
						}
						if(a-1<size && b<size && a-1>=0) {
							mat[a-1][b]="$";
						}
						if(a-1<size && b-1<size && a-1>=0 && b-1>=0) {
							mat[a-1][b-1]="$";
						}
						if(a<size && b-1<size && b-1>=0) {
							mat[a][b-1]="$";
						}
						if(a+1<size && b-1<size && b-1>=0) {
							mat[a+1][b-1]="$";
						}
						
					}
				}
			}
			
			for(int x=0;x<mat.length;x++) {
				for(int y=0;y<mat.length;y++) {
					System.out.print(mat[x][y]);
				}
				System.out.println();
			}
			System.out.println();
			
		}
	}

	public static void main(String[] args)throws Exception
	{
		Chase a=new Chase();
		a.run();
	}

}