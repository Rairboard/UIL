import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Given a date in the form MONTH DAY, YEAR return true if the date in MMDDYYYY form is a palindrome. 
 */
public class cursed {
	public static void main(String [] args) throws FileNotFoundException {
		Scanner f = new Scanner(new File("cursed.dat"));
		while(f.hasNextLine()) {
			String [] date = parseInputString(f.nextLine());
			String numericDate = transformDate(date[0], date[1], date[2]);
			System.out.print(numericDate+": ");
			if(isPalindrome(numericDate)) {
				System.out.println("DON'T TRAVEL");
			} else {
				System.out.println("OK TO TRAVEL");
			}
		}
	}
	
	/*
	 * Takes a line of input and returns a String array where each element corresponds 
	 * to a different part of the date.
	 */
	private static String[] parseInputString(String input) {
		String [] date = new String[3];
		Scanner chop = new Scanner(input);
		date[0] = chop.next(); //month
		date[1] = chop.next(); //day
		date[1] = date[1].substring(0, date[1].length()-1); //removes comma
		date[2] = chop.next(); //year
		
		return date;
	}
	
	/*
	 * Transforms the date from Month Day, Year format to MMDDYYYY format.
	 */
	private static String transformDate(String month, String day, String year) {
		//transform month from word to number
		String m = "";
		//(Java 7 way of doing things)
		/*switch(month) {
			case "January":	m = "01"; break;
			case "February": m = "02"; break;
			case "March": m = "03"; break;
			case "April": m = "04"; break;
			case "May": m = "05"; break;
			case "June": m = "06"; break;
			case "July": m = "07"; break;
			case "August": m = "08"; break;
			case "September": m = "09"; break;
			case "October": m = "10"; break;
			case "November": m = "11"; break;
			case "December": m = "12"; break;
		}*/
		
		//(Java 6  way of doing things)
		String [] months = {"NOOP", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		for(int i = 1; i < months.length; i++) {
			if(month.equals(months[i])){
				m = i+"";
			}
		}
		while(m.length() < 2) {
			m = "0" + m;
		}
		
		//transform day into two digits
		while(day.length() < 2) {
			day = "0" + day;
		}
		
		//transfrom year into four digits
		while(year.length() < 4) {
			year = "0" + year;
		}
		
		return m+day+year;
	}
	
	/*
	 * Returns true if the given string is a palindrome.
	 */
	private static boolean isPalindrome(String date) {
		for(int i = 0; i < date.length(); i++) {
			if(date.charAt(i) != date.charAt(date.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}
}
/*
Test Data
June 1, 1998
January 9, 109
December 31, 1321
August 8, 1880
February 29, 4
April 20, 240
November 11, 1111
January 1, 1010
May 31, 1
March 13, 9999

Test Output
06011998: OK TO TRAVEL
01090109: OK TO TRAVEL
12311321: DON'T TRAVEL
08081880: OK TO TRAVEL
02290004: OK TO TRAVEL
04200240: DON'T TRAVEL
11111111: DON'T TRAVEL
01011010: DON'T TRAVEL
05310001: OK TO TRAVEL
03139999: OK TO TRAVEL

*/