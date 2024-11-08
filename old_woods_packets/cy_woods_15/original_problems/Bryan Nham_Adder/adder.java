import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

			//change the class name
public class adder
{
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("adderj.dat"));
		
			//read in the number at the top of the data file
		int times = file.nextInt(); 
			//pick up the left over enter key
		file.nextLine();
		
			//read in each data set
		for(int asdf = 0; asdf<times; asdf++)
		{
			int blocks = file.nextInt();
			ArrayList<Integer> nums = new ArrayList<Integer>();
			for (int i = 0; i < blocks; i++) {
				int n = file.nextInt();
				nums.add(n);
			}
			int favNum = file.nextInt();
			if (isAdder(0, nums, favNum)) {
				System.out.println("Yes.");
			}
			else {
				System.out.println("Not Possible.");
			}
		}
	}
	
	public boolean isAdder(int spot, ArrayList<Integer> numbers, int favNum) {
		if (spot >= numbers.size()) {
    		return (favNum == 0);
  		} 
		return isAdder(spot + 1, numbers, favNum) || isAdder(spot + 1, numbers, favNum - numbers.get(spot));
	}

	public static void main(String[] args) throws Exception
	{
			//change this to whatever your class name is
		new adder().run();
	}	
	
}