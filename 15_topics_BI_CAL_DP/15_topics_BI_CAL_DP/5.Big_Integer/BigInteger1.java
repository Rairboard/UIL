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
import java.math.BigInteger;

public class BigInteger1
{
	public void run()throws Exception
	{
		//BigInteger takes in a string as a parameter
		BigInteger number1=new BigInteger("1");
		BigInteger number2=new BigInteger("2");
		
		
		//to add a biginteger to another biginteger use the .add() method
		BigInteger number3=number1.add(number2);
		out.println(number3);
		
		
		//to divide 2 bigintegers use the .divide() method
		number1=number3.divide(number3);
		out.println(number1);
		
		
		// other methods include
		/* 	.mod();
		 *	.multiply();
		 *	.min();
		 *	.max();
		 *	.isProbablePrime(); <- returns true if num is prime
		 *	.pow();  <- returns biginteger^parameter
		 *	.toString(num);  <- return biginteger in base num
		 */
	}
	
	public static void main(String[] args)throws Exception
	{
		BigInteger1 a=new BigInteger1();
		a.run();
	}	
}