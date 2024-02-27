import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DryRun {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("dryrun.dat"));
		int count = s.nextInt();
		int nbr = 0;
		while ( nbr < count )
		{
			String m = s.next();
			System.out.println("I like " + m + ".");
			nbr = nbr + 1;
		}
		s.close();
	}
}
