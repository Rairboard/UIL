import java.io.*;                                                                                                                  
import static java.lang.System.*;                                                                                                  
import java.lang.*;                                                                                                                
import java.util.*;                                                                                                                
import java.math.*;                                                                                                                
import java.text.*;                                                                                                                
public class Nightcrawler {                                                                                                            
	public static void main(String[]args)throws Exception{                                                                         
		new Nightcrawler().run();                                                                                                      
	}                                                                                                                              
	public void run()throws Exception{                                                                                             
		Scanner file = new Scanner(new File("nightcrawler.dat"));                                                                      
		int times = file.nextInt();                                                                                                
		file.nextLine();                                                                                                           
		while(times-- > 0) {                                                                                                       
			ArrayList<double[]> points = new ArrayList<double[]>();
			String[] st = file.nextLine().trim().split("\\s+");
			for(String s:st) {
				double[] d = new double[2];
				String[] t = s.replaceAll("[\\)\\(]","").split(",");
				d[0] = Double.parseDouble(t[0]);
				d[1] = Double.parseDouble(t[1]);
				points.add(d);
			}
			double max = 0;
			for(double[] d1:points)
				for(double[] d2:points)
					max = Math.max(max, dist(d1, d2));
			System.out.printf("%.2f%n",max);
		}                                                                                                                          
	}               
	
	double dist(double[] p1, double[] p2) {
		return Math.hypot(Math.abs(p1[0] - p2[0]),Math.abs(p1[1] - p2[1]));
	}
}                                                                                                                                  
                                                                                                                                   