/**
 * @(#)greg_calendar_3.java
 *
 *
 * @author 
 * @version - basic GregorianCalendar - how to change fields 
 */
 
import static java.util.Calendar.*;
import java.util.GregorianCalendar;

public class greg_calendar_3 
{
	public static void main(String[] args) 
	{
		GregorianCalendar tod = new GregorianCalendar(2009, 1, 18);	
		System.out.println("The year is " + tod.get(YEAR));
		System.out.println("The month is " + tod.get(MONTH));
		System.out.println("The day of the month is " + tod.get(DAY_OF_MONTH));
		System.out.println("The day of the week is " + tod.get(DAY_OF_WEEK));   
		
		tod.set(YEAR, tod.get(YEAR)+4);
		System.out.println("\n\nThe year is " + tod.get(YEAR)); 
			
		tod.set(DAY_OF_MONTH, tod.get(DAY_OF_MONTH)+18);
		System.out.println("\n\nThe day of month is " + tod.get(DAY_OF_MONTH)); 				    	

		System.out.println("\n\nThe month is " + tod.get(MONTH)); 			
	}
}
