//UIL State 2018 - Milo - Sample Solution
import static java.lang.System.out;
import java.util.*;
import java.io.*;
public class Milo {

	public static void main(String[] args) throws IOException{
		Scanner f=new Scanner(new File("milo.dat"));
		while(f.hasNext()) {
			String romanNum=f.next();
			Queue<Integer> arabicValues=new LinkedList<Integer>();			
			 // Parse out each Roman numeral digit, convert it to an Arabic value, 
			// and then place it into a queue.			
			for(int i=0;i<romanNum.length();i++)
				arabicValues.add(arabicValue(romanNum.substring(i, i+1)));
			//Use to store the converted number.
			int arabicNum=0;
			while(!arabicValues.isEmpty()) {
				int current=arabicValues.remove();
				//If this value is equal to or greater than the next,
				//or if this is the only digit, add it to the new Arabic value.
				if(arabicValues.isEmpty()||current>=arabicValues.peek())
					arabicNum+=current;
				//Otherwise, get the next value, do the appropriate subtraction,
				//and add the difference to the new Arabic value.
				else {
					int next=arabicValues.remove();
					arabicNum=arabicNum+(next-current);
					}
				}
			out.println(arabicNum);
		}
	}
	
	public static int arabicValue(String romanDigit) {
		switch(romanDigit) {
		case "I":return 1;
		case "V":return 5;
		case "X":return 10;
		case "L":return 50;
		case "C":return 100;
		case "D":return 500;
		case "M":return 1000;
		}
		return 0;
	}
}
