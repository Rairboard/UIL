import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Zombies {
	public static void main(String[] args) throws IOException {
		File file = new File("zombies.in");
		Scanner input = new Scanner(file);
		
		while (input.hasNextLine()) {
			String line = input.nextLine();
			String newLine = "";
			for (int index = 0; index < line.length(); index++) {
				if ("ZOMBIE".indexOf(Character.toString(line.toUpperCase().charAt(index))) == -1) {
					newLine += line.charAt(index);
				}
			}
			System.out.println(newLine);
		}
		
		input.close();
	}
}