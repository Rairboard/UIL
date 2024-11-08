import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

			//change the class name
public class Factorfact
{
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("factor.dat"));
		
			//read in the number at the top of the data file
		int times = file.nextInt(); 
			//pick up the left over enter key
		file.nextLine();
		
			//read in each data set
		for(int asdf = 0; asdf<times; asdf++)
		{
		int one = file.nextInt();
		file.nextLine();
        
        ArrayList<Integer> list;
        
        list = new ArrayList<Integer>();
        
        	while(one>=1){
        		
        		for(int i=1; i<=one; i++){
        			
        			if(one%i==0){ 
        				
        				list.add(i);
        				
        				System.out.print(i+ " : ");
        				
        		        for (int k=1; k<=i; k++)
        		        	{
        			  		if(i%k==0) System.out.print(k+" ");
        		    }
        		    System.out.println();
        		}
        		}
        		one = 0;
        	}
			System.out.println();
		}
	}

	public static void main(String[] args) throws Exception
	{
			//change this to whatever your class name is
		new Factorfact().run();
	}	
	
}