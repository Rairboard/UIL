/*
 *UIL Computer Science 2020
 *Invitational A Packet Solution
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Jason {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("jason.dat"));
		int N = s.nextInt();
		for ( int n = 1; n <= N; n++ )
		{
			double a = s.nextDouble();
			double b = s.nextDouble();
			double c = s.nextDouble();
			double vx = -b / ( 2 * a );
			double vy = a * vx * vx + b * vx + c;
			String updown = a > 0 ? "UPWARD" : "DOWNWARD";
			System.out.printf("(%5.3f,%5.3f)-->%s\n", vx,vy,updown);
		}
		s.close();
	}
}
