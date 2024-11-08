import java.util.*;
import java.io.*;

public class Skyline {
	public static void main(String args[]) throws Exception {
		Scanner scan = new Scanner(new File("skyline.dat"));

		int test_cases = scan.nextInt();

		while (test_cases-- > 0) {
			int n = scan.nextInt();
			int[] blocks = new int[n + 2];
			for (int i = 1; i <= n; i++) {
				blocks[i] = scan.nextInt();
			}
			blocks[0] = blocks[n + 1] = -1;
			int rain = rain(blocks);
			System.out.println(rain);
		}

		scan.close();
	}

	public static int rain(int[] blocks) {
		int rain = 0;

		List<Integer> maximums = new ArrayList<Integer>();
		for (int i = 1; i < blocks.length - 1; i++) {
			if (blocks[i] > blocks[i - 1] && blocks[i] >= blocks[i + 1]) {
				maximums.add(i);
			}
		}

		for (int i = 0; i < maximums.size() - 1; i++) {
			int h1 = blocks[maximums.get(i)], h2 = blocks[maximums.get(i + 1)];
			int height = Math.min(h1, h2);
			for (int j = maximums.get(i) + 1; j < maximums.get(i + 1); j++) {
				rain += Math.max(0, height - blocks[j]);
			}
		}

		return rain;
	}
}