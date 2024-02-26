/*
 *UIL Computer Science 2020
 *Invitational A Packet Solution
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Keith {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("keith.dat"));
		double min = Double.MAX_VALUE;
		double max = 0;
		while ( s.hasNext() ) {
			double d = s.nextDouble();
			double t = s.nextDouble();
			double rate = d / t;
			if ( rate > max ) max = rate;
			if ( rate < min ) min = rate;
			System.out.printf("%4.2f\n", rate);
		}
		System.out.printf("Min = %.2f\n", min);
		System.out.printf("Max = %.2f\n", max);
		s.close();
	}
}
