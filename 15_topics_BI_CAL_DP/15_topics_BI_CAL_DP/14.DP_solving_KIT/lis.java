import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class lis
{
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("lis.dat"));
		//reads in the sequence into an int array
		int[] arr = Arrays.stream(file.nextLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
		//the answer is stored in this array
		//it stores the longest increasing subsequence so far
		int[] ans = new int[arr.length];
		//totallength is the current length of the LIS
		int totallength = 0;
		for(int i = 0; i < arr.length; i++) {
			int j = 0;
			//we look through the answer array to try and find
			//the first element greater than or equal to the element at i
			//after we find that index (j) we replace the element in ans with 
			//the current element, arr[i]
			for(; j < totallength && j < arr.length; j++)
				if(ans[j] >= arr[i]) break;
			//we then replace the element at j in ans with the current element
			//this works because by replacing an element with one that's less than it
			//let's take the following 2 LISes that represents inserting the element 5:
			//1 2 3 4 10
			//1 2 3 4 5
			//if you were to add any elements <= 5, nothing would change
			//but if you were to add anything > 5, it could add on to the 2nd LIS but not the 1st
			//thus it works
		ans[j] = arr[i];
			//if we hit the end, that means we made the LIS faster
			if(j == totallength) totallength++;
		}
		System.out.println("Total length is " + totallength);
		for(int i  = 0; i < totallength; i++)
			System.out.print(ans[i] + " ");
	}

	public static void main(String[] args) throws Exception
	{
		new lis().run();
	}	
	
}