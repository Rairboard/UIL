import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Missions {
	public static void main(String[]args)throws Exception{
		new Missions().run();
	}
	ArrayList<String> combos;
	TreeMap<String,ArrayList<String>> tm;
	TreeMap<String, Integer> dup;
	public void run()throws Exception{
		Scanner file = new Scanner(new File("missions.dat"));
		int times = file.nextInt();
		file.nextLine();
		tm = new TreeMap<String,ArrayList<String>>();
		dup = new TreeMap<String,Integer>();
		fill();
		while(times-- > 0) {
			String[] st = file.nextLine().trim().split("\\s+");
			combos = new ArrayList<String>();
			ArrayList<Integer> dupe = new ArrayList<Integer>();
			comb(st, "", 0);
			Collections.sort(combos);
			for(int i = 0; i < combos.size(); i++) {
				boolean b = false;
				int d = 0;
				String[] c = combos.get(i).split("\\s+");
				for(int ii = 0; ii < c.length && !b; ii++) {
					d |= dup.get(c[ii]);
					for(int iii = ii + 1; iii < c.length && !b; iii++) {
						//System.out.println(c[iii] +" "+c[ii]);
						if(c[iii].equals(c[ii]))
							b = true;
					}
				}
				if(b || dupe.contains(d)) {
					combos.remove(i);
					i--;
				}
				else
					dupe.add(d);
			}
			System.out.println(combos.size());
			System.out.println(combos.isEmpty()? "": combos.get(0));
			//System.out.println(combos);
			//ystem.out.println(dupe.size());
		}
	}
	
	
	void comb(String[] s, String cur, int i) {
		if(i == s.length)
			combos.add(cur.trim());
		else {
			String c = s[i];
			ArrayList<String> x = tm.get(c);
			for(String t:x)
				comb(s, cur+t+" ", i+1);
		}
	}
	
	void fill() {
		tm.put("Strength",new ArrayList<String>()); //Strength
		tm.get("Strength").add("Colossus");tm.get("Strength").add("Beast");
		tm.put("Invulnerability",new ArrayList<String>()); //Invulnerability
		tm.get("Invulnerability").add("Colossus");tm.get("Invulnerability").add("Wolverine");tm.get("Invulnerability").add("Iceman");
		tm.put("Hand-to-Hand",new ArrayList<String>()); //Hand-to-Hand
		tm.get("Hand-to-Hand").add("Nightcrawler");tm.get("Hand-to-Hand").add("Wolverine");tm.get("Hand-to-Hand").add("Cyclops");
		tm.put("Agility",new ArrayList<String>()); //Agility
		tm.get("Agility").add("Nightcrawler");tm.get("Agility").add("Beast");
		tm.put("Teleportation",new ArrayList<String>()); //Teleportation
		tm.get("Teleportation").add("Nightcrawler");
		tm.put("Swords",new ArrayList<String>()); //Swords
		tm.get("Swords").add("Nightcrawler");tm.get("Swords").add("Angel");
		tm.put("Cold",new ArrayList<String>()); //Cold
		tm.get("Cold").add("Iceman");tm.get("Cold").add("Storm");
		tm.put("Electric",new ArrayList<String>()); //Electric
		tm.get("Electric").add("Storm");
		tm.put("Flight",new ArrayList<String>()); //Flight
		tm.get("Flight").add("Storm");tm.get("Flight").add("Banshee");tm.get("Flight").add("Angel");tm.get("Flight").add("Phoenix");
		tm.put("Energy-Blasts",new ArrayList<String>()); //Energy-Blasts
		tm.get("Energy-Blasts").add("Cyclops");tm.get("Energy-Blasts").add("Phoenix");tm.get("Energy-Blasts").add("Banshee");
		tm.put("Telekinesis",new ArrayList<String>()); //Telekinesis
		tm.get("Telekinesis").add("Phoenix");
		tm.put("Telepathy",new ArrayList<String>()); //Telepathy
		tm.get("Telepathy").add("Phoenix");
		dup.put("Colossus",1);
		dup.put("Nightcrawler",2);
		dup.put("Iceman",4);
		dup.put("Beast",8);
		dup.put("Angel",16);
		dup.put("Phoenix",32);
		dup.put("Cyclops",64);
		dup.put("Wolverine",128);
		dup.put("Storm",256);
		dup.put("Banshee",512);
	}
}
