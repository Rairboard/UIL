/*Region UIL 2014 Solution - #4 Descendants
Test data
20
chrome 23 34
ps 2 1
sublime 4 34
awesome 34 1
eclipse 56 34
gdb 91 56
man 102 91
cd 901 712
textWrangler 712 314
banana 31 91
pie 314 11
closet 92 11
guitar 165 11
sock 12 91
fortyTwo 11 34
nailPolish 8912 56 
fingers 98 72
fish 6 34
computer 2179 6
joey 72 31

Output
root
-awesome
--chrome
--eclipse
---gdb
----banana
-----joey
------fingers
----man
----sock
---nailPolish
--fish
---computer
--fortyTwo
---closet
---guitar
---pie
----textWrangler
-----cd
--sublime
-ps

*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;


public class Descendants {

	private static HashMap<Integer, TreeSet<String>> idToChildren;
	private static HashMap<String, Integer> nameToId;

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		idToChildren = new HashMap<>();
		nameToId = new HashMap<>();
		Scanner sc = new Scanner(new File("descendants.dat"));
		int t = sc.nextInt();
		while(t-- > 0){
			String name = sc.next();
			int id = sc.nextInt();
			int pid = sc.nextInt();
			if(!idToChildren.containsKey(pid))
				idToChildren.put(pid, new TreeSet<String>());
			idToChildren.get(pid).add(name);
			nameToId.put(name, id);
		}
		System.out.println("root");
		printChildren("-", 1);
	}

	private static void printChildren(String dashes, int pid) {
		if(idToChildren.containsKey(pid))
			for(String s : idToChildren.get(pid)){
				System.out.println(dashes+s);
				printChildren(dashes+"-", nameToId.get(s));
			}
	}

}
