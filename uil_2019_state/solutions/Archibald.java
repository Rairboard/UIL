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


public class Archibald
{
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("archibald.dat"));
		int reps = file.nextInt();
		for(int q=0; q<reps; q++)
		{
			var x = file.nextInt();
			for(int a = 0; a < x; a++) {
				for(int b = 0; b <= a; b++) {
					System.out.print("@");
				}
				System.out.println("");
			}
			System.out.println("");
			
		}
	}

	public static void main(String[] args)throws Exception
	{
		Archibald a=new Archibald();
		a.run();
	}

}