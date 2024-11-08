/*
 *UIL Computer Science 2020
 *Region Packet Solution
 */
import static java.lang.System.out;
import java.util.*;
import java.io.*;
public class Bruce {

	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("bruce.dat"));
		f.nextInt();
		while(f.hasNextInt()) {
			int area = f.nextInt();
			double perimeter = Math.sqrt(area)*4;
			out.printf("%1.4f\n",perimeter);
		}
		f.close();

	}

}
