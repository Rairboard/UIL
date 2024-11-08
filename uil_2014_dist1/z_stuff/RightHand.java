//Right Hand - Solution
import java.io.*;
import java.util.*;
import java.awt.Point;

public class RightHand {
	public static void main(String args[]) throws Exception {
		Scanner scan = new Scanner(new File("righthand.dat"));
		int test_cases = scan.nextInt();

		while (test_cases-- > 0) {
			int n = scan.nextInt();
			scan.nextLine();

			char[][] maze = new char[n][n];
			for (int i = 0; i < n; i++) {
				maze[i] = scan.nextLine().toCharArray();
			}

			boolean solvable = solvable(maze);
			System.out.println(solvable ? "YES" : "NO");
		}
		scan.close();
	}

	public static boolean solvable(char[][] maze) {
		int[][] d = {
			{0, 1},
			{1, 0},
			{0, -1},
			{-1, 0}
		};
		boolean[][] moved = new boolean[maze.length][maze[0].length];
		HashSet<Point> set = new HashSet<Point>();
		moved[0][0] = true;
		set.add(new Point(0, 0));

		while (!set.isEmpty()) {
			HashSet<Point> newSet = new HashSet<Point>();
			for (Point p : set) {
				int r = p.x, c = p.y;
				for (int[] step : d) {
					int rPrime = r + step[0], cPrime = c + step[1];
					if (valid(maze, rPrime, cPrime) &&
						maze[rPrime][cPrime] == '.' &&
						!moved[rPrime][cPrime]) {
						newSet.add(new Point(rPrime, cPrime));
						moved[rPrime][cPrime] = true;
					}
				}
			}
			set = newSet;
		}

		return moved[maze.length - 1][maze[0].length - 1];
	}

	public static boolean valid(char[][] maze, int r, int c) {
		return r >= 0 && c >= 0 && r < maze.length && c < maze[0].length;
	}
}
/*
Test data:
6
3
...
.##
.#.
5
.###.
...#.
.###.
...##
.#...
10
.....#..##
#.#..###.#
#...#.#...
.#.##.##..
....#..##.
..#....#..
.####.#.#.
#.#.#.##..
.........#
.#.....#..
5
.....
...#.
.###.
#..##
.#...
20
..#....####......#..
#..#..#.#..#.#...#..
#.##...#.##...#...##
....###...#.##.##..#
...#...##...#...##..
......#..#....#.....
..#.##..#.###..#....
#...##......##...#..
...##.....##..#....#
#..##..#.##..#...#..
.#.......#...##.....
.....##.#..##.#.#.#.
#.#.#..#.##...##...#
#.##.#..............
#.#..##....#........
..#...##.#........##
#.#...#.#.#....#....
#..##....##...###..#
.......###..#.....#.
###...#.#.###.#.##..
25
...#...#...##...#..#.#..#
#..#..#.#...##..##..##...
.#..#.........#.......##.
...#..#.....##.#.####....
##......#..##.#....#..##.
...#...###...###.#..#....
##.####..#.#...####.....#
.#....#....#..#..###.....
####.#.....#.#.....#...#.
#.#....#..#...###....#.#.
#..#...####.#.....#....##
....#.###.###.......##.##
#.#.#....#.#...####.....#
#....#..#..#..#.......#.#
..#....#...#.##....#.##..
..#.####.....#..##......#
......##...#....#........
.....#...#..###....#.#...
##...#.#........#.##...##
###......#..#....##.#..#.
.##..............##.#.#.#
.#..#.###.#.###...#.....#
..##...####...#...#.#....
...#......#.######..#.#..
#.#...#...#........##..#.

Output:
NO
YES
YES
NO
NO
YES

*/