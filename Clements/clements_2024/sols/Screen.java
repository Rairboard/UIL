import java.io.*;                                                                                                                  
import static java.lang.System.*;                                                                                                  
import java.lang.*;                                                                                                                
import java.util.*;                                                                                                                
import java.math.*;                                                                                                                
import java.text.*;                                                                                                                
public class Screen {                                                                                                            
	public static void main(String[]args)throws Exception{                                                                         
		new Screen().run();                                                                                                      
	}                                                                                                                              
	public void run()throws Exception{                                                                                             
		Scanner file = new Scanner(new File("screen.dat"));                                                                      
		int times = file.nextInt();                                                                                                
		file.nextLine();                                                                                                           
		while(times-- > 0) {                                                                                                       
	       int w = file.nextInt();
	       int h = file.nextInt();
	       file.nextLine();
	       String title = file.nextLine().trim();
	       String[] s = title.split("\\s+");
	       ArrayList<String>lines = new ArrayList<String>();
	       int curr = 0;
	       while(curr < s.length) {
	    	   String r = s[curr++];
	    	   while(curr < s.length && r.length() + s[curr].length() < w)
	    		   r += " " + s[curr++];
	    	   if(r.length() > w) {
	    		   s[--curr] = r.substring(w);
	    		   r = r.substring(0, w);
	    	   }
	    	   int i = 0;
	    	   while(r.length() < w) {
	    		   if(i++ % 2 == 0)
	    			   r += " ";
	    		   else
	    			   r = " " + r;
	    	   }
	    	   lines.add("#"+r+"#");
	       }
	       if(lines.size() > h) {
	    	   System.out.println("Title not compatible with size.");
	    	   continue;
	       }
	       int before = (h - lines.size()) / 2;
	       int after = (h - lines.size() + 1) / 2;
	       String blank = "#", border = "##";
	       for(int y = 0; y < w; y++) {
	    	   blank += " ";
	    	   border += "#";
	       }
	       blank += "#";
	       System.out.println(border);
	       while(before -- > 0)
	    	   System.out.println(blank);
	       for(String line:lines)
	    	   System.out.println(line);
	       while(after -- > 0)
	    	   System.out.println(blank);
	       System.out.println(border);
		}                                                                                                                          
	}                                                                                                                              
}                                                                                                                                  
                                                                                                                                   