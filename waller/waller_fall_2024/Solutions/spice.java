import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class spice {
    static ArrayList<String[]> subs = new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("spice.dat"));
        int numSubs = sc.nextInt();    sc.nextLine();
        while(numSubs-- > 0){
            subs.add(sc.nextLine().split(" "));
        }
        for(int i = Integer.parseInt(sc.nextLine()); i > 0; i--){
            int[] subPos = new int[subs.size()];
            Arrays.fill(subPos, 1);
            for (int j = Integer.parseInt(sc.nextLine()); j > 0; j--) {
                String line = sc.nextLine();
                for(int k = 0; k < subs.size(); k++){
                    if(line.contains(subs.get(k)[0])){
                        line = line.replace(subs.get(k)[0],subs.get(k)[subPos[k]]);
                        subPos[k]++;
                    }
                }
                System.out.println(line);
            }
            System.out.println();
        }
    }
}
