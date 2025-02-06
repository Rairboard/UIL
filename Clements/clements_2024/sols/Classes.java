import java.io.*;                                                                                                                  
import static java.lang.System.*;                                                                                                  
import java.lang.*;                                                                                                                
import java.util.*;                                                                                                                
import java.math.*;                                                                                                                
import java.text.*;                                                                                                                
public class Classes {                                                                                                            
	public static void main(String[]args)throws Exception{                                                                         
		new Classes().run();                                                                                                      
	}                                                                                                                              
	public void run()throws Exception{                                                                                             
		Scanner file = new Scanner(new File("classes.dat"));                                                                      
		int times = file.nextInt();                                                                                                
		file.nextLine();        
		ArrayList<String> cred = new ArrayList<String>();
		ArrayList<Course> a = new ArrayList<Course>();
		String[] lin = file.nextLine().trim().split("\\s+");
		for(String s:lin)
			cred.add(s);
		while(times-- > 0) {                                                                                                       
			  String[] co = file.nextLine().trim().split("\\|");
			  Course c = new Course(co[0], co[1], Integer.parseInt(co[2]), co[3], Double.parseDouble(co[4]), co[5]);
			  String[] pre = co[6].trim().split("[ ,]+");
			  boolean good = true;
			  for(String p:pre)
				  good &= cred.contains(p);
			  if(good)a.add(c);
		}
		Collections.sort(a);
		int hour = 0;
		while(a.size() >= 0) {
			Course c = a.remove(0);
			if(hour + c.hours <= 20) {
				out.println(c);
				hour += c.hours;
			}
			else
				break;
		}
	}                                                                                                                              
}
class Course implements Comparable<Course>{
	String code, name;
	int time, hours, subject;
	double rating;
	
	public Course(String c, String n, int h, String s, double r, String t) {
		code = c;
		name = n;
		hours = h;
		time = tim(t);
		subject = sub(s);
		rating = r;
	}
	
	private int tim(String t) {
		String[] s = t.split(":");
		int hr = Integer.parseInt(s[0]);
		switch(hr) {
		case 7: case 8: return 5;
		case 9: case 10: return 3;
		case 11: case 12: case 13: case 14: return 1;
		case 15: case 16: case 17: return 2;
		case 18: case 19: return 4;
		}
		return 1000; //this will never happen
	}
	
	private int sub(String s) {
		if(s.equals("Set-Design"))return 5;
		if(s.equals("Writing"))return 1;
		if(s.equals("Sound-Design"))return 3;
		if(s.equals("Casting"))return 4;
		if(s.equals("Lighting"))return 2;
		return 1000; //This will never happen
	}
	
	public int compareTo(Course c) {
		if(subject != c.subject)return subject - c.subject;
		if(Math.abs(rating - c.rating) >= 1e-6)return -Double.compare(rating, c.rating);
		if(time != c.time)return time - c.time;
		if(hours != c.hours)return hours - c.hours;
		return code.compareTo(c.code);
	}
	
	public String toString() {
		return code+": "+name;
	}
}
                                                                                                                                   