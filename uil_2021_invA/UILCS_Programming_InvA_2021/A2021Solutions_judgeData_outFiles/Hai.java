import static java.lang.System.out;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
public class Hai {

	public static void main(String[] args) throws IOException{
		Scanner file = new Scanner(new File("hai.dat"));
		String text = file.nextLine();
		String words[] = text.split(" ");
		int numPatterns = file.nextInt();
		file.nextLine();
		for(int x = 1; x <= numPatterns; x++) {
			String regex = file.nextLine();
			out.printf("%-10s",regex);
			boolean matched = false;
			for(String word:words) {				
				if(Pattern.matches(regex, word)) {
					out.print(word + " ");
					matched = true;
					}				
				}
			if(!matched)
				out.println("No matches.");
			else
				out.println();
		}
	}
}
