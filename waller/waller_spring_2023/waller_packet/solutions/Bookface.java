import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
public class Bookface {
	public static void main(String[]args)throws Exception{
		new Bookface().run();
	}
	public void run()throws Exception{
		Scanner file=new Scanner(new File("bookface.dat"));
		int cons = file.nextInt(), times = file.nextInt();
		file.nextLine();
		ArrayList<String> a = new ArrayList<String>();
		String[] c = new String[cons];
		while(cons-- > 0) {
			String fn1 = file.next();
			String ln1 = file.next();
			String fn2 = file.next();
			String ln2 = file.next();
			c[cons] = fn1  + " " + ln1 + " " + fn2 + " " + ln2;
			file.nextLine();
			String one = fn1 + " " + ln1;
			String two = fn2 + " " + ln2;
			if(!a.contains(one))a.add(one);
			if(!a.contains(two))a.add(two);
		}
		//System.out.println(Arrays.toString(c));
		//System.out.println(a);
		boolean[][] con = new boolean[a.size()][a.size()];
		for(String h:c) {
			String[] f = h.split(" ");
			String f1 = f[0] + " " + f[1];
			String f2 = f[2] + " " + f[3];
			//System.out.println(f1);
			con[a.indexOf(f1)][a.indexOf(f2)] = con[a.indexOf(f2)][a.indexOf(f1)] = true;
		}
		//System.out.println(Arrays.toString(con[a.indexOf("C C")]));
		for(int y = 0; y < a.size(); y++)
			con[y][y] = true;
		while(times-- > 0) {
			String start = file.nextLine().trim();
			int[] visit = new int[a.size()];
			Arrays.fill(visit, Integer.MAX_VALUE);
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(a.indexOf(start));q.add(-1);
			//System.out.println(q);
			//visit[a.indexOf(start)] = -1;
			//System.out.println(Arrays.deepToString(con));
			//System.out.println(a);
			while(!q.isEmpty()) {
				int curr = q.poll();
				int step = q.poll();
				if(visit[curr] <= step)continue;
				visit[curr] = step;
				for(int y = 0; y < a.size(); y++)
					if(con[curr][y]) {
						//System.out.println(y);
						q.add(y);
						q.add(step + 1);
					}
			}
			System.out.println(start);
			ArrayList<String> one = new ArrayList<String>();
			ArrayList<String> two = new ArrayList<String>();
			ArrayList<String> three = new ArrayList<String>();
			//System.out.println(Arrays.toString(visit));
			for(int y = 0; y < a.size(); y++) {
				String[] d = a.get(y).split(" ");
				String v = d[1] + " " + d[0];
				if(visit[y] == 1)
					one.add(v);
				if(visit[y] == 2)
					two.add(v);
				if(visit[y] == 3)
					three.add(v);
			}
			Collections.sort(one);
			Collections.sort(two);
			Collections.sort(three);
			String s1 = "Users that are one connection away:";
			String s2 = "Users that are two connections away:";
			String s3 = "Users that are three connections away:";
			String fin = "";
			for(String b:one) {
				String[] t = b.split(" ");
				String v = t[1] + " " + t[0];
				fin += ", "+ v;
			}
			if(fin.length() == 0)
				fin = " No users are one connection away";
			else
				fin = fin.substring(1);
			System.out.println(s1 + fin);
			fin = "";
			for(String b:two) {
				String[] t = b.split(" ");
				String v = t[1] + " " + t[0];
				fin += ", "+ v;
			}
			if(fin.length() == 0)
				fin = " No users are two connections away";
			else
				fin = fin.substring(1);
			System.out.println(s2 + fin);
			fin = "";
			for(String b:three) {
				String[] t = b.split(" ");
				String v = t[1] + " " + t[0];
				fin += ", "+ v;
			}
			if(fin.length() == 0)
				fin = " No users are three connections away";
			else
				fin = fin.substring(1);
			System.out.println(s3 + fin);
		}
	}
}
 