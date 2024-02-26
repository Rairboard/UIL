import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class planning {
    public void run() throws Exception {
        Scanner bob = new Scanner(new File("planningj.dat"));
        // Scanner bob = new Scanner(System.in);
        SimpleDateFormat f = new SimpleDateFormat("MM/dd/yyyy");
        int n = bob.nextInt();
        while(n-->0) {
            int t = bob.nextInt();
            ArrayList<Calendar> list = new ArrayList<>();
            while(t-->0) {
                Calendar temp = Calendar.getInstance();
                temp.setTime(f.parse(bob.next()));
                if(temp.getTime().getDay() != 0 && temp.getTime().getDay() != 6) {
                    continue;
                }
                list.add(temp);
            }
            Collections.sort(list);
            for(Calendar k : list) {
                System.out.println(f.format(k.getTime()));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        new planning().run();
    }
}
