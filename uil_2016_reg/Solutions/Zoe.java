/**
 *UIL solution to ZOE -  Region 2016
 */
 
import java.io.*;
import java.util.*;
import static java.lang.System.*;
public class Zoe {
	public static void main(String [] args) throws FileNotFoundException {
//		Scanner k = new Scanner(in);
		Scanner f = new Scanner(new File("zoe.dat"));
		Calendar cal = Calendar.getInstance();
		cal.set(2016,4,25);
//		out.printf("%tD\n",cal);
		while(f.hasNext()) {
			cal.set(2016,4,25);
			cal.set(Calendar.DAY_OF_YEAR,cal.get(Calendar.DAY_OF_YEAR)-f.nextInt());
			out.printf("%tD\n",cal);
		}

	}
}
/*
Test Data:
10
1
86
30
56
4
1
100
0
200
300
365
500

Test Output:
05/15/16
05/24/16
02/29/16
04/25/16
03/30/16
05/21/16
05/24/16
02/15/16
05/25/16
11/07/15
07/30/15
05/26/15
01/11/15
	
*/