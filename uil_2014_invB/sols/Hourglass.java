import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Hourglass {
	public static void main (String [] args) throws FileNotFoundException {
		
		Scanner in = new Scanner (new File ("hourglass.dat"));
		int noTests = in.nextInt();
		for (int i = 0; i < noTests; i++) {
			drawHourglass(in.nextInt());
		}
		in.close();
	}
	
	public static void drawHourglass (int w) {
		
		for (int row = 0; row < w/2+1; row++) {
			for (int j = 0; j < row; j ++) {
				System.out.print(" ");
			}
			for (int i = 0; i < w - row*2; i ++ ) {
				System.out.print("*");
			}
			System.out.println();		
		}
		for (int row = w/2-1; row >= 0; row--) {
			for (int j = 0; j < row; j ++) {
				System.out.print(" ");
			}
			for (int i = 0; i < w - row*2; i ++ ) {
				System.out.print("*");
			}
			System.out.println();		
		}		
	}
}
