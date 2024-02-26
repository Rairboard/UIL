import java.util.*;
import java.io.*;

public class LeagueGreedyWrong2{
	public static void main(String[] args) throws Exception{
		new LeagueGreedyWrong2().run();
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
            ArrayList<ArrayList<String> > list = new ArrayList<ArrayList<String> >();
            for(int i = 0; i<5; i++)
                list.add(new ArrayList<String>());
        outer:
            for(String s : p){
            //System.out.println(list);
                for(char c : s.toCharArray()){
                    int v = c-'A';
                    if( q[v] > 0){
                        q[v]--;
                        list.get(v).add(s);
                        ct++;
                        continue outer;
                    }
                }
                for(char c : s.toCharArray()){
                    int v = c-'A';
                    if( q[v] == 0)
                        for(int i = 0; i<list.get(v).size(); i++){
                            String s2 = list.get(v).get(i);
                            for(char c2: s2.toCharArray()){
                                int v2 = c2-'A';
                                if( q[v2] > 0){
                                    q[v2]--;
                                    list.get(v2).add(list.get(v).remove(i));
                                    list.get(v).add(s);
                                    ct++;
                                    continue outer;
                                }
                            }
                        }
                }
            }
            System.out.println(ct);
		}
	}
}