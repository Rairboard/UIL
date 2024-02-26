import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			String s = sc.next();
			for (int len = 1; len <= s.length(); len++) {
				if (s.length() % len == 0) {
					String sub = s.substring(0, len);
					boolean good = true;
					for (int i = 0; i < s.length(); i += len) {
						if (!s.substring(i, i + len).equals(sub)) {
							good = false;
						}
					}
					if (good) {
						System.out.println(sub);
						break;
					}
				}
			}
		}
		sc.close();
	}
}
