import java.util.*;
import java.io.*;

public class scramble {
    TreeSet<String> set;
    public void permu(String og, String current) {
        if(og.length() <= 0) {
            set.add(current);
            return;
        }
        for(int i =0; i < og.length(); i++) {
            permu(og.substring(0,i) + og.substring(i+1), current + og.charAt(i));
        }
    }
    public void run() throws Exception {
        Scanner bob = new Scanner(new File("scramblej.dat"));
        // Scanner bob = new Scanner(System.in);
        int t = bob.nextInt();
        while(t-->0) {
            set = new TreeSet<>(Collections.reverseOrder());
            String s = bob.next();
            permu(s,"");
            int i = 0;
            for(String g : set){
                if(i == 5)
                    break;
                System.out.print(g + " ");
                i++;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        new scramble().run();
    }
}
