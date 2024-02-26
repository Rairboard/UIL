import java.util.*;
import java.io.*;

public class currency {
    HashMap<String,Map<String,Double>> m;
    String end;
    double ans;
    public void trav(String pos,double rate,String visited)
    {
        if(pos.equals(end))
        {
            ans = rate;
            return;
        }
        for(String curr : m.get(pos).keySet())
        {
            if(!visited.contains(curr))
            {
                trav(curr,rate * m.get(pos).get(curr), visited + " " + pos);
            }
        }
    }

    public void run() throws Exception {
        Scanner bob = new Scanner(new File("currency.dat"));
        // Scanner bob = new Scanner(System.in);
        int x = bob.nextInt();
        while(x-->0) {
            int t = bob.nextInt();
            m = new LinkedHashMap<>();
            while (t-- > 0) {
                m.put(bob.next(), new HashMap<>());
            }
            int n = bob.nextInt();
            while (n-- > 0) {
                String one = bob.next();
                String two = bob.next();
                double conv = bob.nextDouble();
                m.get(one).put(two, conv);
                m.get(two).put(one, 1.0 / conv);
            }
            String start = bob.next();
            end = bob.next();
            ans = -1.0;
            trav(start, 1, "");
            if(ans < 0) {
                System.out.println("NO CONVERSION RATE AVAILABLE");
            }
            else {
                System.out.printf("%.2f%n",ans);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new currency().run();
    }
}
