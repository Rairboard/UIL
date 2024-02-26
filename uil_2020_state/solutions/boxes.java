import java.util.*;
import java.io.*;

public class boxes {
    public void run() throws Exception {
        Scanner bob = new Scanner(new File("boxes.dat"));
//        Scanner bob = new Scanner(System.in);
        int k = bob.nextInt();
        bob.nextLine();
        while(k-->0)
        {
            String line = bob.nextLine();
            System.out.println(line.replaceAll("[^B]","") + line.replaceAll("[Bb]","") + line.replaceAll("[^b]",""));
        }
    }

    public static void main(String[] args) throws Exception {
        new boxes().run();
    }
}
