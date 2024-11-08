import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class grader_JVJ
{
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("grader.dat"));
		int times = file.nextInt(); 
		file.nextLine();
		
		for(int x = 0;x < times;x++)
		{
			Scanner line = new Scanner (file.nextLine());
			{
				String name = line.next();
				String grade = "";
				double temp = line.nextDouble();
				if(temp >= 89.5)
				{
					grade = "A";
				}
				if(temp >= 79.45 && temp <= 89.49)
				{
					grade = "B";
				}
				if(temp >= 69.45 && temp <= 79.44)
				{
					grade = "C";
				}
				if(temp <= 69.44 && temp >= 0)
				{
					grade = "F";
				}
				System.out.println(grade + " " + name);
			}
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		new grader_JVJ().run();
	}	
}