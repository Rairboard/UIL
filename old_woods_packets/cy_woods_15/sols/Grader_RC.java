import java.io.*;
import java.util.*;

public class Grader_RC 
{
        
    
    public void run() throws Exception
    {
    	Scanner file = new Scanner(new File("judgegrader.dat"));
    	int times = file.nextInt();
    	file.nextLine();
    	
    	for(int i = 0; i < times; i++)
    	{
    		String name = "";
    		String grd = "";
    		name = file.next();
    		double grade = file.nextDouble();
    		if(grade >= 90)
    		{
    			grd = "A";
    		}
    		if(grade < 90 && grade >= 80)
    		{
    			grd = "B";
    		}
    	    if(grade < 80 && grade >= 70)
    	    {
    	    	grd = "C";
    	    }
    	    if( grade < 70)
    	    {
    	    	grd = "F";
    	    }
    	    
    	    System.out.println( grd + " " + name);
    	    
    	}
    }
    
  
    public static void main(String[] args) throws Exception
    {
       Grader_RC chad = new Grader_RC();
       chad.run();
    }
}
