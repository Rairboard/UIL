import java.io.*;
import java.util.*;

public class Bipul {
    public static void main(String[] args) {
        for (int i = 0, w = 1; i < 6; i++, w += 2) {
            char[] row = new char[w];
            for (int j = 0; j < w; j++) {
                row[j] = '#';
            }
            row[w - 1] = '\\';
            row[0] = '|';
            System.out.println(new String(row));
        }

        for (int i = 6, w = 4; w <= 11; i++, w++) {
            char[] row = new char[w];
            for (int j = 0; j < w; j++) {
                row[j] = '#';
            }
            row[w - 1] = '\\';
            row[0] = '|';
            System.out.println(new String(row));
        }
    }
}
