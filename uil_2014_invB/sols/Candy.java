import java.util.*;
import java.io.*;

public class Candy {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("candy.dat"));

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0 ) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int count = 0;
			for (int i = 0; i < k; i++) {
				int candies = Integer.parseInt(st.nextToken());
				if (candies != 0 && candies % n == 0) {
					count++;
				}
			}
			System.out.println(count);
		}

		br.close();
	}
}