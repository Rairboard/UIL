import java.util.*;
import java.io.*;

public class booking {
    public class Patron implements Comparable<Patron>
    {
        int level;
        String f;
        String l;
        public Patron(String first,String last, int floor)
        {
            l = last;
            f = first;
            level = floor;
        }
        public int compareTo(Patron p) {
            if(level - p.level == 0)
            {
                if(l.compareTo(p.l) == 0)
                {
                    return f.compareTo(p.f);
                }
                return l.compareTo(p.l);
            }
            return level-p.level;
        }
    }
    public void run() throws Exception {
        Scanner bob = new Scanner(new File("booking.dat"));
//        Scanner bob = new Scanner(System.in);
        int t = bob.nextInt();
        while(t-->0) {
            int n = bob.nextInt();
            ArrayList<Patron> list = new ArrayList<>();
            while(n-->0) {
                list.add(new Patron(bob.next(),bob.next(),bob.nextInt()));
            }
            Collections.sort(list);
            list.forEach(k -> System.out.println(k.f + " " + k.l));
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        new booking().run();
    }
}
