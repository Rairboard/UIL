import java.io.*;
import java.util.*;

public class Risk {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("risk.dat"));
		int numcases = in.nextInt();
		while (numcases-- > 0) {
			long seed = in.nextLong();
			Random rand = new Random(seed);
			int A = in.nextInt();
			int D = in.nextInt();
			ArrayList<Integer> aRolls = new ArrayList<Integer>();
			ArrayList<Integer> bRolls = new ArrayList<Integer>();
			while (A > 0 && D > 0) {
				aRolls.clear();
				bRolls.clear();
				int a = Math.min(A, 3);
				int b = Math.min(D, 2);
				for (int i = 0; i < a; i++) {
					// generating a roll in [0, 5] is the same as [1, 6]
					aRolls.add(rand.nextInt(6));
				}
				Collections.sort(aRolls);
				Collections.reverse(aRolls);
				for (int i = 0; i < b; i++) {
					bRolls.add(rand.nextInt(6));
				}
				Collections.sort(bRolls);
				Collections.reverse(bRolls);
				while (!aRolls.isEmpty() && !bRolls.isEmpty()) {
					int atk = aRolls.remove(0);
					int def = bRolls.remove(0);
					if (atk > def) {
						D--;
					} else {
						A--;
					}
				}
			}
			System.out.println(A + " "  + D);
		}
	}
}
