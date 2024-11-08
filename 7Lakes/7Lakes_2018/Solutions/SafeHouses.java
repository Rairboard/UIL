import java.util.*;
import java.io.*;
public class SafeHouses {
	public static void main(String[] args)throws IOException {
		Scanner in = new Scanner(new File("safehouses.in"));
		int cases = in.nextInt();
		in.nextLine();
		for(int c = 0; c < cases; c++) {	
			String output = in.nextLine();
			String[] arr = output.split(" ");	
				if(Integer.parseInt(arr[0]) % 7 == 0)
				{
					System.out.println(output);
				}
				else
					System.out.println("DANGER!");
			}
		}
}