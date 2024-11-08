import java.io.*;
import java.util.*;


// This algorithm iterates through the stock numbers.
// At every position, if it is a local minimum, you buy,
// otherwise if it is a local maximum you print sell
public class Stock {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("stock.dat"));
		int T = Integer.parseInt(in.nextLine().trim());
		StringTokenizer st;
		while (T-- > 0) {
			st = new StringTokenizer(in.nextLine().trim());
			int N = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			System.out.println(name);
			st = new StringTokenizer(in.nextLine().trim());
			int[] nums = new int[N];
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			if (nums[0] > nums[1])
				System.out.println("1 SELL");
			else
				System.out.println("1 BUY");
			for (int i = 1; i < N - 1; i++) {
				if (nums[i] > nums[i-1] && nums[i] > nums[i+1])
					System.out.printf("%d SELL\r\n", i + 1);
				else if (nums[i] < nums[i-1] && nums[i] < nums[i+1])
					System.out.printf("%d BUY\r\n", i + 1);
			}
			if (nums[N-2] < nums[N-1])
				System.out.printf("%d SELL\r\n", N);
			else
				System.out.printf("%d BUY\r\n", N);
		}
	}
}
