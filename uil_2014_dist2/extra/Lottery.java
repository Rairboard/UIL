import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lottery {

	public static void main (String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("lottery.dat"));
		int t = in.nextInt();
		while (t-- > 0) {
			System.out.println("$" + 10*digitMatch(in.nextInt(), in.nextInt()));
		}
		in.close();
	}
	public static int digitMatch (int a, int b) {
	    if (( a < 0) || (b < 0)) throw new IllegalArgumentException();
	    
	    if (a<10) return (a == b%10) ? 1: 0;
	    if (b<10) return (b == a%10) ? 1:0;
	    int matched = ((a%10 == b%10) ? 1:0);
	    return matched + digitMatch(a/10, b/10);
	}
}
