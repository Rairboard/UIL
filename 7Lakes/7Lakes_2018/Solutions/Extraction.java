import java.util.*;
import java.io.*;

public class Extraction
{
  static char[][] mat;
  static int[][] mDis;

  public static void main(String[] args) throws Exception
  {
    Scanner in = new Scanner(new File("extraction.in"));
    int cases = in.nextInt();
    
    for(int c = 0; c < cases; c++)
    {
      int rows = in.nextInt();
      int cols = in.nextInt();
      int limit = in.nextInt();
      in.nextLine();

      mDis = new int[rows][cols];
      mat = new char[rows][cols];

      int[] checkPointRow = new int[4];
      int[] checkPointCol = new int[4];

      for(int i = 0; i < rows; i++)
      {
        String line = in.nextLine();
        Arrays.fill(mDis[i],10000);
        for(int j = 0; j < cols; j++)
        {
          mat[i][j] = line.charAt(j);
          if(mat[i][j] == 'S')
          {
            checkPointRow[0] = i;
            checkPointCol[0] = j;
          }
          else if(mat[i][j] == 'C')
          {
            checkPointRow[1] = i;
            checkPointCol[1] = j;
          }
          else if(mat[i][j] == 'M')
          {
            checkPointRow[2] = i;
            checkPointCol[2] = j;
          }
          else if(mat[i][j] == 'J')
          {
            checkPointRow[3] = i;
            checkPointCol[3] = j;
          }

        }
      }

      int total = 0;
      for(int i = 0; i < 3; i++)
      {
        fill(checkPointRow[i],checkPointCol[i], 0);
        total += mDis[checkPointRow[i + 1]][checkPointCol[i + 1]];
        for(int[] arr : mDis)
        {
          Arrays.fill(arr,10000);
        }
      }

      System.out.println(total < limit?"Mission Success! 212!":"DANGER!");
    }
    in.close();
  }
  public static void fill(int row, int col, int dis)
  {
    if(row < 0 || col < 0 || row >= mat.length || col>= mat[0].length || mDis[row][col] < dis || mat[row][col] == '#')
    {
      return;
    }
    mDis[row][col] = dis;

    fill(row + 1,col,dis + 1);
    fill(row - 1,col,dis + 1);
    fill(row,col + 1,dis + 1);
    fill(row,col - 1,dis + 1);

  }
}