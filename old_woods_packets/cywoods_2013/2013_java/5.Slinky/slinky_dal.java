/**
 * @(#)slinky_dal.java
 *
 *
 * @author 
 * @version 1.00 2013/8/26
 */
 
import java.util.*;
import java.io.*;
import java.text.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Character.*;
import static java.lang.Math.*;
import static java.util.Collections.*;
import static java.util.Arrays.*;

public class slinky_dal 
{
	public void run()throws Exception
	{
		Scanner file = new Scanner(new File("slinky_dal_student.dat"));
		int n = file.nextInt();
		file.nextLine();
		
		for(int i = 0;i<n;i++)
		{
			double k = file.nextDouble();
			double x = file.nextDouble();
			double pe = .5*k*Math.pow(x,2.0);
			System.out.println(pe);
		}
	}
	
        
    public static void main(String[] args) throws Exception
    {
 		slinky_dal a = new slinky_dal();
 		a.run();
    }
}
