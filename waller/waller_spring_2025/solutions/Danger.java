import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
public class Danger {
	public static void main(String[]args)throws Exception{
		new Danger().run();
	}
	public void run()throws Exception{
		Scanner file = new Scanner(new File("danger.dat"));
		int times = file.nextInt();
		file.nextLine();
		TreeMap<Integer,String> tm = new TreeMap<Integer,String>();
		while(times-- > 0) {
			String s = file.nextLine();
			String time = s.split(" ")[0];
			tm.put(ttn(time),s);
		}
		for(String s:tm.values())
			System.out.println(s);
	}
	public int ttn(String time) {
		String[] s = time.split(":");
		int hrs = Integer.parseInt(s[0]) * 60;
		int min = Integer.parseInt(s[1]);
		return hrs + min;
	}
}
