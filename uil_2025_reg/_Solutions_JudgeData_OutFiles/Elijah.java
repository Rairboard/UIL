import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Elijah {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner kb = new Scanner(new File("elijah.dat"));

        int times = Integer.parseInt(kb.nextLine().trim());

        while(times-->0) {
            int R = Integer.parseInt(kb.next().trim());
            int C = Integer.parseInt(kb.nextLine().trim());

            char [][] mat = new char[R][C];

            for(int x = 0; x < R; x++) {
                mat[x] = kb.nextLine().trim().toCharArray();
            }

            int rotations = Integer.parseInt(kb.nextLine().trim()) % 360 / 90;

            for(int x = 0; x < rotations; x++) {
                mat = rotate(mat.length, mat[0].length, mat);
            }

            for(int x = 0; x < mat.length; x++) {
                System.out.println(mat[x]);
            }
            System.out.println();
        }
    }

    public static char [][] rotate(int R, int C, char [][] mat) {
        char [][] rotated = new char[C][R];

        for(int x = 0; x < R; x++) {
            for(int y = 0; y < C; y++) {
                rotated[y][x] = mat[x][y];
            }
        }

        char [][] reverseCols = new char[C][R];

        for(int x = 0; x < C; x++) {
            for(int y = 0; y < R; y++) {
                reverseCols[x][R - y - 1] = rotated[x][y];
            }
        }
        return reverseCols;
    }
}
