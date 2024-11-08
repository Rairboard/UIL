import java.io.*;
import java.util.*;

public class Beads {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("beads.dat"));
		int numcases = Integer.parseInt(in.nextLine().trim());
		while (numcases-- > 0) {
			String line = in.nextLine().trim();
			String shortest = null;
			String temp;
			for (int i = 1; i <= line.length() / 2;i++) {
				if (line.length() % i != 0) continue;
				temp = line.substring(0, i);
				int j = i;
				boolean good = true;
				while (j < line.length()) {
					if (!line.substring(j, j + i).equals(temp)) {
						good = false;
						break;
					}
					j+= i;
				}
				if (good) {
					shortest = temp;
					break;
				}
			}
			if (shortest == null) {
				shortest = line;
			}
			System.out.println(shortest);
		}
	}
}
