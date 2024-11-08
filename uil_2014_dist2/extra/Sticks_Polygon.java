import java.io.*;
import java.util.*;

public class Sticks_Polygon{

	public static void main(String[] args) throws FileNotFoundException {
		// read in number of test cases
		Scanner sc = new Scanner(new File("stickspolygon.dat"));

		int t = sc.nextInt();

		while(t-- > 0){
			// read in two values then run through simulation
			int n = sc.nextInt();
			int[] a = new int[n];

			for(int i=0;i<n;i++)
                    a[i] = sc.nextInt();

			System.out.println(calculate(n, a));
		}
	}

	private static int calculate(int n, int[] a) {

                Arrays.sort(a);

                int ans = -1, sum = 0;

                for(int i=0;i<n;i++)
                {
                        if(sum  > a[i])
                            ans = i + 1;

                        sum += a[i];

                }

                return ans;
	}

}
