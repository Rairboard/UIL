import java.util.*;
import java.io.*;

public class security {
    public void run() throws Exception {
        Scanner bob = new Scanner(new File("securityj.dat"));
        // Scanner bob = new Scanner(System.in);
        int n = bob.nextInt();
        bob.nextLine();
        while(n-->0) {
            String m = bob.nextLine();
            boolean ans = true;
            if(m.length() < 8 || m.replaceAll("[^A-Z]","").length() < 1 || m.replaceAll("[^a-z]" ,"").length() < 1 || m.replaceAll("[^0-9]","").length() < 1 || m.replaceAll("[^A-Za-z0-9\\_\\?\\-]","").length() != m.length())
            {
                System.out.println("thumbs down");
            }
            else {
                System.out.println("thumbs up");
            }

        }
    }

    public static void main(String[] args) throws Exception {
        new security().run();
    }
}
