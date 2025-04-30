/*
 * UIL Computer Science 2025
 * Invitational B Packet Solution
 */

import java.io.*;
import java.util.*;

public class Pranav {
	public static void main(String[]args)throws Exception{
		new Pranav().run();
	}
	static ArrayList<Integer> arr;
    static HashMap<ArrayList<Integer>, Integer> memo;
	
	public void run()throws Exception{
		Scanner file = new Scanner(new File("pranav.dat"));
		int times = file.nextInt();
		file.nextLine();
		while(times-- > 0) {
			String[] s = file.nextLine().trim().split(" ");
			int opp = 0;
			arr = new ArrayList<>();
			for(int j = 0; j < s.length; j++) {
				arr.add(Integer.parseInt(s[j]));
				opp += arr.get(j);
			}
			n = arr.size();
			memo = new HashMap<>();
			int best = solve(0, n - 1);
			opp -= best;
			if(opp > best)
				System.out.println("Loser "+best);
			else if(best > opp)
				System.out.println("Winner "+best);
			else if(best == opp)
				System.out.println("Tie "+best);
		}
		file.close();
	}
    static int n = 0;
    static int solve(int i, int j)
    {
        if ((i > j) || (i >= n) || (j < 0))
            return 0;
        ArrayList<Integer> k = new ArrayList<Integer>();
        k.add(i);
        k.add(j);
        if (memo.containsKey(k))
            return memo.get(k);
        int option1 = arr.get(i) + Math.min(solve(i + 2, j), solve(i + 1, j - 1));
        int option2 = arr.get(j) + Math.min(solve(i + 1, j - 1), solve(i, j - 2));
        memo.put(k, Math.max(option1, option2));
        return memo.get(k);
    }
}
