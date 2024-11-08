import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Optimize {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		int max = 100;
		Scanner sc = new Scanner(new File("optimize.dat"));
		int t = sc.nextInt();
		sc.nextLine();
		while(t-- > 0){
			String[] values = sc.nextLine().trim().split("\\s+");
			int len = sc.nextInt();
			int[] best = new int[len+1];
			sc.nextLine();
			System.out.println(calc(values, len, best));
		}
	}

	private static int calc(String[] values, int len, int[] best) {
		int max = 0;
		if(best[len] != 0)
			return best[len];
		for(int i = 0; i < values.length; i++){
			if(len -1 - i < 0)
				break;
			max = Math.max(max, calc(values, len - 1 - i, best) + Integer.parseInt(values[i]));
		}
		best[len] = max;
		return max;
	}

}
