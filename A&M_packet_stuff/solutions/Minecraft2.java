import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
public class Minecraft2 {
	public static void main(String[]args)throws Exception{
		new Minecraft2().run();
	}
	public void run()throws Exception{
		Scanner file=new Scanner(new File("minecraft2.dat"));
		int i = file.nextInt(), n = file.nextInt();
		file.nextLine();
		TreeMap<String, Item>recipes = new TreeMap<String, Item>();
		while(i-- > 0) {
			Item item = new Item(file.nextLine());
			recipes.put(item.result, item);
		}
		while(n-- > 0) {
			String name = file.next();
			int amnt = file.nextInt();
			int m = file.nextInt();
			file.nextLine();
			TreeMap<String, Integer> tm = new TreeMap<String, Integer>(), inv = new TreeMap<String, Integer>();
			while(m-- > 0) {
				int a = file.nextInt();
				String s1 = file.nextLine().trim();
				inv.put(s1, a);
			}
			//System.out.println(inv);
			tm.put(name, amnt);
			if(inv.containsKey(name)) {
				if(amnt > inv.get(name)) {
					tm.put(name, amnt - inv.get(name));
					inv.remove(name);
				}
				else
					tm.remove(name);
			}
			boolean pres = true;
			while(pres && !tm.isEmpty()) {
				pres = false;
				TreeMap<String, Integer> gnu = new TreeMap<String, Integer>();
				ArrayList<String> rem = new ArrayList<String>();
				for(String h:tm.keySet()) {
					if(recipes.containsKey(h)) {
						pres = true;
						String na = h;
						int am = tm.get(na);
						rem.add(na);
						Item item = recipes.get(na);
						am = item.amnt > am? 1: am / item.amnt + (am % item.amnt != 0? 1: 0);
						for(String g: item.ingredients.keySet()) {
							int a = item.ingredients.get(g) * am;
							if(inv.containsKey(g)) {
								if(inv.get(g) > a) {
									inv.put(g, inv.get(g) - a);
									a = 0;
								}
								else {
									a = a - inv.get(g);
									inv.remove(g);
								}
							}
							if(gnu.containsKey(g))
								gnu.put(g, a + gnu.get(g));
							else
								gnu.put(g, a);
						}
					}
				}
				for(String h:rem)
					tm.remove(h);
				for(String h:gnu.keySet()) {
					if(tm.containsKey(h))
						tm.put(h, gnu.get(h) + tm.get(h));
					else
						tm.put(h, gnu.get(h));
				}
			}
			TreeMap<String, Integer> gnu = new TreeMap<String, Integer>();
			ArrayList<String> rem = new ArrayList<String>();
			//System.out.println(tm);
			for(String g:tm.keySet()) {
				if(inv.containsKey(g)) {
					int a = tm.get(g);
					if(inv.get(g) > a) {
						rem.add(g);
						inv.put(g, inv.get(g) - a);
					}
					else {
						gnu.put(g, a - inv.get(g));
						inv.remove(g);
					}
				}
			}
			for(String h:rem)
				tm.remove(h);
			for(String h:gnu.keySet()) 
					tm.put(h, gnu.get(h));
			String fin = "";
			for(String f: tm.keySet())
				if(tm.get(f) > 0)
					fin += ", "  + tm.get(f) + " " + f;
			System.out.println(fin.equals("")? "All Supplies in Inventory.": fin.substring(2));
		}
	}
}
class Item{
	String result;
	int amnt;
	TreeMap<String, Integer> ingredients;
	
	public Item(String s) {
		String[] s2 = s.substring(s.indexOf(": ") + 2).split(", ");
		String[] s1 = s.substring(0, s.indexOf(": ")).split(" ");
		result = s1[1];
		amnt = Integer.parseInt(s1[0]);
		ingredients = new TreeMap<String, Integer>();
		for(String st:s2) {
			String[] t = st.split(" ");
			ingredients.put(t[1], Integer.parseInt(t[0]));
		}
	}
}
