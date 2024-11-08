import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class spooky {
    public static void main(String[] args) throws FileNotFoundException {
        String[] nums = new Scanner(new File("spookynums.dat")).nextLine().split(" ");
        for(String s: nums){
            long n = Long.parseLong(s);
            int count = 0;
            if(n % 10 == 4 || n % 10 == 9){
                count++;
            }
            if(n % 17 == 0 || n % 39 == 0 || n % 43 == 0){
                count++;
            }
            if(Long.toHexString(n).toUpperCase().contains("F13")){
                count++;
            }
            if(Long.toString(n).contains("666")){
                count++;
            }
            switch (count) {
                case 0:
                    System.out.println(n + " Candy");
                    break;
                case 1:
                    System.out.println(n + " BOO!");
                    break;
                default:
                    System.out.println(n + " AAAA!");
                    break;
            }
        }
    }   
}