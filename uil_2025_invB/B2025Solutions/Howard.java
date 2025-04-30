/*
 * UIL Computer Science 2025
 * Invitational B Packet Solution
 */

import java.io.*;
import java.util.*;

public class Howard {
	public static void main(String[]args)throws Exception{
		new Howard().run();
	}
	
	public void run()throws Exception{
		Scanner file = new Scanner(new File("howard.dat"));
		int times = file.nextInt();
		file.nextLine();
		LinkedHashMap<String, ArrayList<Player>> pos = new LinkedHashMap<String, ArrayList<Player>>();
		pos.put("PG", new ArrayList<Player>());
		pos.put("SG", new ArrayList<Player>());
		pos.put("SF", new ArrayList<Player>());
		pos.put("PF", new ArrayList<Player>());
		pos.put("C", new ArrayList<Player>());
		while(times-- > 0) {
			//System.out.println(times);
			Player p = new Player(file.nextInt(), file.next(), file.next(), file.nextDouble(), file.nextDouble(), file.nextDouble(), file.nextDouble(), file.nextDouble());
			file.nextLine();
			pos.get(p.pos).add(p);
		}
		for(String p:pos.keySet()) {
			ArrayList<Player> a = pos.get(p);
			Collections.sort(a);
			System.out.println(p+": "+a.get(0));
		}
		file.close();
	}
}
class Player implements Comparable<Player>{
	double ts, att;
	String name, pos;
	int number;
	
	public Player(int n, String a, String p, double pts, double apg, double fga, double fta, double tpg) {
		number = n;
		name = a;
		pos = p;
		att = apg / tpg;
		ts = pts / (2 * (fga + 0.44 * fta));
	}
	
	public int compareTo(Player p) {
		if(Math.abs(p.ts - ts) > 1e-10)return Double.compare(p.ts, ts);
		return Double.compare(p.att, att);
	}
	
	public String toString() {
		return "" + number + ". " + name;
	}
}