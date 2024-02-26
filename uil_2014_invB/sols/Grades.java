import java.io.*;
import java.util.*;

public class Grades {
  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(new File("grades.dat"));
    int numcases = Integer.parseInt(in.nextLine().trim());
    while (numcases-- > 0) {
      StringTokenizer st = new StringTokenizer(in.nextLine().trim());
      int numpapers = Integer.parseInt(st.nextToken());
      String name = st.nextToken();
      char[] labels = new char[]{'A', 'B', 'C', 'D', 'F'};
      int[] totals = new int[5];// 0 is A, 1 is B, 2 is C, 3 is D, 4 is F
      while (numpapers-- > 0) {
        st = new StringTokenizer(in.nextLine().trim());
        // discard name
        st.nextToken();
        totals[getIndex(Integer.parseInt(st.nextToken()))]++;
      }
      System.out.println(name);
      for (int i = 0; i < 5; i++) {
        System.out.println(labels[i] + " " + totals[i]);
      }
    }
  }
  static int getIndex(int grade) {
    if (grade >= 90) return 0;
    else if (grade >= 80) return 1;
    else if (grade >= 75) return 2;
    else if (grade >= 70) return 3;
    else return 4;
  }
}
