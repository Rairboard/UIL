import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
public class Colossus {
	public static void main(String[]args)throws Exception{
		new Colossus().run();
	}
	public void run()throws Exception{
		Scanner file = new Scanner(new File("colossus.dat"));
		int times = file.nextInt();
		file.nextLine();
		while(times-- > 0) {
			long amt = file.nextLong();
			System.out.println(amt > 10000? "Lunk Alarm!!": "Hulk here we come.");
		}
	}
}
