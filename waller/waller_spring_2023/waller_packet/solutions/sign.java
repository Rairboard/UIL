import java.util.*;
import java.io.*;

public class sign {
    public void run() throws Exception {
        Scanner bob = new Scanner(new File("signj.dat"));
        int n = bob.nextInt(); bob.nextLine();
        while(n-->0) {
            System.out.println(new StringBuilder(bob.nextLine()).reverse().toString());
        }
    }

    public static void main(String[] args) throws Exception {
        new sign().run();
    }
}
