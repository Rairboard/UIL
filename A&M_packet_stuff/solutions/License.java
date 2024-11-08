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


public class License
{
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("license.dat"));
		int reps = file.nextInt();
		file.nextLine();
		for(int q=0; q<reps; q++)
		{
			String str = file.nextLine();
			for(int a = 0; a< str.length()+4;a++) {
				System.out.print("*");
			}
			System.out.println();
			System.out.println("* " + str + " *");
			for(int a = 0; a< str.length()+4;a++) {
				System.out.print("*");
			}
			System.out.println();
			System.out.println();
		}
	}

	public static void main(String[] args)throws Exception
	{
		License a=new License();
		a.run();
	}

}