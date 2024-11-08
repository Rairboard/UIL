//Solution - UIL Region 2019
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Kavya {

    static void checkletter(ArrayList<letter> L, char let, int loc) {
        for (int i = 0; i < L.size(); i++) {
            if (L.get(i).let == let) {
                L.get(i).count++;
                return;
            }
        }
        L.add(new letter(loc, let));
    }

    public static void main(String[] args) throws IOException {
      
        Scanner file = new Scanner(new File("kavya.dat"));
        while (file.hasNextLine()) {
            String line = file.nextLine().toUpperCase();
              ArrayList<letter> L = new ArrayList();
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) >= 'A' && line.charAt(i) <= 'Z') {
                    checkletter(L, line.charAt(i), i);
                }
            }
            Collections.sort(L);
            for (int i = 0; i < L.size(); i++) {
                for (int j = 0; j < L.get(i).count; j++) {
                    System.out.print(L.get(i).let);
                }
            }
            System.out.println("");
        }
    }

}

class letter implements Comparable<letter> {

    int count;
    int location;
    char let;

    public letter(int loc, char let) {
        count = 1;
        location = loc;
        this.let = let;
    }

    public int compareTo(letter o) {
        if (count == o.count) {
            return location - o.location;
        }
        return o.count - count;
    }
}
