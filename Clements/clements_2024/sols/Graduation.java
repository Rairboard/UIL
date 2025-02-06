import java.io.*;                                                                                                                  
import static java.lang.System.*;                                                                                                  
import java.lang.*;                                                                                                                
import java.util.*;                                                                                                                
import java.math.*;                                                                                                                
import java.text.*;                                                                                                                
public class Graduation {                                                                                                            
	public static void main(String[]args)throws Exception{                                                                         
		new Graduation().run();                                                                                                      
	}                                                                                                                              
	public void run()throws Exception{                                                                                             
		Scanner file = new Scanner(new File("graduation.dat"));                                                                                                                                                                                 
		while(file.hasNext()) {                                                                                                       
			System.out.println(file.nextLine().toUpperCase());
		}                                                                                                                          
	}                                                                                                                              
}                                                                                                                                  
                                                                                                                                   