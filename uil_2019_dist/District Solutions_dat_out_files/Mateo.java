//UIL District 2019 Solution
import static java.lang.System.*;
import java.io.*;
import java.util.*;

public class Mateo {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner data = new Scanner(new File("mateo.dat"));
		while (data.hasNextDouble()) {
			double x1 = data.nextDouble();
			double x2 = data.nextDouble();
			double x = Math.min(x1, x2);
			x2 = Math.max(x1, x2);
			x1 = x;
			if (fx(x1) * fx(x2) > 0.0)
				out.println("UNKNOWN");
			else {
				x = (x1 + x2) / 2.0;
				double f = fx(x);
				do {
					if (f * fx(x1) > 0) x1 = x;
					else x2 = x;
					x = (x1 + x2) / 2.0;
					f = fx(x);
					//out.printf("x1= %f  x2= %f  x= %f  f(x)= %f\n", x1,x2,x,fx(x));
				} while (Math.abs(fx(x)) > 0.0000001);
				out.printf("%9.7f\n",x);
			}
		}
		data.close();
	}
	
	private static double fx(double x ) {
		return 1.3 * Math.pow(x, 4.0) +
				-35.1 * x * x +
				-18.2 * x + 89.7;				
	}
}
