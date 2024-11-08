/**
 * @(#)greg_calendar_5.java
 *
 *
 * @author 
 * @version - basic GregorianCalendar - how to calculate difference in days between 1 dates
 */
 
import static java.util.Calendar.*;
import java.util.GregorianCalendar;

public class greg_calendar_5 
{
    public static void main(String[] args) 
    {
	    GregorianCalendar one = new GregorianCalendar(2009, 1, 1);	
  	    GregorianCalendar two = new GregorianCalendar(2009, 1, 25);	
  	    
  	    int diff = 0;
  	    while(!one.equals(two))
  	    {
  	    	one.set(DAY_OF_MONTH, one.get(DAY_OF_MONTH)+1);
  	    	diff++;
  	    }
  	    
  	    System.out.println("diff in days :: " + diff);	      	    	
    }
}
