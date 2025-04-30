import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Veerasamy {
    public static void main(String[] args) throws IOException {
        new Veerasamy().run();
    }

    private void run() throws IOException {
        BufferedReader file = new BufferedReader(new FileReader("veerasamy.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        solve(file, out);

        file.close();
        out.close();
    }

    private class Vertex {
        public double x, y;

        public Vertex(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    private class Edge {
        public Vertex u, v;
        public double m, b;

        public Edge(Vertex u, Vertex v) {
            this.u = u;
            this.v = v;
            this.m = (v.y - u.y) / (v.x - u.x);
            this.b = u.y - m * u.x;
        }
    }

    private static final String CONVEX = "Convex";
    private static final String SAFE = "Safe and sound.";
    private static final String UNSAFE = "Dreaded dimensional downgrade!";

    public void solve(BufferedReader file, PrintWriter out) throws IOException {
        int T = Integer.parseInt(file.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(file.readLine());
            int n = Integer.parseInt(st.nextToken());
            String s = st.nextToken();

            // Given n points, there will be n edges in the polygon
            Edge[] edges = new Edge[n];

            // Read in the first point
            st = new StringTokenizer(file.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            Vertex prev = new Vertex(x, y);

            // Needed to find the split between the upper and lower chains
            Vertex rightMostVertex = prev;
            int rightMostVertexIndex = 0;

            // Read in the rest of the points, creating edges as we go
            for (int i = 1; i < n; i++) {
                // Read in the next point
                st = new StringTokenizer(file.readLine());
                x = Double.parseDouble(st.nextToken());
                y = Double.parseDouble(st.nextToken());
                Vertex curr = new Vertex(x, y);
                // Create the edge
                edges[i - 1] = new Edge(prev, curr);

                // Update the right-most vertex
                if (curr.x > rightMostVertex.x) {
                    rightMostVertex = curr;
                    rightMostVertexIndex = i;
                }
                // Update the previous vertex
                prev = curr;
            }
            // Create the last edge
            edges[n - 1] = new Edge(prev, edges[0].u);

            // Read in the query point
            st = new StringTokenizer(file.readLine());
            x = Double.parseDouble(st.nextToken());
            y = Double.parseDouble(st.nextToken());
            Vertex q = new Vertex(x, y);

            // Solve the testcase
            // Note: the bounds of the problem allow you to use the algorithm for solving
            // concave polygons for both convex and convave polygons, but this is faster
            boolean ans = s.equals(CONVEX) ? solveConvex(edges, q, rightMostVertexIndex)
                    : solveConcave(edges, q);
            out.println(ans ? SAFE : UNSAFE);
        }
    }

    // O(log n) solution for convex polygons
    private boolean solveConvex(Edge[] edges, Vertex q, int rightMostVertexIndex) {
        /*
         * Since the polygon P is convex...
         * 
         * 1. If q is inside P, then a vertical ray up from q intersects exactly one
         * edge (and a vertical ray down from q intersects exactly one edge)
         * 2. If q is outside P, then either zero or two edges intersect a vertical ray
         * up from q
         * 
         * Since the points are given in clockwise order, and we know the index of the
         * right-most vertex, we can binary search the upper- and lower-chains for their
         * intersections and determine if q is inside or outside the polygon using the
         * rules above.
         */

        int numIntersects = 0;
        // Check if a vertical ray up from q intersects any edge in the upper chain
        numIntersects += binarySearch(edges, q, 0, rightMostVertexIndex - 1, true) ? 1 : 0;
        // Check if a vertical ray down from q intersects any edge in the lower chain
        numIntersects += binarySearch(edges, q, rightMostVertexIndex, edges.length - 1, false) ? 1 : 0;
        return numIntersects == 2;
    }

    private boolean binarySearch(Edge[] edges, Vertex q, int start, int end, boolean isUpper) {
        while (start <= end) {
            int mid = (start + end) / 2;

            int res = rayIntersects(edges[mid], q, isUpper);

            if (res == 0) {
                return true;
            } else if (res == -2) {
                return false;
            } else if (res == -1) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }

    private int rayIntersects(Edge e, Vertex v, boolean isUpper) {
        Vertex left, right;
        if (e.u.x < e.v.x) {
            left = e.u;
            right = e.v;
        } else {
            left = e.v;
            right = e.u;
        }

        if (v.x < left.x) {
            return -1; // q is to the left of the edge
        } else if (v.x > right.x) {
            return 1; // q is to the right of the edge
        }

        double y = e.m * v.x + e.b;
        boolean intersects = isUpper ? y > v.y : y < v.y;
        return intersects ? 0 : -2; // vertical ray intersects edge / doesn't intersect edge
    }

    // O(n) solution for concave polygons
    private boolean solveConcave(Edge[] edges, Vertex q) {
        /*
         * Since the polygon P is concave...
         * 
         * 1. If q is inside P, then a vertical ray up from q intersects an odd number
         * of edges.
         * 2. If q is outside P, then a vertical ray up from q intersects an even number
         * of edges.
         * 
         * So check all n edges and count the number of intersectiosn given a vertical
         * ray up from q.
         */
        int numIntersects = 0;
        for (Edge e : edges) {
            int res = rayIntersects(e, q, true);
            if (res == 0) {
                numIntersects++;
            }
        }
        return numIntersects % 2 == 1;
    }
}
