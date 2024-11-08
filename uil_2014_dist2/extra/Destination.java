import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Destination {
	// holds values from input; can be used in non-static methods
	int currentX, currentY, endX, endY, numLines, distance;
	String direction;

	/**
	 * Actual method
	 * @throws FileNotFoundException 
	 */
	public Destination() throws FileNotFoundException {
		// open scanner then read in how many test cases there will be
		Scanner sc = new Scanner(new File("destination.dat"));
		int t = sc.nextInt();
		while (t-- > 0) {
			
			// read in first line
			currentX = sc.nextInt();
			currentY = sc.nextInt();
			endX = sc.nextInt();
			endY = sc.nextInt();
			numLines = sc.nextInt();
			boolean done = false;
			
			// check if started on destination
			if (currentX == endX && currentY == endY) {
				System.out.println(0);
				done = true;
			}
			
			// current move being checked
			int i = 1;
			//if destination has been found yet
			
			// iterate through all moves
			for (; i <= numLines; i++) {
				direction = sc.next();
				distance = sc.nextInt();
				// print out only first time destination is reached
				if (!done && move()) {
					System.out.println(i);
					done = true;
				}
			}
			//if destination was never reached, print out text
			if (!done)
				System.out.println("You didn't make it");
		}
		sc.close();
	}

	private boolean move() {
		boolean destination;
		int temp;
		
		// normalize text and execute based on given direction
		// change to new location after move and see if the destination is ever passed over
		// this will happen when 
		switch (direction.toLowerCase()) {
		case "north":
			temp = currentY;
			currentY += distance;
			return (currentX == endX && temp < endY && currentY >= endY);
		case "south":
			temp = currentY;
			currentY -= distance;
			return (currentX == endX && temp > endY && currentY <= endY);
		case "west":
			temp = currentX;
			currentX -= distance;
			return (currentY == endY && temp > endX && currentX <= endX);
		case "east":
			temp = currentX;
			currentX += distance;
			return (currentY == endY && temp < endX && currentX >= endX);
		}
		// Will never be run, just there to be complete
		return false;
	}

	public static void main(String[] args) throws FileNotFoundException {
		// run everything in non-static context
		 new Destination();
	}

}
