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


public class Norman
{
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("norman.dat"));
		int reps = file.nextInt();
		for(int q=0; q<reps; q++)
		{
			var a = file.nextInt();
			if(a == 13) {
				System.out.println("BAD LUCK");
			}
			else if(a%2 == 0){
				System.out.println("EVEN");
			}
			else {
				System.out.println("ODD");
			}
			
		}
	}

	public static void main(String[] args)throws Exception
	{
		Norman a=new Norman();
		a.run();
	}

}