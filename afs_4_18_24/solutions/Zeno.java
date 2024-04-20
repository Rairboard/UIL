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


public class Zeno
{
	public void run()throws Exception
	{
		Scanner file = new Scanner(new File("Zeno.dat"));
		int zz = file.nextInt();
		for(int z = 0;z<zz;z++)
		{
			double headstart = file.nextDouble();
			double speed = file.nextDouble();
			double tSpeed = file.nextDouble();
			int iteration = file.nextInt();
			for(int i =0 ;i<iteration;i++)
				headstart*=tSpeed/speed;
			System.out.printf("Achilles is %.3f feet behind the tortoise%n",headstart);
		}
	}

	public static void main(String[] args)throws Exception
	{
		Zeno a=new Zeno();
		a.run();
	}

}