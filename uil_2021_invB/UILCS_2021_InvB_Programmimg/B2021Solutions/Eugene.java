import static java.lang.System.out;
import java.util.*;
import java.io.*;
public class Eugene {

	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("eugene.dat"));
		int num = f.nextInt();
		f.nextLine();
		ArrayList<String> list = new ArrayList<String>();
		for(int x = 1; x <= num; x++) {
			String password = "";
			String first = f.next();
			String last = f.next();
			char fi = first.charAt(0);
			char li = last.charAt(0);
			password = password + fi + li;
			password = password.toLowerCase();
			password = password + (int)fi + (int)li;
			while(list.contains(password)) {
				fi++;
				password = password.substring(0, 2) + (int)fi + password.substring(4);
				}
			list.add(password);
			out.println(first + " " + last + " " + password);			
		}
	}
}
