import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Enchanting {
	public static void main(String[] args) throws IOException {
		File file = new File("enchantment.in");
		Scanner input = new Scanner(file);
		int x = input.nextInt();
		int y = input.nextInt();
		input.nextLine();
		
		while (input.hasNextLine()) {
			System.out.println(d(input.nextLine(), x, y));
		}
		
		input.close();
	}
	
	public static String d(String l, int x, int y ) {
		int flag = 0;
		String msg = "";
		
		while (x * flag % 26 != 1) {
			flag++;
		}
		
		for (int index = 0; index < l.length(); index++) {
			if (l.charAt(index) == ' ') { msg += ' '; }
		    else { 
		    	char c = (char) ((flag * (l.charAt(index) + 65 - y)) % 26 + 65);
				msg += c;
		    }
		}
		
		return msg;
	}
}