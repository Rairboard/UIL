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


public class Checkout
{
	//instance variables go here

	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("Checkout.dat"));
		int jim = file.nextInt();
		file.nextLine();
		double total = 0;
		for(int bob = 0; bob<jim; bob++)
		{
			total += file.nextDouble()*((100+file.nextDouble())*.01);
		}
		out.printf("$%.2f",total);
	}

	public static void main(String[] args)throws Exception
	{
		Checkout a=new Checkout();
		a.run();
	}
}