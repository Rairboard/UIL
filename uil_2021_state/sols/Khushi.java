import static java.lang.System.out;
import java.util.*;
import java.io.*;
public class Khushi {

	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("khushi.dat"));
		int n = f.nextInt();
		for(int x = 1; x <= n; x++) 
		{
			double purchase = f.nextDouble();
			double amount = f.nextDouble();
			double difference = amount - purchase;
			//out.println("difference= "+difference);
			if(difference == 0.00)
			{
				out.print("No Change Owed\n");
				continue;
			}
			//out.println("difference*100="+(difference*100));
			int change = (int)(Math.round(difference * 100));
			//out.println("change= "+change);
			int twenties = change / 2000;
			change %= 2000;
			int tens = change / 1000;
			change %= 1000;
			int fives = change / 500;
			change %= 500;
			int ones = change / 100;
			change %= 100;
			int quarters = change / 25;
			change %= 25;
			int dimes = change / 10;
			change %= 10;
			int nickels = change / 5;
			//out.println("change= "+change);
			int pennies = change % 5;
			if(twenties > 0)
				out.print(twenties + "-$20 ");
			if(tens > 0)
				out.print(tens + "-$10 ");
			if(fives > 0)
				out.print(fives + "-$5 ");
			if(ones > 0)
				out.print(ones + "-$1 ");
			if(quarters > 0)
				if(quarters == 1)
					out.print(quarters + "-Quarter ");
				else
					out.print(quarters + "-Quarters ");
			if(dimes > 0)
				if(dimes == 1)
					out.print(dimes + "-Dime ");
				else
					out.print(dimes + "-Dimes ");
			if(nickels > 0)
				if(nickels == 1)
					out.print(nickels + "-Nickel ");
				else
					out.print(nickels + "-Nickels ");
			if(pennies > 0)
				if(pennies == 1)
					out.print(pennies + "-Penny ");
				else
					out.print(pennies + "-Pennies ");
			out.println();
			
		}

	}

}
