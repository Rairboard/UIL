import java.util.*;
import java.io.*;

public class LeagueGreedyWrong{
	public static void main(String[] args) throws Exception{
		new LeagueGreedyWrong().run();
	}
	public void run() throws Exception{
		Scanner file = new Scanner(new File("league.dat"));
		int times = file.nextInt(); file.nextLine();
		for(int asdf = 0; asdf<times; asdf++){
            int n = file.nextInt();
			String[] p = new String[n];
            int[] q = new int[5];
            for(int i = 0; i<5; i++)
                q[i] = file.nextInt();
            for(int i = 0; i<n; i++)
                p[i] = file.next();
            Arrays.sort(p, new Comparator<String>(){
                public int compare(String s1, String s2){
                    return s1.length()-s2.length();
                }
            });
            int ct = 0;
            for(String s : p)
                for(char c : s.toCharArray())
                    if( q[c-'A'] > 0){
                        q[c-'A']--;
                        ct++;
                        break;
                    }
            System.out.println(ct);
		}
	}
}