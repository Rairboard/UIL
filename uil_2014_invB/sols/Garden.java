import java.io.*;
import java.util.*;

public class Garden {
  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(new File("garden.dat"));
    int numcases = Integer.parseInt(in.nextLine().trim());
    while (numcases-- > 0) {
      // read in garden
      StringTokenizer st = new StringTokenizer(in.nextLine().trim());
      int W = Integer.parseInt(st.nextToken());
      int H = Integer.parseInt(st.nextToken());
      int DW = Integer.parseInt(st.nextToken());
      int DH = Integer.parseInt(st.nextToken());
      char[][] board = new char[H][W];
      for (int i = 0; i < H; i++) {
        board[i] = in.nextLine().trim().toCharArray();
      }
      // solve
      int maxSeeds = Integer.MIN_VALUE;
      for (int i = 0; i <= H - DH; i++) {
        for (int j = 0; j <= W - DW; j++) {
          int seedsInRect = 0;
          for (int ii = 0; ii < DH; ii++) {
            for (int jj = 0; jj < DW; jj++) {
              if (board[i+ii][j+jj] == 'S') {
                seedsInRect++;
              }
            }
          }
          maxSeeds = Math.max(maxSeeds, seedsInRect);
        }
      }
      System.out.println(maxSeeds);
    }
  }
}