import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Distance {

	public static void main(String[] args) throws FileNotFoundException {
		// read in number of test cases
		Scanner sc = new Scanner(new File("distance.dat"));
		int t = sc.nextInt();
		while(t-- > 0){
			// read in two values then run through simulation
			int r = sc.nextInt();
			int n = sc.nextInt();
			calculate(r, n);
		}
	}

	private static void calculate(int r, int n) {
		// instantiate random object and declare variables
		Random rand = new Random(r);
		double sum = 0, dist;
		int x1, x2, y1, y2, deltaX, deltaY;
		
		for(int i = 0; i < n; i++){
			// generate the 4 variables with bounds specified in instructions
			x1 = rand.nextInt(1000);
			y1 = rand.nextInt(1000);
			x2 = rand.nextInt(1000);
			y2 = rand.nextInt(1000);
			// pythagorean theorem
			deltaX = x2 - x1;
			deltaY = y2 - y1;
			dist = Math.sqrt(deltaX*deltaX+deltaY*deltaY);
			// truncate to 3 decimal places by subtracting off extra
			sum += dist - dist % 0.001;
		}
		
		// print out answer rounded to three decimal places
		System.out.printf("%.3f%n", sum/n);
	}

}
