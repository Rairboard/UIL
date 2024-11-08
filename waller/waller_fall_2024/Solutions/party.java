import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class party {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("party.dat"));
        double total = 0;
        while(sc.hasNextLine()){
            String[] in = sc.nextLine().split(" ");
            total+= Double.parseDouble(in[0])*Integer.parseInt(in[1]);
        }
        System.out.println((int)Math.ceil(total));
    }
}
