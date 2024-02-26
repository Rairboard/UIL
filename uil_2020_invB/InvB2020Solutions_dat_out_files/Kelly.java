/*
 *UIL Computer Science 2020
 *Invitational B Packet Solution
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Kelly {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("kelly.dat"));
		String code = " ABCDEFGHIJLMNOPQRSTUVWXYZ";
		while (s.hasNext()) {
			Scanner data = new Scanner(s.nextLine());
			while (data.hasNextInt()) {
				int r = data.nextInt();
				int c = data.nextInt();
				if (r == 0) System.out.print(' ');
				else System.out.print(code.charAt((r - 1) * 5 + c));
			}
			System.out.println();
			data.close();
		}
		s.close();
	}
}
