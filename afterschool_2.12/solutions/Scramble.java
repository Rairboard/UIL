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


public class Scramble
{
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("scramble.dat"));
		int reps = file.nextInt();
		String[] products = {"milk", "eggs", "wheat"};
		
		for(int q=0; q<reps; q++)
		{
			String scram = file.next();
			for(int x = 0; x < 3; x++) {
				if(scram.contains("m")) {
					System.out.println(products[0]);
					break;
				}
				if(scram.contains("g")) {
					System.out.println(products[1]);
					break;
				}
				if(scram.contains("w")) {
					System.out.println(products[2]);
					break;
				}
			}
		}
	}

	public static void main(String[] args)throws Exception
	{
		Scramble a=new Scramble();
		a.run();
	}

}