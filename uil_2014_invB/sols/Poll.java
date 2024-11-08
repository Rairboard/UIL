import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class Poll {

	public static void main(String[] args) throws FileNotFoundException {
		Map<String, Integer> vals = new TreeMap<String, Integer>();
		vals.put("+", 1);
		vals.put("-", -1);
		Scanner sc = new Scanner(new File("poll.dat"));
		String name, vote;
		for(int t = sc.nextInt(); t-- > 0;){
			Map<String, String> names = new HashMap<>();
			for(int n = sc.nextInt(); n-- > 0;){
				name = sc.next();
				vote = sc.next();
				names.put(name, vote);
			}
			int sum = 0;
			for(String i : names.values())
				sum += vals.get(i);
			System.out.println(sum);
			
		}
	}

}
