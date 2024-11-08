import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

			//change the class name
public class Percentage
{
	private double theoretical, actual;
	private List<String> numberList;
	private double sum, count;
	private double percentage;
	private double[] results;
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("percentage.dat"));
		
			//read in the number at the top of the data file
		int times = file.nextInt(); 
			//pick up the left over enter key
		file.nextLine();
		
			//read in each data set
		for(int asdf = 0; asdf<times; asdf++)
		{
			percentage = 0;
			count = 0;
			actual = 0.0;
			sum = 0;
			theoretical = file.nextInt();
			file.nextLine();
			String numbers = file.nextLine();
			numberList = new ArrayList<String>(Arrays.asList(numbers.split(" ")));
			results = new double[numberList.size()];

			for (int i = 0; i < numberList.size(); i++) {
    		try {
        		results[i] = Integer.parseInt(numberList.get(i));
    		} catch (NumberFormatException nfe) {};
			}
			for(int i = 0; i < results.length; i++){
				sum+=results[i];
				count+=1;
			}
			actual = sum/count;
			
			percentage = Math.abs(((actual - theoretical)/theoretical)*100);
			if(percentage < 5){
				System.out.println( "Accurate");
			}
			else{
				System.out.println("Inaccurate");
			}			
		}
	}

	public static void main(String[] args) throws Exception
	{
			//change this to whatever your class name is
		new Percentage().run();
	}	
	
}