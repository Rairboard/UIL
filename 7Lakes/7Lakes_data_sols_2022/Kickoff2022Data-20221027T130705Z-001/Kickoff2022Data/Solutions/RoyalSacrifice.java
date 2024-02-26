import java.io.*;
import java.util.*;

public class RoyalSacrifice {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        sc.nextLine();
        for(int t = 0; t < c; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            Peasant[] Peasants = new Peasant[n];
            int[] ps = new int[n+1];
            for(int i = 0; i < n; i++) {
                Peasants[i] = new Peasant(sc.next(), sc.nextInt());
                sc.nextLine();
            }
            Arrays.sort(Peasants);

            for(int i = 0; i < n; i++) {
                ps[i+1] = ps[i] + Peasants[i].val;
            }
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < n-m+1; i++) {
                min = Math.min(min, ps[i+m]-ps[i]);
            }
            System.out.println(min);
        }
    }
}

class Peasant implements Comparable<Peasant>{
    String name;
    int val;
    public Peasant(String n, int v) {
        name = n;
        val = v;
    }
    public int compareTo(Peasant b) {
        if(name.compareTo(b.name) == 0) {
            return Integer.compare(val,b.val);
        }
        return name.compareTo(b.name);
    }

}