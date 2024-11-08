import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
public class Star {
	public static void main(String[]args)throws Exception{
		new Star().run();
	}
	public void run()throws Exception{
		Scanner file=new Scanner(new File("star.dat"));
		int p = file.nextInt(), n = file.nextInt(), i = file.nextInt();
		file.nextLine();
		ArrayList<Planet> a = new ArrayList<Planet>();
		ArrayList<String> names =  new ArrayList<String>();
		double[][] con = new double[p][p];
		while(p-- > 0) {
			String name = file.next();
			names.add(name);
			a.add(new Planet(name, file.nextDouble(), file.nextDouble(), file.nextDouble()));
			file.nextLine();
		}
		Collections.sort(a);
		Collections.sort(names);
		while(n-- > 0) {
			int one = names.indexOf(file.next());
			int two = names.indexOf(file.next());
			con[one][two] = con[two][one] = a.get(one).dist(a.get(two));
			file.nextLine();
		}
		//System.out.println(Arrays.deepToString(con));
		while(i-- > 0) {
			int one = names.indexOf(file.next());
			int two = names.indexOf(file.next());
			file.nextLine();
			Queue<Double> qu = new LinkedList<Double>();
			double[] visit = new double[names.size()];
			Arrays.fill(visit, Double.MAX_VALUE);
			//visit[one] = 0;
			qu.add(one*1.0);qu.add(0.0);
			while(!qu.isEmpty()) {
				//System.out.println(qu);
				int curr = (int)((double)qu.poll());
				double dist = qu.poll();
				if(visit[curr] <= dist)continue;
				visit[curr] = dist;
				if(curr == two)continue;
				for(int y = 0; y < names.size(); y++)
					if(con[y][curr] != 0.0) {
						qu.add(y*1.0);
						qu.add(dist + con[y][curr]);
					}
			}
			//System.out.println(Arrays.toString(visit));
			if(visit[two] == Double.MAX_VALUE)
				System.out.println("These are not the planets you're looking for.");
			else
				System.out.printf("%s -> %s : %,.3f%n",names.get(one),names.get(two),visit[two]);
		}
	}
}
class Planet implements Comparable<Planet>{
	
	String name;
	double x, y, z;
	
	public Planet(String n, double xx, double yy, double zz) {
		name = n;
		x = xx;
		y = yy;
		z = zz;
	}
	
	public String toString() {
		return name;
	}
	
	public double dist(Planet p) {
		return Math.sqrt(Math.pow(x - p.x, 2) + 
				Math.pow(y - p.y, 2) + Math.pow(z - p.z, 2));
	}
	
	public int compareTo(Planet p) {
		return name.compareTo(p.name);
	}
}