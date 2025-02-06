import java.io.*;                                                                                                                  
import static java.lang.System.*;                                                                                                  
import java.lang.*;                                                                                                                
import java.util.*;                                                                                                                
import java.math.*;                                                                                                                
import java.text.*;                                                                                                                
public class Premiere {                                                                                                            
	public static void main(String[]args)throws Exception{                                                                         
		new Premiere().run();                                                                                                      
	}       
	
	public int tr(String h){
        String[]s = h.split(":");
        int n = (Integer.parseInt(s[0]) - 6) * 60;
        n += Integer.parseInt(s[1]);
        return n;
    }
	
	public int max(int[]arr){
        int max = Integer.MIN_VALUE;
        for(int i:arr)
            max = Math.max(i, max);
        return max;
    }
	
	public void run()throws Exception{                                                                                             
		Scanner file = new Scanner(new File("premiere.dat"));                                                                      
		int times = file.nextInt();                                                                                                
		file.nextLine();                                                                                                           
		while(times-- > 0) {                                                                                                       
			int[] celebs = new int[360];
			int num = file.nextInt();
			file.nextLine();
			while(num-- > 0) {
				String time = file.next();
				int stretch = file.nextInt();
				int st = tr(time);
				int end = st + stretch;
                for(int x = st; x < end; x++) 
                    celebs[x]++;
			}
			file.nextLine();
			System.out.println(max(celebs));
		}                                                                                                                          
	}                                                                                                                              
}                                                                                                                                  
                                                                                                                                   