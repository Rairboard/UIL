import java.io.*;                                                                                                                  
import static java.lang.System.*;                                                                                                  
import java.lang.*;                                                                                                                
import java.util.*;                                                                                                                
import java.math.*;                                                                                                                
import java.text.*;                                                                                                                
public class Cerebro {                                                                                                            
	public static void main(String[]args)throws Exception{                                                                         
		new Cerebro().run();                                                                                                      
	}                      
	boolean[][] mat;
	boolean[] poss;
	public void run()throws Exception{                                                                                             
		Scanner file = new Scanner(new File("cerebro.dat"));                                                                      
		int times = file.nextInt(), cons = file.nextInt();  
		ArrayList<String> names = new ArrayList<String>(), con = new ArrayList<String>();
		file.nextLine();                             
		while(cons-- > 0) {
			String s = file.nextLine().trim();
			con.add(s);
			String[] h = s.split(" ");
			if(!names.contains(h[0]))
				names.add(h[0]);
			if(!names.contains(h[1]))
				names.add(h[1]);
		}
		Collections.sort(names);
		mat = new boolean[names.size()][names.size()];
		poss = new boolean[names.size()];
		for(String s:con) {
			String[] h = s.split(" ");
			mat[names.indexOf(h[0])][names.indexOf(h[1])] = true;
		}
		Queue<Integer> qu = new LinkedList<Integer>();
		qu.add(names.indexOf("Xavier"));
		while(!qu.isEmpty()) {
			int cur = qu.poll();
			if(poss[cur])continue;
			poss[cur] = true;
			for(int i = 0; i < names.size(); i++)
				if(!poss[i] && mat[cur][i])
					qu.add(i);
		}
		while(times-- > 0) {                                                                                                       
			 String name = file.nextLine().trim();
			 int c = names.indexOf(name);
			 System.out.println(poss[c]? "Mutant Located.": "Nowhere to be found.");
		}                                                                                                                          
	}  
}                                                                                                                                  
                                                                                                                                   