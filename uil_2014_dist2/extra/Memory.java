import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Memory {

	public static void main(String[] args) throws FileNotFoundException {
		// setup
		Scanner sc = new Scanner(new File("memory.dat"));
		int n = sc.nextInt();
		while (n-- > 0) {
			// maps between values
			Map<String, Integer> variableToValue = new HashMap<>();
			Map<String, Integer> variableToAddress = new HashMap<>();
			Map<Integer, Integer> addressToValue = new HashMap<>();
			int m = sc.nextInt();
			int k = sc.nextInt();
			// read in variables
			while(m-- > 0){
				String var = sc.next();
				int address = sc.nextInt();
				int val = sc.nextInt();
				variableToValue.put(var, val);
				variableToAddress.put(var, address);
				addressToValue.put(address, val);
			}
			
			while(k-- > 0){
				String formula = sc.next();
				switch(formula.charAt(0)){
				case '*':
					// get value of variable then get value at that address location
					System.out.println(addressToValue.get(variableToValue.get(formula.substring(1))));
					break;
				case '&':
					// get address of variable
					System.out.println(variableToAddress.get(formula.substring(1)));
					break;
				default:
					// get value of variable
					System.out.println(variableToValue.get(formula));
				}
			}
		}
	}

}
