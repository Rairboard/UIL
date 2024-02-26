//UIL 2018 - Region - Joe
import static java.lang.System.*;
import java.util.*;
import java.io.*;
public class Joe {
	public static void main(String[] args) throws IOException
	{
		Scanner f=new Scanner(new File("joe.dat"));
		while(f.hasNext())
		{
			String s = f.nextLine().toUpperCase();
			args = s.split("[ ,.?'\"]+");
			Set<String> set = new TreeSet<String>();
			int longest = 0;
			for(String a:args)
			{
				set.add(a);
				if(a.length()>longest)
					longest = a.length();
			}
			int n = 1;
			boolean left = true;
			while(n<=longest)
			{
				for(String a:set)
					if(a.length()==n)
						out.print(a+" ");
				n++;
			}
			out.println();
		}
	}
}
