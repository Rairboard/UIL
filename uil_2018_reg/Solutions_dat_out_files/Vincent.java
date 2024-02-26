//UIL 2018 - Region - Vincent
import java.io.*;
import java.util.*;
import static java.lang.System.*;
import static java.lang.Math.*;

public class Vincent{
	public static void main(String [] args) throws IOException
	{ 
		Scanner f = new Scanner(new File("vincent.dat"));
		Scanner k = null;
		Calendar cal = Calendar.getInstance();
		while(f.hasNext())
		{
			cal.set(f.nextInt(),f.nextInt()-1,f.nextInt(),f.nextInt(),f.nextInt(),0);
			f.nextLine();
			out.printf("%tB %td, %tY - %tI:%tM %Tp\n",cal,cal,cal,cal,cal,cal);		
			out.println("-----");
			long millis = cal.getTimeInMillis();
			String s = f.nextLine();
			k = new Scanner(s);
			while(k.hasNext()){
				long min = k.nextLong();
				cal.setTimeInMillis(millis+min*60000);
				out.printf("%tB %td, %tY - %tI:%tM %Tp\n",cal,cal,cal,cal,cal,cal);		
			}
			out.println("=====");
		}
		f.close();
	}
}
