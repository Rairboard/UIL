import java.io.*;
import java.util.*;
import java.text.*;
import java.awt.*;
import java.math.*;
import java.util.regex.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Character.*;
import static java.util.Collections.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;

public class Slinky {

    public void run()throws Exception{
    	Scanner file = new Scanner(new File("Slinky_student.dat"));
    	int times = file.nextInt();
    	file.nextLine();
    	for(int donotuse = 0;donotuse<times;donotuse++){
    		double k=file.nextDouble();
    		double x=file.nextInt();
    		double n=.5*k*Math.pow(x,2);
    		
    		System.out.println(n);

    	}


    }

    public static void main(String[] args)throws Exception {
    	new Slinky().run();
    }
}
