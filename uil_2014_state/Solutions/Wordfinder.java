import java.io.*;
import java.util.*;

public class Wordfinder {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("wordfinder.dat"));
		int N = in.nextInt();
		int R = in.nextInt();
		in.nextLine();
		ArrayList<int[]> charCounts = new ArrayList<int[]>();
		while (N-- > 0) {
			int[] charCount = new int[26];
			String line = in.nextLine().trim();
			for (char c: line.toCharArray()) {
				charCount[(int)(c-'a')]++;
			}
			charCounts.add(charCount);
		}
		while (R-- > 0) {
			int[] charCount = new int[26];
			String line = in.nextLine().trim();
			for (char c: line.toCharArray()) {
				charCount[(int)(c-'a')]++;
			}
			int count = 0;
			for (int[] wordCount : charCounts) {
				boolean allMore = true;
				for (int i = 0; i < 26; i++) {
					if (wordCount[i] > charCount[i]) {
						allMore = false;
						break;
					}
				}
				if (allMore) count++;
			}
			System.out.println(count);
		}
	}
}
