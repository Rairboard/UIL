import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class VC1 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("vc1.dat"));
		int T = in.nextInt();
		while (T-- > 0) {
			int P = in.nextInt();
			int[] A = new int[P];
			int[] B = new int[P];
			for (int i = 0; i < P; i++) {
				A[i] = in.nextInt();
			}
			for (int i = 0; i < P; i++) {
				B[i] = in.nextInt();
			}
			if (happensBefore(A, B)) {
				System.out.println("A -> B");
			} else if (happensBefore(B, A)) {
				System.out.println("B -> A");
			} else {
				System.out.println("A || B");
			}
		}
	}
	public static boolean happensBefore(int[] a, int[] b){
		for (int i = 0; i < a.length; i++) {
			if (a[i] > b[i]) return false;
		}
		return true;
	}
}