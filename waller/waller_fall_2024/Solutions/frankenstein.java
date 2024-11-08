import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class frankenstein {
    static int[][] directions = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };
    static Point[][] maze;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("judges\\frankenstein.dat"));
        int runs = sc.nextInt();
        for (int i = 0; i < runs; i++) {
            int size = sc.nextInt(); sc.nextLine();
            maze = new Point[size][size];
            Point start = null;
            Point target = null;
            for (int j = 0; j < size; j++) {
                char[] line = sc.nextLine().toCharArray();
                for (int k = 0; k < line.length; k++) {
                    Point p = maze[j][k] = new Point(j, k, line[k]);
                    if (line[k] == '@') {
                        start = p;
                    }
                    if(line[k]=='!'){
                        target = p;
                    }
                }
            }
            bfs(start);
            while(target != null){
                target.val = 'T';
                target = target.parent;
            }
            for (Point[] cs : maze) {
                for (Point p : cs) {
                    System.out.print(p.val=='T'?"*":"#");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static PriorityQueue<Point> getLegalNeighbors(Point p) {
        PriorityQueue<Point> nbs = new PriorityQueue<>();
        for (int[] offsets : directions)
            if (isValid(p.r + offsets[0], p.c + offsets[1]))
                nbs.add(maze[p.r + offsets[0]][p.c + offsets[1]]);
        return nbs;
    }

    public static void bfs(Point source) {
        PriorityQueue<Point> queue = new PriorityQueue<Point>();
        source.dist = 0;
        queue.add(source);
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            p.observed = true;
            for (Point temp : getLegalNeighbors(p)) {
                temp.observed = true;
                if (temp.dist > p.dist + 1) {
                    temp.dist = p.dist + 1;
                    temp.parent = p;
                }
                queue.add(temp);
            }
        }
    }

    public static boolean isValid(int r, int c) {
        return r >= 0 && r < maze.length && c >= 0 && c < maze[0].length && maze[r][c].val != '#'
                && !maze[r][c].observed;
    }
}

class Point implements Comparable<Point> {
    int r, c;
    char val;
    Point parent;
    int dist = Integer.MAX_VALUE;
    boolean observed = false;

    Point(int r, int c, char val) {
        this.r = r;
        this.c = c;
        this.val = val;
    }

    public int compareTo(Point o) {
        return this.dist - dist;
    }
}