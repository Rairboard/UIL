/*
 *UIL Computer Science 2020
 *Invitational B Packet Solution
 */
import java.io.*;
import java.util.*;

public class Josey {
    static final int INF = (int)1e9;

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("josey.dat"));
        int T = scan.nextInt();
        assert 1 <= T && T <= 20;

        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int B = scan.nextInt();
            assert 1 <= B && B <= 100000;
            Map<String, List<String>> graph = new HashMap<>();
            Map<String, Integer> distance = new HashMap<>();

            for (int i = 0; i < B; i++) {
                String u = scan.next();
                String v = scan.next();

                assert 1 <= u.length() && u.length() <= 20;
                assert 1 <= v.length() && v.length() <= 20;

                distance.put(u, INF);
                distance.put(v, INF);

                if (!graph.containsKey(u)) {
                    graph.put(u, new ArrayList<String>());
                }
                graph.get(u).add(v);
                if (!graph.containsKey(v)) {
                    graph.put(v, new ArrayList<String>());
                }
                graph.get(v).add(u);
            }

            assert graph.containsKey("OCEAN");

            distance.put("OCEAN", 0);
            Queue<String> q = new LinkedList<String>();
            q.add("OCEAN");

            while (!q.isEmpty()) {
                String u = q.poll();
                for (String v : graph.get(u)) {
                    if (distance.get(u) + 1 < distance.get(v)) {
                        distance.put(v, distance.get(u) + 1);
                        q.add(v);
                    }
                }
            }

            List<String> answer = new ArrayList<String>();
            for (Map.Entry<String, Integer> country : distance.entrySet()) {
                if (country.getValue() > 2) {
                    // 0 - ocean
                    // 1 - bordering ocean
                    // 2 - landlocked
                    // 3+ - doubly-landlocked
                    answer.add(country.getKey());
                }
            }

            Collections.sort(answer);
            System.out.printf("Case #%d: %d%n", caseNum, answer.size());
            for (String country : answer) {
                System.out.println(country);
            }
        }
    }
}
