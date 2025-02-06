import static java.lang.System.out;
import java.util.*;
import java.io.*;
public class Klaudia {

	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("klaudia.dat"));
		int n = f.nextInt();
		f.nextLine();
		for(int x = 1; x <= n; x++) {
			String morse = f.nextLine();
			Scanner line = new Scanner(morse);
			while(line.hasNext())
				out.print(text(line.next()));
			out.println();
		}

	}
	
	public static String text(String code) {
		switch(code) {
		case ".-": return "A";
		case "-...": return "B";
		case "-.-.":return "C";
		case "-..":return "D";
		case ".": return "E";
		case "..-.": return "F";
		case "--.": return "G";
		case "....": return "H";
		case "..": return "I";
		case ".---": return "J";
		case "-.-": return "K";
		case ".-..": return "L";
		case "--": return "M";
		case "-.": return "N";
		case "---": return "O";
		case ".--.": return "P";
		case "--.-": return "Q";
		case ".-.": return "R";
		case "...": return "S";
		case "-": return "T";
		case "..-": return "U";
		case "...-": return "V";
		case ".--": return "W";
		case "-..-": return "X";
		case "-.--": return "Y";
		case "--..": return "Z";
		case ".----": return "1";
		case "..---": return "2";
		case "...--": return "3";
		case "....-": return "4";
		case ".....": return "5";
		case "-....": return "6";
		case "--...": return "7";
		case "---..": return "8";
		case "----.": return "9";
		case "-----": return "0";
		case "/": return " ";
		}
		return "";
	}

}
