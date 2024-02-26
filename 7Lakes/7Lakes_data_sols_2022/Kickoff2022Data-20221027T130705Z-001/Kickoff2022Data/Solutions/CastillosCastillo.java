import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CastillosCastillo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        for (int i = 0; i < N; i++) {
            int M = in.nextInt();
            Point[] points = new Point[M];

            for (int j = 0; j < M; j++) {
                points[j] = new Point(in.nextInt(), in.nextInt());
            }

            Arrays.sort(points);
            ArrayList<Point> border = getPointsOfWall(points);
            double perimeter = getPerimeter(border);

            System.out.printf("%.2f", perimeter);
            System.out.println();
        }
    }

    public static ArrayList<Point> getPointsOfWall(Point[] points) {
        ArrayList<Point> border = new ArrayList<>();

        int leftmost = 0;

        for (int i = 0; i < points.length; i++) {
            if (points[i].x < points[leftmost].x) {
                leftmost = i;
            }
        }

        int index = leftmost;
        int nextIndex;

        do {
            border.add(points[index]);

            nextIndex = (index + 1) % points.length;

            for (int i = 0; i < points.length; i++) {
                if (isCounterclockwiseTurn(points[index], points[i], points[nextIndex])) {
                    nextIndex = i;
                }
            }

            index = nextIndex;
        } while (index != leftmost);

        return border;
    }

    public static boolean isCounterclockwiseTurn(Point a, Point b, Point c) {
        return (b.y - a.y) * (c.x - b.x) - (b.x - a.x) * (c.y - b.y) > 0;
    }

    public static double getPerimeter(ArrayList<Point> border) {
        double perimeter = Math.sqrt(Math.pow(border.get(0).x - border.get(border.size() - 1).x, 2) +
                           Math.pow(border.get(0).y - border.get(border.size() - 1).y, 2));

        while (border.size() > 1) {
            perimeter += Math.sqrt(Math.pow(border.get(0).x - border.get(1).x, 2) +
                                    Math.pow(border.get(0).y - border.get(1).y, 2));
            border.remove(0);
        }

        return perimeter;
    }
}

class Point implements Comparable<Point> {
    int x, y;

    public Point(int x, int y) {
        this.x = x; this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if (x == o.x) {
            return Integer.compare(y, o.y);
        }
        return Integer.compare(x, o.x);
    }
}