import java.io.*;
import java.util.*;

public class slinky_clt
{
	//instance variables go here
	
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("Slinky_judges.dat"));
		int run=file.nextInt();
		file.nextLine();
		for(int q=0; q<run; q++)
		{
			double k=file.nextDouble();
			int x=file.nextInt();
			file.nextLine();
			double out=.5*k*(x*x);
			System.out.println(out);
		}
	}
	
	public static void main(String[] args)throws Exception
	{
		slinky_clt a=new slinky_clt();
		a.run();
	}	
}