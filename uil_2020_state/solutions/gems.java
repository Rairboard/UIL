import java.util.*;
import java.io.*;

public class gems {
    public void run() throws Exception {
        Scanner bob = new Scanner(new File("gems.dat"));
        int n = bob.nextInt();
        while(n-->0)
        {
            int dim = bob.nextInt();
            char[][] mat = new char[dim][dim];
            int i =0;
            for(; i < dim; i+=2)
            {
                System.out.println(" ".repeat((dim-i)/2) + "$".repeat(i+1) + " ".repeat((dim-i)/2));
            }
            i-=4;
            for(; i >= 0; i-=2)
            {
                System.out.println(" ".repeat((dim-i)/2) + "$".repeat(i+1) + " ".repeat((dim-i)/2));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        new gems().run();
    }
}
