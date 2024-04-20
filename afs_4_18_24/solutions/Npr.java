import java.io.*;
import java.util.*;
import java.text.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Character.*;
import static java.util.Collections.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;


public class Npr
{
	public void run()throws Exception
	{
		Scanner file = new Scanner(new File("Npr.dat"));
		int zz = file.nextInt();
		for(int z = 0;z<zz;z++)
		{
			int n = file.nextInt();
			int m = file.nextInt();
			System.out.printf("%d out of %d bunnies can be arranged in %d different ways%n",n,m,fact(m)/fact(m-n));
		}
	}
	
	public long fact(int x)
	{
		if(x == 0)
			return 1l;
		return x*fact(x-1);
	}

	public static void main(String[] args)throws Exception
	{
		Npr a=new Npr();
		a.run();
	}

}