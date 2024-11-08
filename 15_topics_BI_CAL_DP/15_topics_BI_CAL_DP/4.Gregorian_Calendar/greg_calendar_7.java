/**
 * @(#)greg_calendar_7.java
 *
 *
 * @author 
 * @version - basic GregorianCalendar - how to make 7 dates
 */
 
import static java.util.Calendar.*;
import java.util.GregorianCalendar;

public class greg_calendar_7 
{
	public static void main(String[] args) 
	{
		GregorianCalendar one = new GregorianCalendar(2001, 1, 18);	
		GregorianCalendar two = new GregorianCalendar(2009, 1, 19);	
		
		long diffInMilli=Math.abs(two.getTimeInMillis()-one.getTimeInMillis());

		System.out.println("diff in days :: " + diffInMilli/1000/60/60/24);
		System.out.println("diff in hours :: " + diffInMilli/1000/60/60);
		System.out.println("diff in minutes :: " + diffInMilli/1000/60);
		System.out.println("diff in seconds :: " + diffInMilli/1000);
		
		    	
	}
}
