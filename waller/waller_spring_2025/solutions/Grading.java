import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Grading {
	public static void main(String[]args)throws Exception{
		new Grading().run();
	}
	public void run()throws Exception{
		Scanner file = new Scanner(new File("grading.dat"));
		int times = file.nextInt();
		file.nextLine();
		ArrayList<Student> st = new ArrayList<Student>();
		TreeMap<String,Student> tm = new TreeMap<String,Student>();
		while(times-- > 0) {
			String key = file.next();
			int num = file.nextInt();
			file.nextLine();
			while(num-- > 0) {
				String name = file.next();
				String ans = file.nextLine().trim();
				double d = score(ans.toCharArray(), key.toCharArray());
				if(!tm.containsKey(name)) {
					Student s = new Student(name, d*100);
					tm.put(name,s);
					st.add(s);
				}
				else
					tm.get(name).grades.add(d*100);
			}
		}
		for(Student s:st)
			s.avg();
		Collections.sort(st);
		for(int i = 1; i <= st.size(); i++)
			System.out.println("#"+i+": "+st.get(i - 1));
	}
	public double score(char[] a, char[] k) {
		double cnt = 0;
		for(int i = 0; i < a.length; i++) 
			if(a[i] == k[i])cnt++;
		return cnt / a.length;
	}
}
class Student implements Comparable<Student>{
	double average;
	ArrayList<Double> grades;
	String name;
	
	public Student(String n,double d) {
		grades = new ArrayList<Double>();
		name=n;
		grades.add(d);
	}
	
	public void avg() {
		for(double g:grades)
			average += g;
		average /= grades.size();
		Collections.sort(grades);
		Collections.reverse(grades);
	}
	
	public int compareTo(Student s) {
		return -Double.compare(average, s.average);
	}
	
	public String toString() {
		return name+", "+str();
	}
	
	public String str() {
		String s = "";
		for(double g:grades)
			s += String.format("%.2f ",g);
		return s.trim();
	}
}
