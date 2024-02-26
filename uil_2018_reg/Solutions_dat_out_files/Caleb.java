//UIL 2018 - Region - Caleb
import java.io.*;
import java.util.*;
import static java.lang.System.*;
import static java.lang.Math.*;

public class Caleb{
	public static void main(String [] args) 
		throws IOException
	{ 
		Scanner f = new Scanner(new File("caleb.dat"));
		int N = f.nextInt();
		while(N-->0)
		{
			String s = f.next();
			args = s.split("/");
			out.print(args[0]+" "+args[1]+" - ");
			int H = Integer.parseInt(args[0]);
			int M = Integer.parseInt(args[1]);
			int h = (int)(H/360.0*12);
			int m = (int)(M/360.0*60);
			if(h==0)
				h=12;
			out.printf("%d:%02d\n",h,m);
		}
		f.close();
	}
}
