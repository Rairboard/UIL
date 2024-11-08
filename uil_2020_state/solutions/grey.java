import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class grey {
    public void run() throws Exception {
        Scanner bob = new Scanner(new File("grey.dat"));
//        Scanner bob = new Scanner(System.in);
        int n = bob.nextInt();
        while(n-->0) {
            Calendar c = Calendar.getInstance();
            SimpleDateFormat f = new SimpleDateFormat("MM/dd/yyyy");
            String time = bob.next();
            int crystals = bob.nextInt();

            c.setTime(f.parse(time));
            c.set(c.getTime().getYear()+1900,c.getTime().getMonth(),c.getTime().getDate()-crystals*7);
            System.out.println(f.format(c.getTime()));
        }
    }

    public static void main(String[] args) throws Exception {
        new grey().run();
    }
}
