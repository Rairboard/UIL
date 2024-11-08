import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class creeper {
	public static void main(String[] args) throws IOException {
		File file = new File("creeper.in");
		Scanner input = new Scanner(file);
		
		char[] characters = {'c', 'r', 'e', 'e', 'p', 'e', 'r'};
		while (input.hasNextLine()) {
			String line = input.nextLine().toLowerCase();
			String result = "";
			int index = 0;
			
			for (int a = 0; a < line.length(); a++) {
				if (index < "creeper".length() && characters[index] == line.charAt(a)) {
					result += characters[index++];
				}
			}
			
			if (result.equals("creeper")) { System.out.println("Aw Man"); }
			else { System.out.println("I Still Rule The World"); }
	    }
		
		input.close();
    }
}
