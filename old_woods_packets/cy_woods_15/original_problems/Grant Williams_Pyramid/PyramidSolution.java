import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class PyramidSolution
{
	private int[] out;
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("judgespyramid.dat"));
		
		int times = file.nextInt(); 
		file.nextLine();

		for(int i = 0; i<times; i++)
		{
			int next = file.nextInt();
			if(next ==0){
				System.out.println("NOT BUILDABLE");
				System.out.println();
			}
			else{
				for(int x = next; x>=0; x-- ){
				out = new int[x];
				for(int k = 0; k<x; k++){
					out[k] = x;
					System.out.print(out[k]);
				}
				System.out.println();
			   }
			}
			
		}
	}

	public static void main(String[] args) throws Exception
	{
		new PyramidSolution().run();
	}	
	
}