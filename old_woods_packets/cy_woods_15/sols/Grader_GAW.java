import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class Grader_GAW
{
	private String name;
	private String grade;
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("grader.dat"));
		
		int times = file.nextInt();
		file.nextLine();
		
		for(int i = 0; i<times; i++)
		{
			name = file.next();
			grade = "";
			double tmp = file.nextInt();
			if(tmp<=100 && tmp>=89.5){
				grade = "A";
			}
			if(tmp<=89.49 && tmp>=79.45){
				grade = "B";
			}
			if(tmp<=79.44 && tmp>=69.45){
				grade = "C";
			}
			if(tmp<=69.44){
				grade = "F";
			}
			file.nextLine();
		System.out.println(grade + " " + name);		
		}
		
	}

	public static void main(String[] args) throws Exception
	{
		new Grader_GAW().run();
	}	
	
}