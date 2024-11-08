//Solution - UIL Region 2019
import static java.lang.System.out;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class Belle {

	public static void main(String[] args) throws IOException{
		Scanner f=new Scanner(new File("belle.dat"));
		int n=Integer.parseInt(f.nextLine());
		for(int x=1;x<=n;x++) {
			int a=f.nextInt();
			int b=f.nextInt();
			out.println(Math.max(a, b));
		}
	}
}
