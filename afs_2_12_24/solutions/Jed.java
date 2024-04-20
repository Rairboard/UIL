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


public class Jed
{
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("jed.dat"));
		int reps = file.nextInt();
		for(int a = 0; a < reps; a++) {
			
			var s = file.next();
			var r = new String[s.length()+1][s.length()+1];
			
			//create
			for(int z = 0; z< s.length();z++) {
				r[0][z] = s.substring(z,z+1);
				r[s.length()][s.length()-z] = s.substring(z,z+1);
				r[z][s.length()] = s.substring(z,z+1);
				r[s.length()-z][0] = s.substring(z,z+1);
			}
			
			
			//print
			for(int z = 0; z< r.length; z++ ) {
				for(int y = 0; y < r.length; y++) {
					if(r[z][y]==null) {
						System.out.print(" ");
					}
					else {
					System.out.print(r[z][y]);
					}
					
				}
				System.out.println("");
			}
			System.out.println("");
		
				
		}
	}

	public static void main(String[] args)throws Exception
	{
		Jed a=new Jed();
		a.run();
	}

}