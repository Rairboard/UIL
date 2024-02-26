/*
 *UIL Computer Science 2020
 *Invitational B Packet - Solution
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
public class Emilio {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("emilio.dat"));
		int T = s.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = s.nextInt();
			float [] data = new float[N];
			for (int i = 0; i < N; i++)
				data[i] = s.nextFloat();
			Arrays.sort(data);
			float sumlow = 0;
			float sumhigh = 0;
			for (int i = 0; i < 10; i++) {
				sumlow += data[i];
				sumhigh += data[N-1-i];
			}
			System.out.printf("%d: %3.1f\n", t, sumhigh / 10);
			System.out.printf("%d: %3.1f\n", t, sumlow / 10);
			System.out.println("------");
		}
		s.close();
	}
}
