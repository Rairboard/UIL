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


public class Chris
{
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("chris.dat"));
		int reps = file.nextInt();
		for(int q=0; q<reps; q++)
		{
			int size = file.nextInt();
			int cost = 0;
			String[][] mat = new String[size][size];
			
			for(int x = 0; x<size;x++) {
				mat[x]=file.next().split("");
			}
			
			for(int a = 0; a<size;a++) {
				for(int b = 0; b<size; b++) {
					if(mat[a][b].equals("*")) {
						cost += 150;
						}
				}
			}
			
			System.out.println("$"+cost);
			
		}
	}

	public static void main(String[] args)throws Exception
	{
		Chris a=new Chris();
		a.run();
	}

}