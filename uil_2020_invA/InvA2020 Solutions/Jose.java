/*
 *UIL Computer Science 2020
 *Invitational A Packet Solution
 */
import static java.lang.System.out;
import java.util.*;
import java.io.*;
public class Jose {

	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("jose.dat"));
		Map<Character,Integer> values = new HashMap<Character,Integer>();
		Map<Integer,Integer> weights = new HashMap<Integer,Integer>();
		for(int x=1;x<=23;x++) 
			values.put(f.next().charAt(0), f.nextInt());
		for(int x=1;x<=17;x++) 
			weights.put(f.nextInt(), f.nextInt());
		int n = f.nextInt();
		for(int x=1;x<=n;x++) {
			char[] vin = f.next().toCharArray();
			int sum = 0;
			for(int p=0;p<vin.length;p++) {
				int v=0;
				if(vin[p]!='_') {
					if(vin[p]<65)
						v=vin[p]-48;
					else
						v=values.get(vin[p]);
					sum+=weights.get(p+1)*v;
				}
			}
			int rem=sum%11;
			char checkDigit;
			if(rem==10)
				checkDigit='X';
			else
				checkDigit=(char)(rem+48);
			vin[8]=checkDigit;
			String newVIN = "";
			for(char c:vin)
				newVIN+=c;
			out.println(newVIN);
		}

	}

}
