import java.util.*;
import java.io.*;

public class intensity {
    public void run() throws Exception {
        Scanner bob = new Scanner(new File("intensityj.dat"));
//         Scanner bob = new Scanner(System.in);
        int n = bob.nextInt();
        int cnt = 0;
        int days = 0;
        while(bob.hasNext()) {
            String next = bob.next();
            if(next.equals("END")) {
                System.out.println(cnt < 5 ? "needs more effort" : cnt > 6 ? "junk volume" : "just right");
                cnt = 0;
                if(++days >= n) {
                    break;
                }
            }
            else
            {
                cnt++;
            }

        }
    }

    public static void main(String[] args) throws Exception {
        new intensity().run();
    }
}
