import java.io.File;
import java.io.FileNotFoundException;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Rearrange {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Map<Character, Integer> priority = new HashMap<>();
		priority.put('+', 0);
		priority.put('-', 0);
		priority.put('*', 1);
		priority.put('/', 1);
		Deque<Character> stack = new LinkedList<Character>();
		Scanner sc = new Scanner(new File("rearrange.dat"));
		int t = sc.nextInt();
		sc.nextLine();
		Scanner line;
		String token;
		while (t-- > 0) {
			String answer = "";
			line = new Scanner(sc.nextLine());
			while (line.hasNext()) {
				token = line.next();
				if (token.matches("\\d+"))
					answer += token + " ";
				else{
					while (!stack.isEmpty()
							&& priority.get(stack.peekFirst()) >= priority
									.get(token.charAt(0)))
						answer += stack.pollFirst() + " ";
					stack.push(token.charAt(0));
				}
			}
			while (!stack.isEmpty())
				answer += stack.pollFirst() + " ";
			System.out.println(answer.substring(0, answer.length() - 1));
		}
	}

}
