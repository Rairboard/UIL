import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class cipher {
    public static String encodeString(String m, String k){
        String enc = "";
        char grid[][] = new char[m.length()/k.length()][k.length()];
        for(int i = 0; i < m.length(); i += k.length()){
            grid[i/k.length()]=m.substring(i,i+k.length()).toCharArray();
        }
        char[] temp = k.toCharArray();
        Arrays.sort(temp);
        char[][] finalGrid = new char[grid.length][k.length()];
        for(int i = 0; i < m.length(); i++){
            finalGrid[i/k.length()][i%k.length()]=grid[i/k.length()][k.indexOf(temp[i%k.length()])];
        }
        for (int c = 0; c < k.length(); c++){
            for (int r = 0; r < finalGrid.length; r++) {
                enc+=finalGrid[r][c];
            }
        }
        return enc;
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("cipher.dat"));
       while(sc.hasNextLine()){
            String[] s = sc.nextLine().split(" ");
            System.out.println(encodeString(s[1], s[0]));
        }
    }
}
