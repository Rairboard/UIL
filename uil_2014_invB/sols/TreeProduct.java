import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TreeProduct {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new FileReader("treeproduct.dat"));
		int t = Integer.parseInt(br.readLine().trim());
		while (t-- > 0) {
			br.readLine();
			String[] arr = br.readLine().trim().split("\\s+");
			System.out.println(calculate(arr, 0));
		}
	}

	private static long calculate(String[] arr, int index) {
		long value = Integer.parseInt(arr[index]);
		if (index * 2 + 1 >= arr.length)
			return value;
		else
			return  Math.max(value*calculate(arr, index * 2 + 1),
							value*calculate(arr, index * 2 + 2));
	}

}
