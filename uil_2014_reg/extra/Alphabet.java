/*Region UIL 2014 Solution - #1 Alphabet
Test data
11
AZ
ZA
CCXX
BMYN
ABCDEFGHIJKLMNOPQRSTUVWXYZ
ZYXWVUTSRQPONMLKJIHGFEDCBA
AABYZZ
ABCDZYXW
AAAAAA
MLKJIHGFEDCBAZYXWVUTSRQPON
AZCZA

Output
YES
YES
YES
NO
YES
YES
YES
NO
NO
YES
NO

*/
import java.io.*;
import java.util.*;

public class Alphabet {

	public static final String forward = "abcdefghijklmnopqrstuvwxyz".toUpperCase();
	public static final String backward = new StringBuffer(forward).reverse().toString();

	public static void main(String args[]) throws IOException {
		Scanner scan = new Scanner(new File("alphabet.dat"));
		int T = scan.nextInt();

		while (T-- > 0) {
			char[] line = scan.next().toCharArray();
			if (line.length % 2 == 1) {
				System.out.println("NO");
				continue;
			}
			System.out.println((valid(line)) ? "YES" : "NO");
		}

		scan.close();
	}

	public static boolean opposite(char a, char b) {
		int index = forward.indexOf(a);
		return backward.charAt(index) == b;
	}

	public static boolean valid(char[] line) {
		Stack<Character> stack = new Stack<Character>();

		for (char c : line) {
			if (stack.isEmpty()) {
				stack.push(c);
			} else {
				char a = stack.peek();
				if (opposite(a, c)) {
					stack.pop();
				} else {
					stack.push(c);
				}
			}
		}

		return stack.isEmpty();
	}
}