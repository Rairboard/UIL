import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class WarGames {
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("wargames.in"));
		int runs = in.nextInt();
		
		for (int run = 0; run < runs; run++) {
			int matchups = in.nextInt();
			in.nextLine();
			TreeMap<String, String> win = new TreeMap<>();
			TreeMap<String, String> lose = new TreeMap<>();
			
			for (int m = 0; m < matchups; m++) {
				String w = in.next().trim();
				String l = in.next().trim();
				in.nextLine();
				if (win.containsKey(w))
					win.put(w, win.get(w) + l);
				else
					win.put(w, l);
				if (lose.containsKey(l))
					lose.put(l, lose.get(l) + w);
				else
					lose.put(l, w);
			}
			
			int r = in.nextInt(), c = in.nextInt();
			in.nextLine();
			int rebels = 0;
			for (int i = 0; i < r; i++) {
				String row = in.nextLine().trim();
				String p1 = row.substring(1, 2);
				String p2 = row.substring(row.length() - 2, row.length() - 1);
				if (win.containsKey(p1) && win.get(p1).contains(p2))
					rebels++;
				else if (lose.get(p1).contains(p2))
					rebels--;
			}
			System.out.println(rebels == 0 ? "The war isn't over" : (rebels > 0 ? "The rebels have won!" : "The empire still stands..."));
		}
		in.close();
	}
}
