//Solution - UIL Region 2019
import static java.lang.System.*;
import java.io.*;
import java.util.*;

public class Callen {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner data = new Scanner(new File("callen.dat"));

		do {
			int temp1 = data.nextInt();
			int temp2 = data.nextInt();
			int tempstep = data.nextInt();
			int wind1 = data.nextInt();
			int wind2 = data.nextInt();
			int windstep = data.nextInt();

			if (temp2 > temp1) {
				int temp = temp1;
				temp1 = temp2;
				temp2 = temp;
			}
			if (wind2 < wind1) {
				int wind = wind1;
				wind1 = wind2;
				wind2 = wind;
			}
			out.println("       Wind Speeds");
			out.print("  Temps");
			for (int wind = wind1; wind <= wind2; wind += windstep)
				out.printf("%7d", wind);
			out.println();

			for (int temp = temp1; temp >= temp2; temp -= tempstep) {
				out.printf("%7d", temp);
				for (int wind = wind1; wind <= wind2; wind += windstep) {
					double windchill = 35.74 + 0.6215 * temp
						- 35.75 * Math.pow((double)wind, 0.16)
						+ 0.4275 * temp * Math.pow((double)wind, 0.16);
					out.printf("%7.1f", windchill);
				}
				out.println();
			}
			out.println("*************************");
		} while (data.hasNextInt());
		data.close();
	}
}
