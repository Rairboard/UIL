//UIL 2018 - Region - Samantha
import java.io.*;
import java.util.*;
import static java.lang.System.*;
import static java.lang.Math.*;

public class Samantha{
	public static void main(String [] args) throws IOException
	{ 
		Scanner f = new Scanner(new File("samantha.dat"));
		while(f.hasNext())
		{
			String s = f.nextLine();
			double sum = 0;
			Scanner k = new Scanner(s);
			while(k.hasNext())
				sum+=k.nextDouble();
			out.printf("Subtotal: $%7.2f\n",sum);
			out.printf("Tax     : $%7.2f\n",sum*.0825);
			sum*=1.0825;
			out.printf("Total   : $%7.2f\n",sum);
			out.println("=====");
		}
		f.close();
	}
}
