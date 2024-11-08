/**
 * @(#)greg_calendar_4.java
 *
 *
 * @author 
 * @version - basic GregorianCalendar - how to calculate year difference
 */
 
import static java.util.Calendar.*;
import java.util.GregorianCalendar;

public class greg_calendar_4 
{
	public static void main(String[] args) 
	{
		GregorianCalendar one = new GregorianCalendar(2001, 1, 18);	
		GregorianCalendar two = new GregorianCalendar(2009, 1, 19);	
		
		int diff = 0;
		while(one.get(YEAR)!=two.get(YEAR))
		{
			one.set(YEAR,one.get(YEAR)+1);
			diff++;
		}
		
		System.out.println("diff in year :: " + diff);	      	    	
	}
}
