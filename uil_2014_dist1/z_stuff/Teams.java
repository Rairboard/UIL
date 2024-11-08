//Teams - Solution
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class Teams {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("teams.dat"));
		Map<Integer, Integer> contestants = new TreeMap<>();
		int age, rate, i, size, diff;
		for(int n = sc.nextInt(); n-- > 0;){
			age = sc.nextInt();
			rate = sc.nextInt();
			contestants.put(age, rate);
			size = contestants.size();
			Iterator<Integer> it = contestants.values().iterator();
			for(i=0, diff = 0; i < size/2+size%2; i++)
				diff += it.next();
			while(i++ < size)
				diff -= it.next();
			System.out.println(Math.abs(diff));
		}
	}
}
/*
Test data:
20
11 98
16 149
31 116
12 40
53 14
23 187
14 163
27 21
26 31
19 42
18 56
21 1
20 171
22 85
15 171
17 192
25 49
24 84
29 191
28 34

Output:
98
51
131
127
157
30
133
112
455
123
179
178
349
264
435
285
578
494
305
271

*/