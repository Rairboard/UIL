import java.io.*;
import java.util.*;

public class Rebecca {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("rebecca.dat"));

        int T = scan.nextInt();
        assert 1 <= T && T <= 50;

        int totalCells = 0;
        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int r = scan.nextInt();
            int c = scan.nextInt();

            totalCells += r * c;

            int[][] a = new int[r][c];
            int[][] sameUp = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    a[i][j] = scan.nextInt();
                    assert 1 <= a[i][j];

                    sameUp[i][j] = 1;
                    if (i > 0 && a[i][j] == a[i - 1][j]) {
                        sameUp[i][j] += sameUp[i - 1][j];
                    }
                }
            }

            long ans = 0;
            for (int i = 0; i < r; i++) {
                List<Block> stack = new ArrayList<>();
                int stackSum = 0;
                for (int j = 0; j < c; j++) {
                    if (j > 0 && a[i][j] != a[i][j - 1]) {
                        stack.clear();
                        stackSum = 0;
                    }

                    int numCols = 1;
                    while (!stack.isEmpty() && stack.get(stack.size() - 1).height >= sameUp[i][j]) {
                        Block block = stack.remove(stack.size() - 1);
                        numCols += block.numCols;
                        stackSum -= block.sum();
                    }

                    Block here = new Block(numCols, sameUp[i][j]);
                    stack.add(here);
                    stackSum += here.sum();

                    ans += stackSum;
                }
            }

            System.out.printf("Case #%d: %d%n", caseNum, ans);
        }

        assert totalCells <= 5_000_000;
    }

    static class Block {
        public Block(int numCols, int height) {
            this.numCols = numCols;
            this.height = height;
        }

        public int sum() {
            return numCols * height;
        }

        public int numCols;
        public int height;
    }
}
