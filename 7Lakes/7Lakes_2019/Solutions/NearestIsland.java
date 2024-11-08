import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Island {
	public static void main(String[] args) throws IOException {
		File file = new File("nearestisland.in");
		Scanner input = new Scanner(file);
		
		final double[] first = {input.nextDouble(), input.nextDouble()};
		double[] nearest = {-1.0, -1.0};
		double nearestDistance = Double.MAX_VALUE;
		
		while (input.hasNextDouble()) {
			double[] point = {input.nextDouble(), input.nextDouble()};
			double distance = Math.sqrt(Math.pow(first[0] - point[0], 2) + Math.pow(first[1] - point[1], 2));
			
			nearest = (distance < nearestDistance) ? point : nearest;
			nearestDistance = (distance < nearestDistance) ? distance : nearestDistance;
		}
		
		System.out.println(Arrays.toString(nearest));
		input.close();
	}
}