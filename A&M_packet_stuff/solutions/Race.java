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


public class Race
{
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("race.dat"));
		int reps = file.nextInt();
		for(int q=0; q<reps; q++)
		{
			boolean escape = false;
			int w = file.nextInt();
			int h = file.nextInt();
			String[][] strs = new String[h][w];
			for(int a = 0; a<h; a++) {
				strs[a]=file.next().split("");
			}
			
			for(int a = 0; a<h; a++) {
				if(strs[a][0].equals("#")||strs[a][h-1].equals("#")) {
					escape=true;
				}
			}
			for(int a = 0; a<w; a++) {
				if(strs[0][a].equals("#")||strs[h-1][a].equals("#")) {
					escape=true;
				}
			}
			
			if(escape) {
				System.out.println("OUTSTANDING. I can escape from my predicament");
			}
			else {
				System.out.println("OH NO. I am very stuck and must call for help");
			}
		}
	}

	public static void main(String[] args)throws Exception
	{
		Race a=new Race();
		a.run();
	}

}