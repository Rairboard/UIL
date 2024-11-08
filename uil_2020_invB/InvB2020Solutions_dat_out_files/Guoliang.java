/*
 *UIL Computer Science 2020
 *Invitational B Packet Solution
 */
import java.util.*;
import java.io.*;
import static java.lang.System.out;
public class Guoliang {

	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("guoliang.dat"));
		while(f.hasNext()) {
			Set<Character> unique = new HashSet<Character>();
			String str = f.next();
			for(int i = 0; i < str.length(); i++) 
				unique.add(str.charAt(i));
			if(unique.size() == str.length())
				out.println(str);
		}
		

	}
	
	

}
