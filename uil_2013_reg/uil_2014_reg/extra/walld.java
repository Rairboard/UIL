/*Region UIL 2014 Solution - #11- WallD
Test data
6
3 8
1 3 4
2 5 6
1 2 4
3 9
2 4 6
4 6 2
6 2 4
4 5
1 1 1 1
1 1 1 1
1 1 1 1
1 1 1 1
5 43
3 18 6 9 21
3 9 12 12 15
3 3 6 3 3
6 9 12 21 9
3 6 9 21 12
4 123
2 7 3 11
5 13 4 9
2 2 2 2
4 13 17 19
3 5
1 1 1
1 1 2
1 1 1

Output
1
-1
4
-1
8
3

*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class walld {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("walld.dat"));
		int t = sc.nextInt();
		while (t-- > 0) {
			// parse data
			int n = sc.nextInt();
			int k = sc.nextInt();
			sc.nextLine();
			int start = n / 2;
			String[][] arr = new String[n][n];
			for (int i = 0; i < n; i++)
				arr[i] = sc.nextLine().split("\\s+");
			//use a queue for breadth first search
			Queue<Pair> q = new LinkedList<Pair>();
			//add starting point
			q.add(new Pair(0, Integer.parseInt(arr[start][start]),
					start, start));
			int answer = -1;
			//if queue becomes empty, nothing worked and answer is -1
			while (!q.isEmpty()) {
				int temp;
				Pair p = q.remove();
				if (p.total == k) {
					answer = p.turn;
					break;
				}else if(p.total > k)
					continue;
				// check if he moved up, down, left or right as long as it's in range
				if (p.y > 0)
					q.add(new Pair(p.turn + 1, Integer
							.parseInt(arr[p.x][p.y - 1]) + p.total, p.x,
							p.y - 1));
				if (p.y < n - 1)
					q.add(new Pair(p.turn + 1, Integer
							.parseInt(arr[p.x][p.y + 1]) + p.total, p.x,
							p.y + 1));
				if (p.x > 0)
					q.add(new Pair(p.turn + 1, Integer
							.parseInt(arr[p.x - 1][p.y]) + p.total,
							p.x - 1, p.y));
				if (p.x < n - 1)
					q.add(new Pair(p.turn + 1, Integer
							.parseInt(arr[p.x + 1][p.y]) + p.total,
							p.x + 1, p.y));
			}
			System.out.println(answer);
		}
	}

}

class Pair {
	public int turn, total, x, y;

	public Pair(int n, int sum, int startX, int startY) {
		turn = n;
		total = sum;
		x = startX;
		y = startY;
	}
}
