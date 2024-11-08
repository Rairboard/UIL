import java.util.*;
import java.io.*;

public class LeagueTimeLimit{
	public static void main(String[] args) throws Exception{
		new LeagueTimeLimit().run();
	}
    String[] p;
    int n, q[];
	public void run() throws Exception{
		Scanner file = new Scanner(new File("league.dat"));
		int times = file.nextInt(); file.nextLine();
		for(int asdf = 0; asdf<times; asdf++){
			p = new String[n = file.nextInt()];
            q = new int[5];
            for(int i = 0; i<5; i++)
                q[i] = file.nextInt();
            for(int i = 0; i<n; i++)
                p[i] = file.next();
            System.out.println(r(0));
		}
	}
    int r(int c){
        if( c == n )return 0;
        int max = r(c+1);
        for(int i = 0; i<p[c].length(); i++){
            int a = p[c].charAt(i)-'A';
            if( q[a] > 0){
                q[a]--;
                max = Math.max(max, 1+r(c+1));
                q[a]++;
            }
        }
        return max;
    }
}