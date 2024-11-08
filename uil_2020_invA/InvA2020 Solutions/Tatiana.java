/*
 *UIL Computer Science 2020
 *Invitational A Packet Solution
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tatiana {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("tatiana.dat"));
		int months = s.nextInt();
		float [] data = new float[months];
		float sum = 0;
		for ( int m = 0; m < months; m++ ) {
			int days = s.nextInt();
			for ( int d = 0; d < days; d++ )
				data[m] += s.nextFloat();
			sum += data[m];
		}
		float avg = sum / months;
		for ( int m = 0; m < months; m++ ) {
			float diff = data[m] - avg;
			System.out.printf("%02d   %6.2f   %+7.2f\n", m+1, data[m], diff);
		}
		s.close();
	}
}
