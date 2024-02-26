/*
 *UIL Computer Science 2020
 *Invitational B Packet Alternate Solution
 */
import static java.lang.System.*;
import java.io.*;
import java.util.*;
public class JoseyAlt {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("josey.dat"));
		int T = s.nextInt();
		for (int t = 1; t <= T; t++) {
			int B = s.nextInt();
			ArrayList<String> ocean = new ArrayList<String>();
			ArrayList<String> locked = new ArrayList<String>();
			ArrayList<String> dlocked = new ArrayList<String>();
			ArrayList<String> unknown1 = new ArrayList<String>();
			ArrayList<String> unknown2 = new ArrayList<String>();
			for (int b = 1; b <= B; b++) {
				String c1 = s.next();
				String c2 = s.next();
				if (c1.compareTo("OCEAN") == 0 || c2.compareTo("OCEAN") == 0)
					ocean.add((c1.compareTo("OCEAN") == 0) ? c2 : c1);
				else {
					unknown1.add(c1);
					unknown2.add(c2);
				}
			}
			boolean flag = true;
			while (flag && unknown1.size() != 0) {
				flag = false;
				for (int i = 0; i < unknown1.size(); i++)
					if (ocean.contains(unknown1.get(i)) && ocean.contains(unknown2.get(i))) {
						unknown1.remove(i);
						unknown2.remove(i--);
					}
					else if (ocean.contains(unknown1.get(i)) && !ocean.contains(unknown2.get(i)) && !locked.contains(unknown2.get(i))) {
						locked.add(unknown2.get(i));
						unknown1.remove(i);
						unknown2.remove(i--);  // shrunk both lists, backup i
						flag = true;
					} else if (ocean.contains(unknown2.get(i)) && !ocean.contains(unknown1.get(i))&& !locked.contains(unknown2.get(i))) {
						locked.add(unknown1.get(i));
						unknown1.remove(i);
						unknown2.remove(i--);  // shrunk both lists, backup i
						flag = true;
					}
			}
			ArrayList<String> combo = new ArrayList<String>();
			combo.addAll(ocean);
			combo.addAll(locked);
			while (unknown1.size() != 0) {
				if (!combo.contains(unknown1.get(0)) && !dlocked.contains(unknown1.get(0)))
					dlocked.add(unknown1.get(0));
				if (!combo.contains(unknown2.get(0)) && !dlocked.contains(unknown2.get(0)))
					dlocked.add(unknown2.get(0));
				unknown1.remove(0);
				unknown2.remove(0);
			}
			out.println("Case #" + t + ": " + dlocked.size());
			dlocked.sort(null);
//			Collections.sort(dlocked);
			for (int i = 0; i < dlocked.size(); i++) 
				out.println(dlocked.get(i));
		}
	}
}
