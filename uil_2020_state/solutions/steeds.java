import java.util.*;
import java.io.*;

public class steeds {
    public void run() throws Exception {
        Scanner bob = new Scanner(new File("steeds.dat"));
	int t = bob.nextInt();
	while(t-->0) {
        int n = bob.nextInt();
        int total = 0;
        int horses = 0;
        while(n-->0)
        {
            int x = bob.nextInt();
            String s = bob.next();
            if(s.equals("horse"))
            {
                horses++;
                total += x;
            }
        }
        System.out.println(horses + " " + total);
	}
    }

    public static void main(String[] args) throws Exception {
        new steeds().run();
    }
}
