/*Region UIL 2014 Solution - #2 Average
Test data
10
10.12 13.423 12.2134 33.1 44.2
2.2 3.3 4.4
3.547 6.816 8.453 3.218 7.159 9.032 3.118
0.500 0.910 0.737 0.585 0.891 0.660 0.819
0.223 0.996 0.826
0.770 0.241 0.892 0.875 0.768 0.439 0.570 0.717
0.857 0.787 0.138 0.228 0.304 0.893 0.044 0.045 0.702 0.822
0.017 0.077
0.327 0.894 0.559 0.413 0.900
0.381 0.884

Output
26.386
3.420
6.363
0.743
0.758
0.692
0.591
0.056
0.663
0.681

*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Average {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("average.dat"));
		int t = sc.nextInt();
		sc.nextLine();
		while(t-->0){
			double sum = 0;
			String[] arr = sc.nextLine().split("\\s+");
			for(String s : arr)
				sum += Math.pow(Double.parseDouble(s), 2);
			sum /= arr.length;
			System.out.printf("%.3f\n", Math.sqrt(sum));
		}

	}

}
