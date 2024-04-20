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


public class Cornfield
{
	
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("cornfield.dat"));
		int reps = file.nextInt();
		
		for(int q=0; q<reps; q++)
		{
			int r = file.nextInt();
			int c = file.nextInt();
			String[][] corn = new String[r][c];
			for(int a = 0; a < r; a++) {
				corn[a]=file.next().split("");
			}
			
			for(int y = 0; y<corn.length;y++) {
				for(int x = 0; x<corn[y].length;x++) {
					if(corn[y][x].equals("@")) {
						System.out.println("["+y+","+x+"]");
						break;
					}
				}
			}
		}
	}

	public static void main(String[] args)throws Exception
	{
		Cornfield a=new Cornfield();
		a.run();
	}

}