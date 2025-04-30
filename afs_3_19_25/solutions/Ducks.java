import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ducks {
	private enum Color {
		Red, Orange, Yellow, Green, Blue, Purple;
	}
	
	private enum Hat {
		Propeller, Party, Baseball, Fedora;
	}
	
	private class Duck implements Comparable<Duck> {
		public double height;
		public Color c;
		public Hat h;
		
		public Duck(double height, String color, String hat) {
			this.height = height;
			this.c = Color.valueOf(color);
			this.h = Hat.valueOf(hat);
		}
		
		@Override
		public int compareTo(Duck other) {
			int comp = Double.compare(height, other.height);
			if(comp != 0) {
				return comp;
			}
			
			comp = c.compareTo(other.c);
			if(comp != 0) {
				return comp;
			}
			
			return h.compareTo(other.h);
		}
		
		@Override
		public String toString() {
			return String.format("%s %s %s", height, c, h);
		}
	}
	
	public static void main(String[] args) throws IOException {
		new Ducks().run();
	}
	
	public void run() throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("Ducks/ducks.dat"));
		PrintWriter out = new PrintWriter(new File("Ducks/ducks.out"));
		
		int n = Integer.parseInt(file.readLine());
		Duck[] ducks = new Duck[n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(file.readLine());
			ducks[i] = new Duck(Double.parseDouble(st.nextToken()), st.nextToken(), st.nextToken());
		}
		file.close();
		
		Arrays.sort(ducks);
		out.println(Arrays.toString(ducks).replaceAll("[\\[\\]]", "").replaceAll(", ", "\n"));
		out.close();
	} 
}
