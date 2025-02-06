/*
 * UIL Computer Science 2025
 * Invitational A Packet Solution
 */

import java.util.*;
import java.io.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class Dominik {
	public static void main(String[]args)throws Exception{
		new Dominik().run();
	}
	
	public void run()throws Exception{
		Scanner file = new Scanner(new File("dominik.dat"));
		int dates = file.nextInt(), times = file.nextInt();
		file.nextLine();
		TreeMap<String, LocalDate> tm = new TreeMap<String, LocalDate>();
		while(dates-- > 0) {
			String[] d = file.next().split("/");
			String name = file.nextLine().trim();
			int year = Integer.parseInt(d[0]);
			int month = Integer.parseInt(d[1]);
			int day = Integer.parseInt(d[2]);
			tm.put(name, LocalDate.of(year, month, day));
		}
		while(times-- > 0) {
			String[] ne = file.nextLine().trim().split(":");
			LocalDate date1 = tm.get(ne[0]);
			LocalDate date2 = tm.get(ne[1]);
			long daysBetween = ChronoUnit.DAYS.between(date2, date1);
			System.out.printf("%,d%n",Math.abs(daysBetween));
		}
		file.close();
	}
}
