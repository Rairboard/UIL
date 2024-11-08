import java.util.*;
import java.io.*;

public class Secure {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("secure.in"));
		int t = in.nextInt();
		for (int g = 0; g < t; g++) {
			int n = in.nextInt();
			int children[] = new int[n];

			// count the number of children for each node
			for (int i = 0; i < n - 1; i++) {
				int parent = in.nextInt();
				children[parent - 1]++;// convert to 0-indexing
			}

			// count the number of pendant children in the graph
			int pendants = 0;
			for (int i = 1; i < n; i++) {
				if (children[i] == 0)
					pendants++;
			}
			// if the root has only 1 child, it is a pendant
			if (children[0] <= 1)
				pendants++;
			// add 1 to round up in division
			System.out.println((pendants + 1) / 2);
		}
	}
}