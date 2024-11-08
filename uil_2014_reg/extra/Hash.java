/*Region UIL 2014 Solution - #6 - Hash
Test data
6
3 3
a
b
c
5 4
afd
ba
ccs
gee
5 4
afd
ba
ccs
dee
4 7
uadcw
lwnh
uvxwo
dij
le
lfhru
r
12 6
rsluiekxu
vxzoho
jdele
icrshgwml
x
afqsji
5 12
yapbl
jxxavmdw
gnole
jciiojy
hzikfj
xqrmrss
ibllauo
rtljeoumi
sezendsnn
nlgt
dpbzcwky
md

Output
0
0
1
3
0
7

*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Hash {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("hash.dat"));
		int t = sc.nextInt();
		while (t-- > 0) {
			int m = sc.nextInt();
			int k = sc.nextInt();
			String[] keys = new String[k];
			boolean[] table = new boolean[m];
			for (int i = 0; i < k; i++) {
				keys[i] = sc.next();
			}
			System.out.println(put(0, keys, table));
		}
	}

	private static int put(int i, String[] keys, boolean[] table) {
		if(i == keys.length)
			return 0;
		int index = hash(table.length, keys[i]);
		if (!table[index]) {
			table[index] = true;
			int ans = put(i + 1, keys, table);
			table[index] = false;
			return ans;
		} else if (!table[(index - 1 + table.length) % table.length]
				&& !table[(index + 1) % table.length]) {

			table[(index - 1 + table.length) % table.length] = true;
			int ans1 = put(i + 1, keys, table);
			table[(index - 1 + table.length) % table.length] = false;

			table[(index + 1) % table.length] = true;
			int ans2 = put(i + 1, keys, table);
			table[(index + 1) % table.length] = false;

			return Math.min(ans1, ans2);
		} else if (!table[(index - 1 + table.length) % table.length]) {
			table[(index - 1 + table.length) % table.length] = true;
			int ans = put(i + 1, keys, table);
			table[(index - 1 + table.length) % table.length] = false;
			return ans;
		} else if (!table[(index + 1) % table.length]) {
			table[(index + 1) % table.length] = true;
			int ans = put(i + 1, keys, table);
			table[(index + 1) % table.length] = false;
			return ans;
		} else {
			return 1 + put(i + 1, keys, table);
		}

	}

	private static int hash(int length, String string) {
		int sum = 0;
		char[] arr = string.toCharArray();
		for (int i = 0; i < arr.length; i++)
			sum += (arr[i] - 'a') << i;
		return sum % length;
	}

}
