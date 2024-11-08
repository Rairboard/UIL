import java.util.*;
import java.io.*;

public class Trust {
  public static void main(String[] args) throws IOException{
			Scanner sc= new Scanner(new File("trust.in"));
		
			//System.out.println(sc.next());
			int cases = sc.nextInt();
			sc.nextLine();
			for(int i = 0; i < cases; i++) {
				String line = sc.nextLine();
        System.out.println(line.replaceAll(" ", "").toLowerCase().contains("forest")? "TWO-TWELVE!" : "Glory to Stroudonia...");
			}
		}
}