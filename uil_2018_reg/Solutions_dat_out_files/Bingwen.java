//UIL 2018 - Region - Bingwen
import static java.lang.System.*;
import static java.lang.Math.*;
import java.util.*;
import java.io.*;
public class Bingwen {
	public static void main(String[] args) throws IOException
	{
		Scanner f=new Scanner(new File("bingwen.dat"));
		while(f.hasNext())
		{
			double cbrt = cbrt(f.nextInt());
			out.printf("%.2f\n",cbrt);
		}
	}
}
