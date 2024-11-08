


///Natasha Solanki 


import java.io.*;
import java.util.*;
import java.text.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Character.*;
import static java.util.Collections.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;

public class alphabet 
{
        
    
    public void run() throws Exception 
    {
    	Scanner file = new Scanner(new File("alpha.dat")); 
    	int run = file.nextInt(); 
    	file.nextLine(); 
    	String b = "ZYXWVUTSRQPONMLKJIHGFEDCBA"; 
    	
    	for(int x = 0; x< run; x++)
    	{
    		String in = file.nextLine(); 
    		String [] input = in.split(" "); 
    	    
    	  	int index = b.indexOf(input[1]); 
    	    int index2 = b.indexOf(input[0]); 
    	    int cnt = 0; 
    	    if(index == 0)
    	    {
    	        for(int i = 0; i < 26; i++)
    	        {
    	        
    	            for(int l = 0; l < cnt; l++)
    	            {
    	            	System.out.print(" ");
    	            }
    	        	cnt++; 
    	        	System.out.println(b.substring(i, i+1)); 
    	        	
    	        	
    	        }
    	    }
    	    else
    	    {
    	       for(int y = 0; y< 26; y++)
    	       {
    	       	  	for(int l = 0; l < cnt; l++)
    	            {
    	            	System.out.print(" ");
    	            }
    	        	cnt++; 
    	        	if(y < index || y > index2)
    	        	{
    	        		System.out.println("#");
    	        	}
    	        	else
    	        	{
    	        		System.out.println(b.substring(y, y+1)); 
    	        	}
    	       }
    	    	
    	    }
    	  
    		
    	}
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception 
    {
    	alphabet abc = new alphabet(); 
    	abc.run(); 
    }
}
