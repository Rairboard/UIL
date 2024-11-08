/*
 *UIL Computer Science 2020
 *Invitational B Packet Solution
 */
import static java.lang.System.out;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Irene {

	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("irene.dat"));
		int n = f.nextInt();
		for(int i = 1; i <= n; i++) {
			int value = f.nextInt();
			out.println(value + " " + classification(value));
		}
	}
	
	public static boolean isPrime(int x) {
		for(int d = 2; d <= Math.sqrt(x); d++)
			if(x % d == 0)
				return false;
		return true;
	}
	
	public static String classification(int value) {
		String temp = "";
		if(isPrime(value))
			temp = "NOT SEMIPRIME";
		else
			for(int factor = 2; factor < value; factor++) {
				if(value % factor == 0)
					if(!isPrime(factor)) 
						temp = "NOT SEMIPRIME";
					else
					{
						int other_factor = value / factor;
						if(!isPrime(other_factor))
							temp = "NOT SEMIPRIME";						
						else if(factor == other_factor)
							temp = "SEMIPRIME";
						else
							temp = "DISCRETE SEMIPRIME";							
					}				
			}
		
		return temp;
	}

}
