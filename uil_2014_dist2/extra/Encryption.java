import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Encryption {

	/**
	 * The idea is to find factors of the numbers.  These factors will be multiplied together to find a multiple.
	 * Any overlap in factors will lead to the factor only being multiplied once, causing it to be 'least' 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("encryption.dat"));
		int t = sc.nextInt();
		sc.nextLine();
		long lcm=1;
		while(t-- > 0){
			// obtain numbers and parse into integer array
			String[] temp = sc.nextLine().split("\\s+");
			int[] arr = new int[temp.length];
			for(int i = 0; i <arr.length; i++)
				arr[i] = Integer.parseInt(temp[i]);
			int i = 2;
			boolean change;
			lcm = 1;
			while(notOne(arr)){
				change = false;
				for(int j = 0; j < arr.length; j++){
					// for any element divisible by i
					if(arr[j]%i == 0){
						arr[j] = arr[j]/i;
						change = true;
					}
				}
				// a change occurred, implies this factor will appear in lcm 
				if(change)
					lcm *= i;
				else
					i++;
			}
			System.out.println(lcm);
		}
	}

	// returns false only when all numbers in array are one
	private static boolean notOne(int[] arr) {
		boolean ones = true;
		for(int i = 0; i <arr.length; i++)
			ones &= (arr[i]==1);
		return !ones;
	}

}
