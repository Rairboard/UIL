import java.io.*;                                                                                                                  
import static java.lang.System.*;                                                                                                  
import java.lang.*;                                                                                                                
import java.util.*;                                                                                                                
import java.math.*;                                                                                                                
import java.text.*;                                                                                                                
public class Set {                                                                                                            
	public static void main(String[]args)throws Exception{                                                                         
		new Set().run();                                                                                                      
	}                                                                                                                              
	public void run()throws Exception{                                                                                             
		Scanner file = new Scanner(new File("set.dat"));                                                                      
		int times = file.nextInt();                                                                                                
		file.nextLine();                                                                                                           
		while(times-- > 0) {                                                                                                       
			  String s = "_______________\r\n"
			  		+ "|1111111111111|\r\n"
			  		+ "|1112211111221|\r\n"
			  		+ "|1122221112221|\r\n"
			  		+ "|1111111111111|\r\n"
			  		+ "|1111333111111|\r\n"
			  		+ "|1113333311111|\r\n"
			  		+ "|1113333331111|\r\n"
			  		+ "|1111444111111|\r\n"
			  		+ "|1111441111111|\r\n"
			  		+ "|1111441115555|\r\n"
			  		+ "|5555555555555|\r\n"
			  		+ "==============="
			  		+ ""; 
			  String[] t = (":"+file.nextLine()).trim().substring(1).split(":");
			  s = s.replaceAll("1","\\"+t[0]);
			  s = s.replaceAll("2","\\"+t[1]);
			  s = s.replaceAll("3","\\"+t[2]);
			  s = s.replaceAll("4","\\"+t[3]);
			  s = s.replaceAll("5","\\"+t[4]);
			  System.out.println(s);
		}                                                                                                                          
	}                                                                                                                              
}                                                                                                                                  
                                                                                                                                   