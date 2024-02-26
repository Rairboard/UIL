import java.util.*;
import java.io.*;
import static java.lang.System.*;
public class William {
	public static ArrayList<String> list = new ArrayList<String>();

	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("william.dat"));		
		while(f.hasNext()) 
			list.add(reverse(f.nextLine()));
		Collections.sort(list);
		for(String name:list)
			out.println(reverse(name));
	}
	
	public static String reverse(String temp) {
		return temp.substring(temp.indexOf(" ") + 1) + " " + temp.substring(0, temp.indexOf(" "));
	}
}
