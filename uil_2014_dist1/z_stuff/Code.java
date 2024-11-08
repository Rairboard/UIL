import java.io.*;
import java.util.*;

// Builds a mapping for the encoding of a string. Since decoding is the reverse process,
// it reverses that mapping to make a decoding mapping. Then it uses whichever mapping is specified
// for each input and applies it to the string. 
public class Code {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("code.dat"));
		int numcases = Integer.parseInt(in.nextLine().trim());
		for (int q = 1; q <= numcases; q++) {
			System.out.println("Protocol " + q);
			StringTokenizer st = new StringTokenizer(in.nextLine().trim());
			String shuf = st.nextToken();
			int offset = Integer.parseInt(st.nextToken());
			if (offset < 0) {
				offset += 26;
			}
			char[] encMapping = new char[26];
			char[] decMapping = new char[26];
			for (int i = 0; i < 26; i++) {
				encMapping[i] = (char)('a' + (shuf.charAt(i) - 'a' + offset) % 26);
			}
			for (int i = 0; i < 26; i++) {
				decMapping[(int)(encMapping[i] - 'a')] = (char)('a' + i);
			}
			int M = Integer.parseInt(in.nextLine().trim());
			String line;
			while (M-- > 0) {
				line = in.nextLine().trim();
				if (line.charAt(0) == 'E') {
					System.out.println(code(line.substring(2), encMapping));
				} else {
					System.out.println(code(line.substring(2), decMapping));
				}
			}
			System.out.println();
		}
	}

	static String code(String in, char[] map) {
		StringBuilder sb = new StringBuilder();
		for (char c : in.toCharArray()) {
			if ('a' <= c && 'z' >= c)
				sb.append(map[(int)(c - 'a')]);
			else
				sb.append(c);
		}
		return sb.toString();
	}
}
/*
Test data:
5
zikhmpxjfsvqdaolywtecrbugn 1
2
E UIL Computer Science rocks
D dgr 2014 xplwu
xyikbnmpvaqouctdjszerwlhfg -2
3
E sup bro!
E abcdefg
D 3947
mlnpvjbexoqhzkdgawusrcitfy -18
5
D jeufs
E aft
D efvd
E boat
E cheer
gcnjwsxvlheyztpqfkiumbdaro 23
4
D rhdiq
D amhg
E feelings
D qmhrs nmvt
jgbucsihrmpaqefoyvdlkntzxw -21
10
D tfowj
E animal
E operand
E setting
D nhjqwf
E draper
D lhnwfz
E reaggravation
E anteorbital
D fhotwjn

Output:
Protocol 1
UIL Cpemdfnx Slgnbln xplwu
uil 2014 rocks

Protocol 2
xpb wqr!
vwgizlk
3947

Protocol 3
grain
ura
rice
tlua
vmdde

Protocol 4
train
word
pttviquf
north pole

Protocol 5
plain
ojwvof
kthaojz
ihqqwjn
gentil
zaotha
begild
ahonnaosoqwkj
ojqhkalwqof
leaping

*/