import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * hayride
 */
public class hayride {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("hayride.dat"));
        for (int runs = Integer.parseInt(sc.nextLine()); runs > 0; runs--) {
            HashMap<String, Stop> stops = new HashMap<>();
            for (int lines = Integer.parseInt(sc.nextLine()); lines > 0; lines--) {
                String[] parts = sc.nextLine().split(" ");
                int dist = Integer.parseInt(parts[2]);
                if (!stops.containsKey(parts[0])) {
                    stops.put(parts[0], new Stop(parts[0]));
                }
                if (!stops.containsKey(parts[1])) {
                    stops.put(parts[1], new Stop(parts[1]));
                }
                stops.get(parts[0]).connections.put(stops.get(parts[1]), dist);
                stops.get(parts[1]).connections.put(stops.get(parts[0]), dist);
            }
            ArrayList<Stop> queue = new ArrayList<>(stops.values());
            djikstra(stops.get("Start"), queue);
            String path = "";
            Stop target = stops.get("Stop");
            while (target != null) {
                path = target.name + "\n" + path;
                target = target.prev;
            }
            System.out.println(path);
        }
    }

    public static void djikstra(Stop source, ArrayList<Stop> queue) {
        source.distToSource = 0;
        while (!queue.isEmpty()) {
            queue.sort(null);
            Stop temp = queue.removeFirst();
            for (Stop st : temp.connections.keySet()) {
                if (queue.contains(st)) {
                    int altDist = temp.distToSource + temp.connections.get(st);
                    if (altDist < st.distToSource) {
                        st.distToSource = altDist;
                        st.prev = temp;
                    }
                }
            }
        }
    }
}
class Stop implements Comparable<Stop> {
    String name;
    int distToSource = Integer.MAX_VALUE;
    Stop prev;
    HashMap<Stop, Integer> connections = new HashMap<>();

    public Stop(String name) {
        this.name = name;
    }

    public int compareTo(Stop o) {
        return this.distToSource - o.distToSource;
    }
}