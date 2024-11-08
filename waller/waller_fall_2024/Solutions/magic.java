import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class magic {
    static final String[] codes = {"ED AB EE DB","4D 5A","25 50 44 46 2D","23 40 7E 5E","CA FE BA BE","7F 45 4C 46","42 43","D0 CF 11 E0 A1 B1 1A E1"};
    static final String[] bad_extensions = {"rpm","exe","pdf","vbs","class","elf","bc","msi"};
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("magic.dat"));
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            int bad = -1;
            for(int i = 0; i < codes.length; i++){
                if(line.startsWith(codes[i])){
                    bad = i;
                    line = line.replace(codes[i],"").strip();
                    break;
                }
            }
            String[] nums = line.split(" ");
            String res = "";
            for(String s: nums){
                res+=""+(char)Integer.parseInt(s,16);
            }
            if(bad==-1){
                System.out.println(res);
            }
            else{
                System.out.println("BAD_"+res+"."+bad_extensions[bad]);
            }
        }
    }
}
