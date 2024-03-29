import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class shuffle
{
	public static void main(String [] args) throws FileNotFoundException 
	{
		Scanner f = new Scanner(new File("shuffle.dat"));
		while(f.hasNext())
		{
			TreeSet<String> set = new TreeSet<String>();
			Scanner chop = new Scanner(f.nextLine());
			while(chop.hasNext())
				set.add(chop.next());
			for(String s:set)
				out.print(s+" ");
			out.println();
		}
	}
}