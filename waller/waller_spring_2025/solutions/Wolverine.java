import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Wolverine {
	public static void main(String[]args)throws Exception{
		new Wolverine().run();
	}
	public void run()throws Exception{
		Scanner file = new Scanner(new File("wolverine.dat"));
		int times = file.nextInt();
		file.nextLine();
		while(times-- > 0) {
			String[] st = file.nextLine().trim().split("/");
			int year = Integer.parseInt(st[2]);
			int month = Integer.parseInt(st[0]) - 1;
			int day = Integer.parseInt(st[1]);
			GregorianCalendar gc = new GregorianCalendar(year,month,day);
			char field = file.next().charAt(0);
			int amount = file.nextInt();
			//System.out.println(amount);
			file.nextLine();
			switch(field) {
			case 'D':
				gc.add(GregorianCalendar.DATE,amount);break;
			case 'M':
				gc.add(GregorianCalendar.MONTH,amount);break;
			case 'Y':
				gc.add(GregorianCalendar.YEAR,amount);break;
			}
			Date d = gc.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, YYYY");
			out.println(sdf.format(d));
		}
	}
}
