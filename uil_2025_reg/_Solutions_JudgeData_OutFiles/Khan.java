import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Khan {
	public static void main(String[] args) throws IOException {
		new Khan().run();
	}

	private void run() throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("khan.dat"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		solve(file, out);

		file.close();
		out.close();
	}
	
	private class UnionFind {
		private int[] p;
		
		public UnionFind(int n) {
			this.p = new int[n];
			Arrays.fill(p, -1);
		}
		
		public int find(int x) {
			if(p[x] < 0) {
				return x;
			}
			int px = find(p[x]);
			p[x] = px;
			return px;
		}
		
		public int union(int x, int y) {
			int px = find(x);
			int py = find(y);
			if(px == py) {
				return -1;
			}
			if(p[py] < p[px]) {
				int save = py;
				py = px;
				px = save;
			}
			p[px] += p[py];
			p[py] = px;
			return px;
		}
	}
	
	private class Shape {
		double x, y, r;
		boolean isCircle;
		
		public Shape(double x, double y, double r) {
			this.x = x;
			this.y = y;
			this.r = r;
			this.isCircle = true;
		}
		
		public Shape(double x) {
			this.x = x;
			this.y = Double.NaN;
			this.r = Double.NaN;
			this.isCircle = false;
		}
		
		private static final double EPSILON = 1e-6;
		
		public boolean intersects(Shape other) {
			double dist = distance(other);
			boolean ans = false;
			if(this.isCircle && other.isCircle) {
				ans = (this.r + other.r) > dist - EPSILON;
			} else if(this.isCircle) {
				ans = this.r > dist - EPSILON;
			} else if(other.isCircle) {
				ans = other.r > dist - EPSILON;
			}
			return ans;
		}
		
		private double distance(Shape other) {
			double x1 = this.x;
			double y1 = this.isCircle ? this.y : other.y;
			double x2 = other.x;
			double y2 = other.isCircle ? other.y : this.y;
			return (y1 == Double.NaN || y1 == y2) ? Math.abs(this.x - other.x) 
					: Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
		}
	}

	public void solve(BufferedReader file, PrintWriter out) throws IOException {
		int t = Integer.parseInt(file.readLine());
		while(t-->0) {
			StringTokenizer st = new StringTokenizer(file.readLine());
			int n = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			Shape[] shapes = new Shape[n+2];
			shapes[0] = new Shape(0);
			shapes[n+1] = new Shape(w);
			
			int ans = -1;
			UnionFind uf = new UnionFind(n + 2);
			for(int i = 1; i <= n; i++) {
				st = new StringTokenizer(file.readLine());
				double x = Double.parseDouble(st.nextToken());
				double y = Double.parseDouble(st.nextToken());
				double r = Double.parseDouble(st.nextToken());
				shapes[i] = new Shape(x, y, r);
				if(ans == -1 && !pathExists(uf, shapes, n, i)) {
					ans = i - 1;
				}
			}
			
			out.println(ans < 0 ? "Completely Undetected." : ans);
		}
	}
	
	public boolean pathExists(UnionFind uf, Shape[] shapes, int n, int index) {
		if(shapes[0].intersects(shapes[index])) {
			uf.union(0, index);
		}
		
		for(int i = 1; i < index; i++) {
			if(shapes[index].intersects(shapes[i])) {
				uf.union(i, index);
			}
		}
		
		if(shapes[n+1].intersects(shapes[index])) {
			uf.union(n+1, index);
		}
		
		return uf.find(0) != uf.find(n+1);
	}
}
