import java.io.*;                                                                                                                  
import static java.lang.System.*;                                                                                                  
import java.lang.*;                                                                                                                
import java.util.*;                                                                                                                
import java.math.*;                                                                                                                
import java.text.*;                                                                                                                
public class Reviews {                                                                                                            
	public static void main(String[]args)throws Exception{                                                                         
		new Reviews().run();                                                                                                      
	}                                                                                                                              
	public void run()throws Exception{                                                                                             
		Scanner file = new Scanner(new File("reviews.dat"));                                                                      
		int times = file.nextInt();     
		ArrayList<String> bad = new ArrayList<String>(), good = new ArrayList<String>();
		good.add("groundbreaking");
		good.add("wonderful");
		good.add("wonderfully");
		good.add("entertaining");
		good.add("one-of-a-kind");
		good.add("incredible");
		good.add("unforgettable");
		good.add("unforgettably");
		good.add("interesting");
		good.add("exceptional");
		good.add("masterful");
		good.add("brilliant");
		good.add("brilliantly");
		good.add("enjoyable");
		good.add("masterpiece");
		good.add("entertained");
		bad.add("disappointingly");
		bad.add("messily");
		bad.add("uninspired");
		bad.add("disappointing");
		bad.add("messy");
		bad.add("forgettable");
		bad.add("lackluster");
		bad.add("poorly");
		bad.add("boring");
		bad.add("far-fetched");
		bad.add("confusing");
		bad.add("confused");
		bad.add("trash");
		bad.add("flawed");
		bad.add("monotonous");
		bad.add("ridiculous");
		/*
			Bad Words: boring, poorly, lackluster, forgettable, messy, disappointing, uninspired, 
			messily, disappointingly, ridiculous, trash, monotonous, flawed, 
			confused, far-fetched, confusing
		 */
		file.nextLine();                                                                                                           
		while(times-- > 0) {         
			int b = 0, g = 0;
			String line = file.nextLine();
			while(!line.equals("--------------------")) {
				String[]s = line.toLowerCase().replaceAll("[\\.,!\\?]","").split("\\s+");
				for(String t:s) {
					if(good.contains(t))g++;
					if(bad.contains(t))b++;
				}
				line = file.nextLine();
			}
			if(b > g)System.out.println("You lack vision.");
			if(b < g)System.out.println("This is one for the books.");
			if(b == g)System.out.println("Make up your mind.");
		}                                                                                                                          
	}                                                                                                                              
}                                                                                                                                  
                                                                                                                                   