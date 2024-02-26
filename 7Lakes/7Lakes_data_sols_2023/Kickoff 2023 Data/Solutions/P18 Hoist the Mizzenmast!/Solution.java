import java.util.*;
import java.io.*;

public class Solution {
    static final int MOD = (int) 1e9+7;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;    
        
        int t = Integer.parseInt(br.readLine());
        while (t --> 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            String s = br.readLine();
            
            int num0s = 0;
            for (int i = 0; i < n; i++) 
                if (s.charAt(i) == '0') num0s++;
            int num1s = n - num0s;
            int mod = Math.abs(num0s - num1s);
            
            TreeMap<Integer, Integer> freq = new TreeMap<> ();
            int prefix = 0;
            for (int i = 0; i < n; i++) {
                prefix += (s.charAt(i) == '0' ? -1 : 1);
                freq.put(prefix, freq.getOrDefault(prefix, 0) + 1);
            }
            
            if (mod == 0) {
                long res = 0;
                for (int key: freq.keySet()) {
                    long val = freq.get(key);
                    val *= k; val %= MOD;
                    if (key == 0) val ++;
                    res += (val) * (val - 1) / 2 % MOD; res %= MOD;
                } System.out.println(res);
                continue;
            }
            
            long res = 0;
            int first = freq.firstKey(), last = freq.lastKey();
            if (num1s > num0s) for (int i = 0; i >= (long) -(k - 1) * mod && i >= first; i -= mod) res += freq.getOrDefault(i, 0);
            else for (int i = 0; i <= (long) (k - 1) * mod && i <= last; i += mod) res += freq.getOrDefault(i, 0);
            for (int i = -n; i < -n + mod; i++) {
                ArrayList<Integer> list = new ArrayList<> ();
                for (int j = i; j <= n; j += mod) list.add(freq.getOrDefault(j, 0));
                for (int j: list) { res += ((long) j * (j - 1) / 2) % MOD * k % MOD; res %= MOD; }
                
                int [] prefix1 = new int[list.size()];
                for (int j = prefix1.length - 2; j >= 0; j--) 
                    prefix1[j] = prefix1[j + 1] + list.get(j + 1);

                long sum = 0;
                for (int j = 1; j < list.size(); j++) { sum += (long) list.get(j) * j % MOD; sum %= MOD; }
                for (int j = 0; j < list.size(); j++) {
                    sum -= prefix1[j]; sum %= MOD;
                    res += (long) list.get(j) * prefix1[j] % MOD * (k - 1) % MOD; res %= MOD;
                    res -= (long) list.get(j) * sum % MOD; res %= MOD;
                }
            }
            System.out.println(res);
        }
        
        br.close();
    }
}