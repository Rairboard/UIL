import java.util.*;
import java.io.*;

public class forest {
    public void run() throws Exception {
        Scanner bob = new Scanner(new File("forest.dat"));
        int n = bob.nextInt();
        bob.nextLine();
        while(bob.hasNextLine())
        {
            String left = bob.nextLine();
            String right = bob.nextLine();
            boolean boulders = left.replaceAll("[^o]","").length() > right.replaceAll("[^o]","").length();
            boolean trees = left.replaceAll("[^i]","").length() > right.replaceAll("[^i]","").length();
            boolean bushes = left.replaceAll("[^m]","").length() > right.replaceAll("[^m]","").length();
            System.out.print("BOULDERS: ");
            System.out.println(boulders ? "LEFT" : "RIGHT");
            System.out.print("TREES: ");
            System.out.println(trees ? "LEFT" : "RIGHT");
            System.out.print("BUSHES: ");
            System.out.println(bushes ? "LEFT" : "RIGHT");
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        new forest().run();
    }
}
