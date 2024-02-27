/*
 *UIL Computer Science 2020
 *District Packet Solution
 */
import java.util.*;
import java.io.*;
import static java.lang.System.out;

public class Brittany {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("brittany.dat"));
		int count = 0;
		float sum = 0;
		while (s.hasNext()) {
			sum += s.nextFloat();
			count++;
		}
		out.printf("%4.2f %4.2f\n", sum, sum/count);
		s.close();
	}
}
