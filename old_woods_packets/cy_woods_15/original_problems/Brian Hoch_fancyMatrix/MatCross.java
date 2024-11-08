import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

			//change the class name
public class MatCross
{
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("mcj.dat"));
		
			//read in the number at the top of the data file
		int times = file.nextInt(); 
			//pick up the left over enter key
		file.nextLine();
		
			//read in each data set
		for(int asdf = 0; asdf<times; asdf++)
		{
			int r = file.nextInt();
			int c = file.nextInt();
			String[][] mat = new String[r][c];
			for(String[] t : mat){
				Arrays.fill(t," ");
			}
			for(int i = 0;i<mat.length;i++){
				mat[i][0]="#";
				mat[i][mat[i].length-1] = "#";
				mat[mat[i].length-1][i] = "#";
				mat[0][i]="#";
			}
			for(int q=1;q<mat.length-1;q=q+2){
				for(int w = 1;w<mat[q].length-1;w=w+2){
					mat[q][w]="#";
					mat[q+1][w+1]="#";
				}
			}
			for(String[] s : mat){
				System.out.println(Arrays.toString(s).replace(",", "").replaceAll("[\\[\\]\\,]","") );
			}
		}
	}

	public static void main(String[] args) throws Exception
	{
			//change this to whatever your class name is
		new MatCross().run();
	}	
	
}