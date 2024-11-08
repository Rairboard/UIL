import java.io.*;
import java.util.*;

public class Switch {
  static BitSet[] switches;
  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(new File("switch.dat"));
    int numcases = Integer.parseInt(in.nextLine().trim());
    while (numcases-- > 0) {
      StringTokenizer st = new StringTokenizer(in.nextLine().trim());
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      switches = new BitSet[k];
      for (int q = 0; q < k; q++) {
        String line = in.nextLine().trim();
        BitSet bs = new BitSet(n);
        for (int i = 0; i < line.length(); i++)
          if (line.charAt(i) == 'Y')
            bs.set(i);
        switches[q] = bs;
      }
      int num = minSwitches(new BitSet(n), new BitSet(k), -1, 0, n);
      if (num <= 10)
        System.out.println(num);
      else
        System.out.println("TOO HARD!");
    }
  }
// This algorithm uses DFS without pruning, so it is definitely not the fastest solution,
// but it is the simplest, easiest to code up, and still easily fast enough.
  static int minSwitches(BitSet curlights, BitSet curswitches, int lastswitch, int depth, int n) {
    if (depth > 10 || curlights.cardinality() == n) return depth;
    int ret = Integer.MAX_VALUE;
    for (int i = lastswitch + 1; i < switches.length; i++) {
      curswitches.set(i);
      curlights.xor(switches[i]);
      ret = Math.min(ret, minSwitches(curlights, curswitches, i, depth +  1, n));     
      curlights.xor(switches[i]);
      curswitches.clear(i);
    }
    return ret;
  }

}
