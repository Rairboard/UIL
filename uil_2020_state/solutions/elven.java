import java.util.*;
import java.io.*;

public class elven {
    public void run() throws Exception {
        Scanner bob = new Scanner(new File("elven.dat"));
        int t = bob.nextInt();
        while(t-->0)
        {
            int n = bob.nextInt();
            bob.nextLine();
            while(n-->0)
            {
                String line = bob.nextLine();
                for(int i = 0; i < line.length();i++)
                {
                    if(line.substring(i,i+1).matches("[AEIOU]"))
                    {
                        line = line.substring(0,i) + line.substring(i,i+1).toLowerCase() + line.substring(i+1);
                    }
                }
                System.out.println(new StringBuilder(line).reverse().toString());
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        new elven().run();
    }
}
