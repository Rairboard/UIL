//UIL State 2018 - Richa - Sample Solution
import static java.lang.System.out;
import java.util.*;
import java.io.*;
public class Richa {

	public static void main(String[] args) throws IOException{
		Scanner f=new Scanner(new File("richa.dat"));
		int N = f.nextInt();
		Map<Integer,String> map = new TreeMap<Integer,String>();
		while(N-->0)
			map.put(f.nextInt(),f.next());
		while(f.hasNext()){
			String g1 = f.next();
			int c1 = f.nextInt();
			String g2 = f.next();
			int c2 = f.nextInt();
			out.printf("%.3f\n",gpa(g1,c1,g2,c2,map));
		}
	}
	static double gpa(String g1,int c1,String g2,int c2, Map<Integer,String> map){
		String course1 = map.get(c1);
		double p1 = points(g1.charAt(0));
		if(g1.length()>1)
			p1 += g1.charAt(1)=='+'?0.25:-0.25;
		if(course1.charAt(0)=='Y'&&"ABC".indexOf(g1.charAt(0))>=0)
			p1 += 0.5;
		int credits1 = course1.charAt(1)=='Y'?4:course1.charAt(1)=='S'?2:1;
		double total = p1*credits1;
		
		String course2 = map.get(c2);
		double p2 = points(g2.charAt(0));
		if(g2.length()>1)
			p2 += g2.charAt(1)=='+'?0.25:-0.25;
		if(course2.charAt(0)=='Y'&&"ABC".indexOf(g2.charAt(0))>=0)
			p2 += 0.5;
		int credits2 = course2.charAt(1)=='Y'?4:course2.charAt(1)=='S'?2:1;
		total += p2*credits2;
		
		return total/(credits1+credits2); 
	}
	static double points(char a){
		switch(a){
			case 'A':return 4.5;
			case 'B':return 3.5;
			case 'C':return 2.5;
			case 'D':return 1;
			case 'F':return 0;
		}
		return 0;
	}
}
