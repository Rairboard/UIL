import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Packing {
	public static class Item implements Comparable<Item> {
		public String name;
		public int price, weight;

		public Item(String name, int price, int weight) {
			this.name = name;
			this.price = price;
			this.weight = weight;
		}

		@Override
		public int compareTo(Item item) {
			if (name.compareTo(item.name) != 0) {
				return name.compareTo(item.name);
			}

			if (Integer.compare(price, item.price) != 0) {
				return Integer.compare(price, item.price);
			}

			if (Integer.compare(weight, item.weight) != 0) {
				return Integer.compare(weight, item.weight);
			}

			return 0;
		}

		public String toString() {
			return name + " " + price + " " + weight;
		}
	}

	public static void getItems(Item[] items, int sackCapacity) {
		int[][] dpTable = new int[items.length + 1][sackCapacity + 1];
		boolean[][] keep = new boolean[items.length][sackCapacity + 1];

		for (int i = 1; i <= items.length; i++) {
			for (int w = 1; w <= sackCapacity; w++) {
				if (items[i - 1].weight > w) {
					dpTable[i][w] = dpTable[i - 1][w];
				} else {
					int pYes = items[i - 1].price + dpTable[i - 1][w - items[i - 1].weight];
					int pNo = dpTable[i - 1][w];
					if (pYes > pNo) {
						keep[i - 1][w] = true;
						dpTable[i][w] = pYes;
					} else {
						dpTable[i][w] = pNo;
					}
				}
			}
		}

		ArrayList<Item> outItems = new ArrayList<>();

		for (int i = items.length - 1; i >= 0; i--) {
			if (keep[i][sackCapacity] == true) {
				outItems.add(items[i]);
				sackCapacity -= items[i].weight;
			}
		}

		Collections.sort(outItems);
		for (Item i : outItems) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("packing.in"));

		int itemNum = in.nextInt();
		int sackCapacity = in.nextInt();

		Item[] items = new Item[itemNum];

		for (int i = 0; i < items.length; i++) {
			items[i] = new Item(in.next(), in.nextInt(), in.nextInt());
		}

		getItems(items, sackCapacity);
	}
}