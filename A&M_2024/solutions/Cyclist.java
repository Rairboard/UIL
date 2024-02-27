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


public class Cyclist
{
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("cyclist.dat"));
		
		int reps = file.nextInt();
		int[] nums = new int[reps];
		
		String[] words= {"zero","one","two","three","four","five","six","seven","eight","nine"};
		
		for(int q=0; q<reps; q++)
		{
			nums[q]=file.nextInt();
		}
		
		
		
		int start=0;
		for(int a = 0; a<nums.length;a++) {
			
			if(nums[a]==9) {
				int stop=a;
				
				int[] sorted = new int[stop-start+1];
				int pos=0;
				for(int x = start; x<=stop;x++) {
					sorted[pos]=nums[x];
					pos++;
				}
				
				
				Arrays.sort(sorted);
				
				System.out.print("[");
				
				for(int x = 0;x<sorted.length;x++) {
					if(x!=sorted.length-1) {
						System.out.print(words[sorted[x]]+",");
					}
					else {
						System.out.print(words[sorted[x]]);
					}
				}
				

				System.out.print("]");
				
				System.out.println();
				
				
				
				
				start = a+1;
				
			}
			else {
				
			}
			
			
			
		}
		
		
	}

	public static void main(String[] args)throws Exception
	{
		Cyclist a=new Cyclist();
		a.run();
	}

}