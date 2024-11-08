import java.util.*;
import java.io.*;

public class Encrypter {

		public static void main(String[] args) throws IOException{
			Scanner sc= new Scanner(new File("encrypter.in"));
		
			//System.out.println(sc.next());
			int cases = sc.nextInt();
			sc.nextLine();
			for(int i = 0; i < cases; i++) {
				String message = sc.nextLine();
				String key = sc.nextLine().toLowerCase();
				String encrypted = "";
				int keyspot = 0;
				for(int c = 0; c < message.length(); c++) {
					char let = message.charAt(c);
					if(Character.isLetter(let)) {
						if(Character.isUpperCase(let)) {
						encrypted += (char) ((((int)let - 65)+((int)key.charAt(keyspot++%key.length()))-97)%26+65);
						}
						else if(Character.isLowerCase(let)) {
							encrypted += (char)((((int)let -  97)+((int)key.charAt(keyspot++%key.length()))-97)%26+97);
						}
					}else
						encrypted+=let;
				}
				System.out.println(encrypted);
			}
		}

}
