//UIL District 2019 Solution
import static java.lang.System.*;
import java.io.*;
import java.util.*;

public class Dawn {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner data = new Scanner(new File("dawn.dat"));
		int sets = data.nextInt();
		double inheritance, apr;
		int years;
		double payment, value, profit;
		double total_inheritance = 0;
		double total_payments = 0;
		double total_value = 0;
		double total_profits = 0;

		out.println("     Amount                             Monthly         Total of");
		out.println("....Invested........APR......Years......Payment.........Payments............Profit..");

		for (int s = 1; s <= sets; s++) {
			inheritance = data.nextDouble();
			apr = data.nextDouble();
			years = data.nextInt();
			payment =  inheritance * apr/1200.0 /
					( 1.0 - Math.pow( 1.0 + apr/1200.0, -years*12));
			payment = Math.round(payment * 100.0) / 100.0;
			value = payment * years * 12;
			profit = value - inheritance;
			out.printf("$%,12.2f  |  %6.3f%%  |   %2d  |  $%,9.2f  |  $%,12.2f  |  $%,12.2f\n",
					inheritance, apr, years, payment, value, profit);
			total_inheritance += inheritance;
			total_payments += payment;
			total_value += value;
			total_profits += profit;
		}
		out.printf("$%,12.2f  |           |       |  $%,9.2f  |  $%,12.2f  |  $%,12.2f\n",
				total_inheritance, total_payments, total_value, total_profits);
		data.close();
	}
}
