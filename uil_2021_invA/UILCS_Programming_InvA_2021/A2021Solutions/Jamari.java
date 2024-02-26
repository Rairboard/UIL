import java.util.*;
import java.io.*;
import static java.lang.System.*;
public class Jamari {

	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("jamari.dat"));
		ArrayList<String> people = new ArrayList<>();
		int lastServed = 0;
		while(f.hasNext()) {
			String name = f.next();
			if(name.equals(">>>")) {
				if(lastServed == people.size())
					out.println("Everyone got a donut today.");
				else if(lastServed == 0)
					out.println("No one got a donut today.");
				else {
					out.println("The last person to get a donut was " + people.get(lastServed - 1) + ".");
					out.println(people.size() - lastServed + " customers did not get a donut today.");
				}
				lastServed = 0;
				people.clear();
			}
			else if(Character.isDigit(name.charAt(0)))
				lastServed += Integer.valueOf(name);
			else
				people.add(name);
		}
	}
}
