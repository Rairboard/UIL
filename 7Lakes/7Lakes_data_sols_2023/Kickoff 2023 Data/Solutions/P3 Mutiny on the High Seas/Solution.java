import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> one = new PriorityQueue<>();
        PriorityQueue<Integer> two = new PriorityQueue<>();
        int[] arr = new int[n];
        st = new StringTokenizer(f.readLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(f.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x == 1) one.add(arr[i]);
            else two.add(arr[i]);
            sum += x;
        }
        int tot = 0;
        int ans = 0;
        while (tot < m && (!one.isEmpty() || !two.isEmpty())) {
            if (one.isEmpty() && !two.isEmpty()) {
                if (tot + two.peek() <= m) {
                    ans += 2;
                    tot += two.poll();
                }
                else break;
            }
            else if (one.size() >= 2 && two.size() >= 1) {
                int v1 = two.peek();
                int temp = one.poll();
                int v2 = one.peek() + temp;
                one.add(temp);
                if (tot + Math.min(v1, v2) <= m) {
                    if (v1 < v2) {
                        two.poll();
                    } else {
                        one.poll();
                        one.poll();
                    }
                    tot += Math.min(v1, v2);
                    ans += 2;
                }
                else {
                    if (tot + one.peek() <= m) {
                        ans++;
                        tot += one.poll();
                    }
                    else {
                        break;
                    }
                }
            }
            else {
                if (tot + one.peek() <= m) {
                    ans++;
                    tot += one.poll();
                }
                else {
                    break;
                }
            }
        }
        out.println(ans);
        out.close();
        f.close();
    }

}