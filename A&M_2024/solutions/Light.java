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


public class Light
{
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("light.dat"));
		int reps = file.nextInt();
		for(int q=0; q<reps; q++)
		{
			int t = file.nextInt();
			int max = file.nextInt();
			int stops = file.nextInt();
			
			if(t+(stops*2)<=max) {
				System.out.println("yes");
			}
			else {
				System.out.println("no");
			}
		}
	}

	public static void main(String[] args)throws Exception
	{
		Light a=new Light();
		a.run();
	}

}