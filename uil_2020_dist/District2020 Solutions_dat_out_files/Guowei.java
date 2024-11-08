/*
 *UIL Computer Science 2020
 *District Packet Solution
 */
import java.util.*;
import java.io.*;
import static java.lang.System.out;

public class Guowei {

	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("guowei.dat"));
		int n = f.nextInt();
		for(int x = 1; x<=n;x++) {
			int shift = f.nextInt();f.nextLine();
			ArrayList<Character> ticker = new ArrayList<>();
			String crawl = f.nextLine();
			crawl = crawl.trim();
			for(int i=0;i<crawl.length();i++)
				ticker.add(crawl.charAt(i));
			ticker.add(' ');
			for(int i=0;i<shift;i++) 
				ticker.add(ticker.remove(0));
			for(int i=0;i<40;i++)
				out.print(ticker.get(i));
			out.println();				
			}
		f.close();
		}

	}


