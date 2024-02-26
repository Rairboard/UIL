//UIL District 2019 Solution
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Gowri {

    public static void weirdSquare(int num) {
        System.out.print("    ");
        for (int i = 0; i < num; i++) {
            System.out.print("*");
        }
        System.out.println("");
///////////////////////////////////////////
        System.out.print("   *");
        for (int i = 0; i < num; i++) {
            System.out.print(" ");
        }
        System.out.println("*");
///////////////////////////////////////////////////////////////
        System.out.print("  *");
        for (int i = 0; i < num+1; i++) {
            System.out.print(" ");
        }
        System.out.println(" *");
///////////////////////////////////////////////////////////////
        System.out.print(" *");
        for (int i = 0; i < num+2; i++) {
            System.out.print(" ");
        }
        System.out.println("  *");
///////////////////////////////////////////////////////////////        
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num + 8; j++) {
                if (j == 0 || j == (num + 7)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
////////////////////////////////////////////////
   System.out.print(" *");
        for (int i = 0; i < num+2; i++) {
            System.out.print(" ");
        }
        System.out.println("  *");
///////////////////////////////////////////////////////////////        
        System.out.print("  *");
        for (int i = 0; i < num+1; i++) {
            System.out.print(" ");
        }
        System.out.println(" *");
///////////////////////////////////////////////////////////////
 System.out.print("   *");
        for (int i = 0; i < num; i++) {
            System.out.print(" ");
        }
        System.out.println("*");
//////////////////////////////////////////////////
        System.out.print("    ");
        for (int i = 0; i < num; i++) {
            System.out.print("*");
        }
        System.out.println("");
    }

    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        Scanner file = new Scanner(new File("gowri.dat"));
        file.nextInt();
        while (file.hasNextInt()) {
                    weirdSquare(file.nextInt());
                    System.out.println("--------------------");
        }

    }

}
