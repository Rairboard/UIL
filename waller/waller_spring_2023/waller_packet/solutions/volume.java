import java.util.*;
import java.io.*;

public class volume {
    public void run() throws Exception {
        Scanner bob = new Scanner(new File("volumej.dat"));
        // Scanner bob = new Scanner(System.in);
        int n = bob.nextInt();
        while(n-->0) {
            System.out.println(bob.nextInt()* bob.nextInt() * bob.nextInt());
        }
    }

    public static void main(String[] args) throws Exception {
        new volume().run();
    }
}
