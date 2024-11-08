/**
 * @(#)greg_calendar_6.java
 *
 *
 * @author 
 * @version - program to determine how many days until Christmas
 */
 
import java.util.Calendar;
import java.util.GregorianCalendar;

public class greg_calendar_6 
{
	public static void main(String[] args) 
	{
		GregorianCalendar today = new GregorianCalendar();	
		int currMon = today.get(Calendar.MONTH);	
		int currDayOfMon = today.get(Calendar.DAY_OF_MONTH);	
		int currYear = today.get(Calendar.YEAR);	
		int currDayOfYear = today.get(Calendar.DAY_OF_YEAR);
		
		System.out.println("The day is :: " + currMon + " " + currDayOfMon );
		System.out.println("The year is :: " + currYear + " " + currDayOfYear );
		
		int numDays;
		if (currMon == 11 && currDayOfMon > 25) 
		{
			GregorianCalendar xmas = new GregorianCalendar(currYear + 1, 11, 25);
			int xmasDayOfYear = xmas.get(Calendar.DAY_OF_YEAR);
			numDays = xmasDayOfYear + 31 - currDayOfMon;
		} 
		else 
		{
			GregorianCalendar xmas = new GregorianCalendar(currYear, 11, 25);
			int xmasDayOfYear = xmas.get(Calendar.DAY_OF_YEAR);
			numDays = xmasDayOfYear - currDayOfYear;
		}
		
		System.out.println("The number of days till Christmas is " + numDays);
	}
}
