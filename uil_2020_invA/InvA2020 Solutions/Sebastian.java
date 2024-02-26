/*
 *UIL Computer Science 2020
 *Invitational A Packet Solution
 */
import java.util.*;
import java.io.*;
import static java.lang.System.out;
public class Sebastian {

	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("sebastian.dat"));
		Set<ASCIIword> list = new TreeSet<ASCIIword>();
		while(f.hasNext()) 
			list.add(new ASCIIword(f.next()));
		for(ASCIIword a:list)
			out.println(a);
		f.close();
	}
	
	public static class ASCIIword implements Comparable<ASCIIword>{
		public String s;
		public int total;
		public ASCIIword(String s) {
			this.s=s;
			total = findTotal(s);
			//System.out.println(s+" "+total);
		}
		
		public int findTotal(String s) {
			int sum = 0;
			for(char c:s.toCharArray())
				sum+=c;
			return sum;
		}

		public int compareTo(ASCIIword o) {
			if(total==o.total)
				return s.compareTo(o.s);
			return total-o.total;
		}
		
		public String toString() {
			return s;
		}
	}
}


