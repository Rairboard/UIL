/*Region UIL 2014 Solution - #9 - Shirts
Test data
4
2
1 R M
2 O S
5
8 G M
12 G S
5 R M
15 Y L
6 Y L
10
0 R M
1 O S
2 G L
3 G M
4 O M
5 G L
6 Y M
7 O M
8 O S
9 Y L
20
0 R S
1 O L
2 B M
3 Y S
4 R M
5 R M
6 R S
7 O L
8 Y L
9 O L
10 R S
11 Y L
12 G M
13 O S
14 G L
15 O S
16 O S
17 O S
18 R S
19 Y S

Output
1 2
5 6 15 12 8
0 1 8 4 7 6 9 3 2 5
0 6 10 18 4 5 13 15 16 17 1 7 9 3 19 8 11 12 14 2

*/
import java.io.*;
import java.util.*;

public class Shirts {
	static final char[] colors = new char[]{'R', 'O', 'Y', 'G', 'B'};
	static final char[] sizes = new char[] {'S', 'M', 'L'};
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("shirts.dat"));
		int T = Integer.parseInt(in.nextLine().trim());
		while (T-- > 0) {
			int N = Integer.parseInt(in.nextLine().trim());
			ArrayList<Shirt> shirts = new ArrayList<Shirt>();
			while (N-- > 0) {
				String[] line = in.nextLine().trim().split("\\s+");
				shirts.add(new Shirt(line[1].charAt(0), line[2].charAt(0), Integer.parseInt(line[0])));
			}
			Collections.sort(shirts);
			for (int i = 0; i < shirts.size(); i++) {
				if (i != 0) System.out.print(" ");
				System.out.print(shirts.get(i).id);
			}
			System.out.println();
		}
	}
	static class Shirt implements Comparable<Shirt> {
		char color, size;
		int id;
		Shirt(char c, char s, int id) {
			this.color = c;
			this.size = s;
			this.id = id;
		}
		public int compareTo(Shirt s) {
			if (this.color == s.color) {
				if (this.size == s.size) {
					return this.id - s.id;
				} else {
					return indexOf(this.size, sizes) - indexOf(s.size, sizes);
				}
			} else {	
				return indexOf(this.color, colors) - indexOf(s.color, colors);
			}
		}
	}
	public static int indexOf(char color, char[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == color) return i;
		}
		return -1;
	}
}
