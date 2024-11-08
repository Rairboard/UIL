/*
 *UIL Computer Science 2020
 *Region Packet Solution
 */
import java.io.*;
import java.util.*;
import static java.lang.System.out;

public class Kevin {

	private static final int daysinmonth[] = {0,31,29,31,30,31,30,31,31,30,31,30,31};

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("kevin.dat"));
		int distsum = 0, distmax = 0, timesum = 0, timemax = 0, days = 0;
		int pacemin = 10000, pacemax = 0;
		int distshort = 0, distmed = 0, distlong = 0;
		int timeshort = 0, timemed = 0, timelong = 0;
		int shortcount = 0, medcount = 0, longcount = 0;
		int streakdist_curr = 0, streakdist_max = 0;
		boolean datebreak = true;
		ArrayList<Run> data7day = new ArrayList<Run>();  // working "streak"
		ArrayList<Run> streak = new ArrayList<Run>();  // best "streak"
		while (s.hasNext()) {
			String date = s.next();
			Scanner ds = new Scanner(date);
			ds.useDelimiter("/");
			int month = ds.nextInt();
			int day = ds.nextInt();
			int dist = Math.round(s.nextFloat() * 100);
			String time = s.next();
			Scanner ts = new Scanner(time);
			ts.useDelimiter(":");
			int hours = ts.nextInt();
			int mins = ts.nextInt();
			int secs = ts.nextInt();
			int seconds = hours * 3600 + mins * 60 + secs;
			int pace = Math.round(seconds * 100f / dist);
			if (!data7day.isEmpty()) {
				int n = data7day.size() - 1;
				datebreak = checkday(data7day.get(n), month, day);
			}
			if (datebreak) {
				data7day.clear();
				streakdist_curr = 0;
				datebreak = false;
			}
			data7day.add(new Run(month,day,dist,seconds));
			streakdist_curr += dist;
			if (data7day.size() == 8) {
				streakdist_curr -= data7day.remove(0).dist;
				if (streakdist_curr > streakdist_max) {
					streakdist_max = streakdist_curr;
					streak = (ArrayList<Run>)data7day.clone();
				}
			}
			distsum += dist;
			timesum += seconds;
			if (dist > distmax) distmax = dist;
			if (seconds > timemax) timemax = seconds;
			if (pace < pacemin) pacemin = pace;
			if (pace > pacemax) pacemax = pace;
			if (dist >= 500 && dist < 1000) {
				distshort += dist;
				timeshort += seconds;
				shortcount++;
			}
			else if (dist >= 1000 && dist < 4219.5/2) {
				distmed += dist;
				timemed += seconds;
				medcount++;
			}
			else if (dist >= 4219.5/2) {
				distlong += dist;
				timelong += seconds;
				longcount++;
			}  // else not interested...
			days++;
		}
		out.printf("Total distance = %4.2f\nTotal time = %s\n", distsum/100f, sec2time(timesum,true));
		out.printf("Average distance = %4.2f\nAverage time = %s\n", distsum/100f/days, sec2time(timesum/days,true));
		out.printf("Longest distance = %4.2f\nLongest time = %s\n", distmax/100f, sec2time(timemax,true));
		out.printf("Fastest pace = %s\n", sec2time(Math.round(pacemin), false));
		out.printf("Short run average distance = %4.2f\nShort run average pace = %s\n", distshort/100f/shortcount, sec2time(Math.round(timeshort * 100f / distshort), false));
		out.printf("Medium run average distance = %4.2f\nMedium run average pace = %s\n", distmed/100f/medcount, sec2time(Math.round(timemed * 100f / distmed), false));
		out.printf("Long run average distance = %4.2f\nLong run average pace = %s\n", distlong/100f/longcount, sec2time(Math.round(timelong * 100f / distlong), false));

		int streaktime = 0;
		int month1 = streak.get(0).month;
		int day1 = streak.get(0).day;
		int month2 = streak.get(6).month;
		int day2 = streak.get(6).day;
		while (!streak.isEmpty()) streaktime += streak.remove(0).seconds;
		out.printf("Best 7-day streak %d/%d - %d/%d\n", month1, day1, month2, day2);
		out.printf("Total distance = %4.2f\nTotal time = %s\n", streakdist_max/100f, sec2time(streaktime,true));
		out.printf("Average distance = %4.2f\nAverage time = %s\n", streakdist_max/700f, sec2time(Math.round(streaktime/7f),true));
		out.printf("Average pace = %s\n", sec2time(Math.round(streaktime * 100f / streakdist_max), false));
	}

	static boolean checkday(Run r, int m, int d) {
		// return true of days are sequential
		if (r.month == m ) return d - r.day != 1;
		else if (r.month != 12 ) return d - (r.day - daysinmonth[r.month]) != 1;
		else return d - (r.day - daysinmonth[1]) != 1;
	}
	
	static String sec2time(int m, boolean h) {
		int hr = m / 3600;
		m %= 3600;
		int min = m / 60;
		int sec = m % 60;
		String time = String.format("%d", min) + String.format(":%02d", sec);
		if (h)			
			if (min < 10) time = new String(hr + ":0" + time);
			else time = new String(hr + ":" + time);
		return time;
	}
}

class Run {
	public int month;
	public int day;
	public int dist;
	public int seconds;

	public Run(int m, int dy, int dst, int s) {
		month = m;
		day = dy;
		dist = dst;
		seconds = s;
	}
}