import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;

public class QuarterbackRating {
	public static void main(String[] args) throws Exception {
		Scanner file = new Scanner(new File("quarterback.dat"));
		
		double times = file.nextInt();
		file.nextLine();
		
		for(double asdf = 0; asdf<times; asdf++){
			double[] stats = new double[5];
			for (int c = 0; c < 5; c++) {
				stats[c] = file.nextDouble();
			}
            file.nextLine();
			System.out.printf("%.2f\n", all(stats[0], stats[3], stats[4], stats[2], stats[1]));
		}
	}
	
	public static double a(double comp, double att) {
		return ((comp/att - 0.3) * 5);
	}	
	public static double b(double yds, double att) {
		return (((yds/att) - 3.0) / 4);
	}	
	public static double c(double td, double att) {
		return ((td/att) * 20);
	}
	public static double d(double in, double att) {
		return (2.375 - ((in/att) * 25));
	}
	public static double mm(double d) {
		return Math.max(0,Math.min(d,2.375));
	}
	public static double all(double comp, double yds, double td, double in, double att) {
		return (((mm(a(comp, att)) + mm(b(yds, att)) + mm(c(td, att)) + mm(d(in, att))) / 6) * 100);
	}
	
}