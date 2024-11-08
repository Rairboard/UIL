/**
 * @(#)greg_calendar_2.java
 *
 *
 * @author 
 * @version - basic GregorianCalendar - how to make 2 dates
 */
 
import static java.util.Calendar.*;
import java.util.GregorianCalendar;

public class greg_calendar_2 
{
	public static void main(String[] args) 
	{
		GregorianCalendar tod = new GregorianCalendar(2009, 1, 18);	
		System.out.println("The year is " + tod.get(YEAR));
		System.out.println("The month is " + tod.get(MONTH));
		System.out.println("The day of the month is " + tod.get(DAY_OF_MONTH));
		System.out.println("The day of the week is " + tod.get(DAY_OF_WEEK));   
		
		GregorianCalendar tom = new GregorianCalendar(2009, 1, 19);	
		System.out.println("\n\nThe year is " + tom.get(YEAR));
		System.out.println("The month is " + tom.get(MONTH));
		System.out.println("The day of the month is " + tom.get(DAY_OF_MONTH));
		System.out.println("The day of the week is " + tom.get(DAY_OF_WEEK));
		System.out.println();
		System.out.println(tod.isLeapYear(tod.get(YEAR))?"The first date is a leap year":"The first date is not a leap year");
		System.out.println(tom.isLeapYear(tom.get(YEAR))?"The second date is a leap year":"The second date is not a leap year") ;	    	
	}
}
