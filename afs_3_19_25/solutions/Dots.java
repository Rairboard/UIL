import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Dots {
	private class Dot {
		double x, y;
		double priority;
		Dot parent;
		
		public Dot(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
		public double distance(Dot other) {
			double dx = x - other.x;
			double dy = y - other.y;
			return Math.sqrt((dx * dx) + (dy * dy));
		}
	}
	
	public static void main(String[] args) throws IOException {
		new Dots().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("Dots/dots.dat"));
		PrintWriter out = new PrintWriter(new File("Dots/dots.out"));
		
		int n = Integer.parseInt(file.readLine());
		while(n-->0) {
			int D = Integer.parseInt(file.readLine());
			Dot[] dots = new Dot[D];
			for(int i = 0; i < D; i++) {
				StringTokenizer st = new StringTokenizer(file.readLine());
				dots[i] = new Dot(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
			}
			
			double connectTheDots = connectTheDots(dots);
			double mst = primAdjacencyMatrix(dots, D);
			out.printf("%.10f\n", connectTheDots - mst);
		}
		
		file.close();
		out.close();
	}
	
	private double connectTheDots(Dot[] dots) {
		double d = 0;
		for(int i = 0; i < dots.length - 1; i++) {
			d += dots[i].distance(dots[i+1]);
		}
		return d;
	}
	
	private double primAdjacencyMatrix(Dot[] dots, int V) {
		Dot u = dots[0];
		u.priority = 0;
		u.parent = u;
		for(int i = 1; i < V; i++) {
			dots[i].priority = dots[i].distance(u);
			dots[i].parent = u;
		}
		
		double dist = 0;
		for(int i = 0; i < V-1; i++) {
			double min = Double.POSITIVE_INFINITY;
			Dot minVertex = null;
			for(Dot v : dots) {
				if(v.priority > 0 && v.priority < min) {
					min = v.priority;
					minVertex = v;
				}
			}
			minVertex.priority = 0;
			dist += minVertex.distance(minVertex.parent);
			for(Dot v : dots) {
				double d = v.distance(minVertex);
				if(v.priority > d) {
					v.priority = d;
					v.parent = minVertex;
				}
			}
		}
		
		return dist;
	}
}
