/**
 * @(#)greg_calendar_1.java
 *
 *
 * @author 
 * @version - basic GregorianCalendar 
 */
 
import static java.util.Calendar.*;
import java.util.GregorianCalendar;

public class greg_calendar_1 
{
	public static void main(String[] args) 
	{
		GregorianCalendar today = new GregorianCalendar(2009, 1, 18);	
		System.out.println("The year is " + today.get(YEAR));
		System.out.println("The month is " + today.get(MONTH));
		System.out.println("The day of the month is " + today.get(DAY_OF_MONTH));
		System.out.println("The day of the week is " + today.get(DAY_OF_WEEK));   
	}
}
