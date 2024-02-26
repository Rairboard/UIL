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

 
class Checkout
{
	//instance variables go here
	double total;

	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("Checkout.dat"));
		Scanner chop = new Scanner("");
		
		int cart = file.nextInt();
		file.nextLine();
		for(int i=0; i<cart; i++)
		{
			double cost= file.nextDouble();
			double tax =(file.nextDouble())*.01;
			double ct = tax*cost;
			double fin = cost +ct;
			total = total +fin;
		}
		total = total * 100;
		total = (Math.round(total));
		total = total/100;
		System.out.println("$"+total);
	}

	public static void main(String[] args)throws Exception
	{
		Checkout a=new Checkout();
		a.run();
	}
}