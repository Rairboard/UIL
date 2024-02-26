// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		System.out.println(10);
		for (int t = 0; t < 10; t++) {
			if (t == 0) {
				System.out.println("8 9 1 8\n1 2\n2 3\n3 8\n1 4\n4 5\n5 6\n6 7\n7 8\n1 8");
			}
			else if (t == 4) {
				System.out.println("2 1 1 2\n2 1");
			}
			else if (t == 1 || t == 6 || t == 8) {
				int len = 2 * (int) (Math.random() * 4) + 3;
				int count = 4;
				int prev = 1;
				int cur = 2;
				System.out.println((len - 1) * count + 2 + " " + len * count + " " + 1 + " " + ((len - 1) * count + 2));
				for (int i = 0; i < count; i++) {
					prev = 1;
					for (int j = 0; j < len - 1; j++) {
						System.out.println(prev + " " + cur);
						prev = cur;
						cur++;
					}
					System.out.println(prev + " " + ((len - 1) * count + 2));
				}
			}
			else {
				ArrayList<HashSet<Integer>> edges = new ArrayList<>();
				int n = (int) (Math.random() * 10) + 5;
				for (int i = 0; i < n; i++) {
					edges.add(new HashSet<>());
				}
				for (int i = 0; i < n; i++) {
					int add = (int) (Math.random() * 7) + 1;
					HashSet<Integer> added = new HashSet<>();
					for (int j = 0; j < add && added.size() != n - 1; j++) {
						int x = (int) (Math.random() * n);
						while (added.contains(x) || x == i) {
							x = (int) (Math.random() * n);
						}
						added.add(x);
						edges.get(i).add(x);
						edges.get(x).add(i);
					}
				}
				int m = 0;
				StringBuffer ans = new StringBuffer();
				HashSet<Integer> seen = new HashSet<>();
				for (int i = 0; i < n; i++) {
					for (int j : edges.get(i)) {
						if (seen.contains(i * 100000 + j) || seen.contains(j * 100000 + i)) continue;
						seen.add(i * 100000 + j);
						ans.append((i + 1) + " " + (j + 1) + "\n");
						m++;
					}
				}
				System.out.print(n + " " + m + " " + 2 + " " + (n - 2) + "\n" + ans);
			}
		}
	}
}
