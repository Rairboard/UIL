import java.io.*;                                                                                                                  
import static java.lang.System.*;                                                                                                  
import java.lang.*;                                                                                                                
import java.util.*;                                                                                                                
import java.math.*;                                                                                                                
import java.text.*;                                                                                                                
public class Admissions {                                                                                                            
	public static void main(String[]args)throws Exception{                                                                         
		new Admissions().run();                                                                                                      
	}                                                                                                                              
	public void run()throws Exception{                                                                                             
		Scanner file = new Scanner(new File("admissions.dat"));                                                                      
		int times = file.nextInt();  
		double gpa = file.nextDouble(), sum = 0;
		file.nextLine();                                                                                                           
		while(times-- > 0) {                                                                                                       
			String name = file.next();
			double fee = file.nextDouble(), min = file.nextDouble();
			if(min <= gpa)
				sum += fee;
		}                  
		System.out.printf("$%,.3f%n",sum);
	}                                                                                                                              
}                                                                                                                                  
                                                                                                                                   