import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

			//change the class name
public class DerivativeRebecca
{
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("derivative.dat"));
		
			//read in the number at the top of the data file
		int times = file.nextInt(); 
			//pick up the left over enter key
		file.nextLine();
		
		for(int asdf = 0; asdf<times; asdf++)
		{
			int d = file.nextInt();
			file.nextLine();
			ArrayList<String> out;
            out = new ArrayList<String>();

			Scanner line = new Scanner(file.nextLine());

 		
			 while(line.hasNext())
			{
				out.add(line.next());
				
			}
			
			
			
			
			
             for(int i = 0; i< out.size(); i+=2)
			{
    			out.set ( i,  derivative(out.get(i))  );
			}
			
				
             for(int i = 0; i< out.size(); i++)
			{
    			if(out.get(i).equals(""))
    			{
    				out.remove(i);
    			}

			}
			
			
    			if(out.get(out.size()-1).equals("+"))
    			{
    				out.remove  (out.size()-1);
    			}
    			
    				if(out.get(out.size()-1).equals("-"))
    			{
    				out.remove  (out.size()-1);
    			}

			
		
			System.out.print("f'(x)=");
			 
			  for( String item : out )
        		{  System.out.print( item );  }
        		
        	System.out.println();
      

		}
	}
	
	
	
	
	
	
	
			public String derivative(String x)

         {

   			 if(!x.contains("x")) return "";

   			 if(x.contains("^")) return calculate(x);

   			 return x.substring(0,x.indexOf("x"));

		 }
		 
		 
		 
		 public String calculate(String c)
		 {    
		 	  String b = c.substring(0,c.indexOf("x"));
		 	  String a = c.substring (c.indexOf("^") +1);
		 	  
		 	  
		 	  int coeff = Integer.parseInt(b);
		 	  int ex = Integer.parseInt(a );
		 	  
		 	  int outtie = coeff*ex;
		 	  
		 	  if (ex == 2) return outtie+"x";
		 	  
		 	  return outtie+"x^"+ (ex-1);
	    	 	
		 }
     
     
     

	public static void main(String[] args) throws Exception
	{
			//change this to whatever your class name is
		new Derivative().run();
	}	
	
}