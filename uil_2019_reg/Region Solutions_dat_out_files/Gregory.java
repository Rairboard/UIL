//Solution - UIL Region 2019
import static java.lang.System.*;
import java.io.*;
import java.util.*;

public class Gregory {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner data = new Scanner(new File("gregory.dat"));
		final String uppers = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";  // for sequences
		final String lowers = "abcdefghijklmnopqrstuvwxyz";  // for sequences
		final String digits = "0123456789";  //for sequences
		String letters = data.nextLine();
		String specials = data.nextLine();
		ArrayList<String> passwords = new ArrayList<String>();
		for (int i = 1; i <= 10; i++) {
			String [] words = data.nextLine().split(",");
			for (int j = 0; j < 10; j++)
				passwords.add(words[j]);
		}
		while (data.hasNext()) {
			String pw = data.next();
			String rating = "UNACCEPTABLE";
			int score = 0;
			if (pw.length() >= 8 && passwords.indexOf(pw.toLowerCase()) == -1) {
				int count = pw.length();
				int cats = 0;
				int bonus = 0;
				int penalty = 0;
				boolean lcase = false;
				boolean ucase = false;
				boolean digit = false;
				boolean spec = false;
				char prevcat = '?';   // U (upper), L (lower), D (digit), or S (special)
				char prevchar = ' ';  // never found in a password
				String next3 = "   ";
				for (int i = 0; i < count; i++) {
					char c = pw.charAt(i);
					if (i <= count - 3)
						next3 = pw.substring(i, i+3);
					else
						next3 = "   ";
					if (Character.isLowerCase(c)) {
						if (!lcase) { lcase = true; cats++; }
						score += letters.indexOf(Character.toUpperCase(pw.charAt(i))) < 13 ? 1: 2;
						bonus += i > 0 && prevcat != 'L' ? 2 : 0;
						prevcat = 'L';
						penalty += lowers.indexOf(next3) == -1 ? 0 : 5;
					} else if (Character.isUpperCase(c)) {
						if (!ucase) { ucase = true; cats++; }
						score += letters.indexOf(pw.charAt(i)) < 13 ? 1: 2;
						bonus += i > 0 && prevcat != 'U' ? 2 : 0;
						prevcat = 'U';
						penalty += uppers.indexOf(next3) == -1 ? 0 : 5;
					} else if (Character.isDigit(c)) {
						if (!digit) { digit = true; cats++; }
						score += 2;
						bonus += i > 0 && prevcat != 'D' ? 2 : 0;
						prevcat = 'D';
						penalty += digits.indexOf(next3) == -1 ? 0 : 5;
					} else {  // if (specials.indexOf(pw.charAt(i)) != -1) {  // must be non-alphanumeric
						if (!spec) { spec = true; cats++; }
						score += 3;
						bonus += i > 0 && prevcat != 'S' ? 2 : 0;
						prevcat = 'S';
					}
					if (c == prevchar) penalty += 1;
					prevchar = c;
				}
				if (cats < 3) {
					score = bonus = 0;
				}
				else {
					if (cats == 4) bonus += 5;
					if (count > 8) bonus += (count - 8) * 2;
					score += bonus;
					score -= penalty;
				}
				if (score <= 0) rating = "UNACCEPTABLE";
				else if (score <= 15) rating = "WEAK";
				else if (score <= 30) rating = "FAIR";
				else if (score <= 45) rating = "GOOD";
				else rating = "STRONG";
			}
			out.println(pw + ":" + score + ":" + rating);
		}
		data.close();
	}
}
