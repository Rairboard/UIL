import java.io.*;
import java.util.*;

public class Organizing {
  public static void main(String[] args) throws IOException {
	  	Scanner in = new Scanner(new File("organizing.in"));

		int cases = in.nextInt();

		Item[] items = new Item[cases];

		for(int i = 0; i < cases; i++) {
			items[i] = new Item(in.next(), in.nextInt(), in.nextInt(), in.nextInt());
		}
		Arrays.sort(items);

		System.out.println(Arrays.toString(items).replaceAll("[\\[\\] ]+", " ").trim());
  }

	public static class Item implements Comparable<Item> {
		public int utility , weight, cost;
		public String name;

		public Item(String name, int utility , int weight, int cost) {
			this.utility  = utility ;
			this.weight = weight;
			this.cost = cost;
			this.name = name;
		}

		public int compareTo(Item i) {
			int valComp = Integer.compare(i.utility , utility );
			if(valComp != 0)
				return valComp;
			
			int weiComp = Integer.compare(weight, i.weight);
			if(valComp != 0)
				return valComp;

			int cosComp = Integer.compare(i.cost, cost);
			return cosComp;
		}

		public String toString() {
			return name;
		}
	}
}