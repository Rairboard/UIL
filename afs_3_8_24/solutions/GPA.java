import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
import static java.lang.System.*;

public class GPA 
{
	public static void main(String [] args) throws FileNotFoundException 
	{
		Scanner f = new Scanner(new File("GPA.dat"));
		int n = f.nextInt();
		f.nextLine();
		//map course number to Course object
		HashMap<Integer,Course> map = new HashMap<Integer,Course>();
		//load courses
		while(n-->0)
		{
			args = f.nextLine().split(" ");
			int num = Integer.parseInt(args[0]);
			map.put(num,new Course(args[1],args[2]));
		}
		n = f.nextInt();
		f.nextLine();
		//load students
		ArrayList<Student> students = new ArrayList<Student>();
		while(n-->0)
			students.add(new Student(f.nextLine(),map));
		//output students and gpa
		for(Student s:students)
			out.printf("%s %.3f\n",s.name,s.gpa);
		//sort student list
		Collections.sort(students);
		//output last student (greatest gpa)
		out.println(students.get(students.size()-1).name);
		
		
	}
}
//class for Course, with honors designation and number of credits
class Course
{
	boolean honors;
	int credits;
	public Course(String h, String c)
	{
		honors = h.equals("YES");
		switch(c)
		{
			case "YEAR":credits = 4;break;
			case "SEMESTER":credits = 2;break;
			case "QUARTER":credits = 1;
		}
	}
}
class Student implements Comparable
{
	String name;
	double gpa;
	//compares two Student objects by gpa
	public int compareTo(Object o)
	{
		if(this.gpa> ((Student)o).gpa)
			return 1;
		if(this.gpa< ((Student)o).gpa)
			return -1;
		return 0;
	}
	//constructs Student object 
	public Student(String s,HashMap m)
	{
		Scanner chop = new Scanner(s);
		//get name
		name = chop.next();
		double credits = 0, totalCredits=0, points = 0, totalPoints = 0;
		//get grades and courses
		while(chop.hasNext())
		{
			String grade = chop.next();
			int course = Integer.parseInt(chop.next());
			credits = ((Course)m.get(course)).credits;
			
			
			boolean hon = ((Course)m.get(course)).honors;
			//calculate total points and total credits
			switch(grade)
			{
				case "A+":points=4.75;points+=hon?0.5:0;break;
				case "A":points=4.5;points+=hon?0.5:0;break;
				case "A-":points=4.25;points+=hon?0.5:0;break;
				case "B+":points=3.75;points+=hon?0.5:0;break;
				case "B":points=3.5;points+=hon?0.5:0;break;
				case "B-":points=3.25;points+=hon?0.5:0;break;
				case "C+":points=2.75;points+=hon?0.5:0;break;
				case "C":points=2.5;points+=hon?0.5:0;break;
				case "C-":points=2.25;points+=hon?0.5:0;break;
				case "D+":points=1.25;break;
				case "D":points=1;break;
				case "D-":points=0.75;break;
				case "F":points=0;
			}
			totalPoints+=points*credits;
			totalCredits+=credits;
		}
		//calculate gpa
		gpa=totalPoints/totalCredits;
	}
}
/*
Student Input
8
107 YES YEAR
118 NO YEAR
202 YES YEAR
216 NO QUARTER
335 YES SEMESTER
494 NO SEMESTER
731 NO YEAR
915 YES QUARTER
4
ADAM C+ 494 B- 202
DON B 118 C+ 107 A 202 B+ 494 D- 915
CHUCK A 731 B- 494 F 118 C 107
BRETT C 494 A- 202 B 118

Student Output
ADAM 3.417
DON 3.683
CHUCK 2.607
BRETT 3.800
BRETT

Test Input
9
107 YES YEAR
118 NO YEAR
202 YES YEAR
216 NO QUARTER
335 YES SEMESTER
400 YES SEMESTER
494 NO SEMESTER
731 NO YEAR
915 YES QUARTER
9
ADAM C+ 494 B- 202
DON B 118 C+ 107 A 202 B+ 494 D- 915
CHUCK A 731 B- 494 F 118 C 107
BRETT C 494 A- 202 B 118
DAVE D+ 335 A 494 F 915 F 216 C- 107
SUSIE A- 335 B+ 494 A 915 A+ 216
AL A 731 B 202 C- 400
BILL C 335 A 494 A 915
SALLY A 731 B- 494 A+ 400 F 118 C 107

Test Output
ADAM 3.417
DON 3.683
CHUCK 2.607
BRETT 3.800
DAVE 2.250
SUSIE 4.458
AL 3.950
BILL 4.000
SALLY 2.938
SUSIE
*/