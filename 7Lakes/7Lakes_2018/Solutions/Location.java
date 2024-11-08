import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Location {
  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(new File("location.in"));
		StringBuilder sb = new StringBuilder();

		int cases = in.nextInt();
		in.nextLine();

		for(int i = 0; i < cases; i++) {
			String[] x = in.nextLine().split(" ");
			sb.append(x[0] + " " + x[x.length - 1] + " ");
		}
		System.out.println(sb.toString().trim() + ".");
  }
}