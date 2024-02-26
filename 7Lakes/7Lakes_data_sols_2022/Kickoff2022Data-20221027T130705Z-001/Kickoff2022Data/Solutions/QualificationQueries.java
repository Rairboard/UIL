import java.util.Scanner;
import java.util.Stack;

public class QualificationQueries
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        
        for (int i = 0; i < N; i++) {
            int R = in.nextInt(), C = in.nextInt(), S = in.nextInt();
            in.nextLine();
            
            int[][] mat = new int[R][C];
            
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    mat[r][c] = in.nextInt() >= S ? 1 : 0;
                }
                in.nextLine();
            }
            
            System.out.println(maxRectangle(R, C, mat));
        }
    }
    
    public static int maxRectangle(int R, int C, int[][] mat) {
        int ret = maxHist(R, C,  mat[0]);
 
        for (int i = 1; i < R; i++) {
            for (int j = 0; j < C; j++) {
                 if (mat[i][j] == 1) {
                     mat[i][j] += mat[i - 1][j];
                 }
            }    
            ret = Math.max(ret, maxHist(R, C, mat[i]));
        }
 
        return ret;
    }
    
    static int maxHist(int R, int C, int row[])
    {
        Stack<Integer> stack = new Stack<Integer>();
 
        int top;
        int maxArea = 0; 
        int area = 0;

        int i = 0;
        while (i < C) {
            if (stack.empty() || row[stack.peek()] <= row[i]) {
                stack.push(i++);
            } else {
                top = row[stack.peek()];
                stack.pop();
                area = top * i;
 
                if (!stack.empty()) {
                    area = top * (i - stack.peek() - 1);
                }
                maxArea = Math.max(area, maxArea);
            }
        }
 
        while (!stack.empty()) {
            top = row[stack.peek()];
            stack.pop();
            area = top * i;
            if (!stack.empty())
                area = top * (i - stack.peek() - 1);
 
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

}
