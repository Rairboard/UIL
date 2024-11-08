import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class cookingfood {
	public static void main(String[] args) throws IOException {
		File file = new File("cooking.in");
		Scanner input = new Scanner(file);
		
		while (input.hasNextLine()) {
			String food = input.nextLine();
			int seconds = 0, minutes = 0;
			for (int index = 0; index < food.length(); index++) {
				seconds += food.charAt(index);
			}
			
			minutes = seconds / 60;
			seconds = seconds % 60;
			
			System.out.println(minutes + "min, " + seconds + "sec");
		}
		
		input.close();
	}
}
