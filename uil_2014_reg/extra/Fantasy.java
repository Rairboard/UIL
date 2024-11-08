/*Region UIL 2014 Solution - #5 - Fantasy
Test data
4
Lebron Durant 1
15 22 2 5 1 33 7 3 4 0 8
10 22 7 10 1 28 8 3 2 0 5
Lebron Durant 1
12 20 9 9 1 34 3 3 0 0 3
12 23 5 5 4 33 7 5 2 0 3
Josh Elynn 5
36 63 26 29 13 110 38 11 3 0 8
27 47 13 17 9 76 7 7 0 0 4
43 91 14 19 0 100 39 10 1 3 9
27 49 11 14 0 65 29 6 5 1 11
17 33 2 3 11 47 18 14 4 1 9
24 44 19 22 7 74 23 4 6 4 6
26 44 20 27 1 73 28 10 8 4 8
26 62 16 19 2 70 26 9 4 4 8
20 42 6 7 9 55 8 22 5 0 4
21 50 4 5 6 52 19 14 5 1 7
Paolo John 7
29 58 23 25 12 93 18 8 7 2 9
29 65 9 13 7 74 15 40 6 2 11
14 27 3 3 1 32 22 15 7 1 0
21 55 22 23 4 68 25 8 5 0 4
23 39 10 21 0 56 43 6 2 9 10
9 26 5 6 2 25 28 10 0 6 5
10 23 2 4 5 27 8 31 5 1 11
10 35 25 28 2 47 17 35 6 0 4
20 40 2 2 5 47 9 3 5 0 2
12 27 4 5 5 33 18 12 2 6 8
22 54 6 7 11 61 8 3 2 0 3
33 72 7 13 2 75 28 12 2 6 11
31 69 22 24 0 84 16 13 0 2 11
15 41 16 19 1 47 12 14 3 1 7

Output
Tie.
Durant wins!
Elynn wins!
Paolo wins!

*/
import java.io.*;
import java.util.*;

public class Fantasy {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("fantasy.dat"));
		int T = Integer.parseInt(in.nextLine().trim());
		while (T-- > 0) {
			String[] line = in.nextLine().trim().split("\\s+");
			String nameA = line[0];
			String nameB = line[1];
			int numPlayers = Integer.parseInt(line[2]);
			int[] totalsA = new int[11];
			int[] totalsB = new int[11];
			for (int i = 0; i < numPlayers; i++) {
				line = in.nextLine().trim().split("\\s+");
				for (int j = 0; j < 11; j++) {
					totalsA[j] += Integer.parseInt(line[j]);
				}
			}
			for (int i = 0; i < numPlayers; i++) {
				line = in.nextLine().trim().split("\\s+");
				for (int j = 0; j < 11; j++) {
					totalsB[j] += Integer.parseInt(line[j]);
				}
			}
			int scoreA = 0;
			int scoreB = 0;
			double FGMA = (totalsA[1] == 0) ? 0 : 1.0*totalsA[0] / totalsA[1];
			double FGMB = (totalsB[1] == 0) ? 0 : 1.0*totalsB[0] / totalsB[1];
			if (FGMA > FGMB) scoreA++;
			else if (FGMB > FGMA) scoreB++;
			double FTMA = (totalsA[3] == 0) ? 0 : 1.0*totalsA[2] / totalsA[3];
			double FTMB = (totalsB[3] == 0) ? 0 : 1.0*totalsB[2] / totalsB[3];
			if (FTMA > FTMB) scoreA++;
			else if (FTMB > FTMA) scoreB++;
			for (int i = 4; i < 10; i++) {
				if (totalsA[i] > totalsB[i]) scoreA++;
				else if (totalsB[i] > totalsA[i]) scoreB++;
			}
			if (totalsA[10] < totalsB[10]) scoreA++;
			else if (totalsB[10] < totalsA[10]) scoreB++;

			// determine winner
			if (scoreA > scoreB) {
				System.out.println(nameA + " wins!");
			} else if (scoreB > scoreA) {
				System.out.println(nameB + " wins!");
			} else {
				System.out.println("Tie.");
			}
		}
	}
}