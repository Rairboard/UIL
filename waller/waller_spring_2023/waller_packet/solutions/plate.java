import java.util.*;
import java.io.*;

public class plate {
    public void run() throws Exception {
//        Scanner bob = new Scanner(new File("plate.dat"));
        // Scanner bob = new Scanner(System.in);
        System.out.print("####$$####\n" +
                "##OOOOOO##\n" +
                "#OoOOO$oO#\n" +
                "$ooooOooo#\n" +
                "Oooo$$oOO$\n" +
                "OoooO$oOO$\n" +
                "$oooooooo#\n" +
                "#oooOOOo$#\n" +
                "##Ooooo$##\n" +
                "###$O$####\n");
    }

    public static void main(String[] args) throws Exception {
        new plate().run();
    }
}
