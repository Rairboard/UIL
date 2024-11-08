import java.util.*;
import java.io.*;

public class incline {
    public void run() throws Exception {
        Scanner bob = new Scanner(new File("incline.dat"));
        // Scanner bob = new Scanner(System.in);
        int n = bob.nextInt();
        while(n-->0){
            int l = bob.nextInt();
            for(int i = 1; i <= l; i++) {
                System.out.println(" ".repeat(l-i) + "#".repeat(i));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        new incline().run();
    }
}
