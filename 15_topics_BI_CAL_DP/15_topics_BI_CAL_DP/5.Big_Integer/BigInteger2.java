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

public class BigInteger2
{
	public void run()throws Exception
	{
		BigInteger prime=new BigInteger("101");
		BigInteger notPrime=new BigInteger("100");

		// BigInteger's isProbablePrime(int certainty); 
		// method returns wheter the BigInteger
		// is prime to a certain certainty (correct 99.99% of the time)
		// 50 is a safe number to use to being with
		out.println(prime.isProbablePrime(50));
		out.println(notPrime.isProbablePrime(50));

		// loop will print out all prime numbers from 1 to 100
		for(int x=1;x<=100;x++)
		{
			if(new BigInteger(x+"").isProbablePrime(50))
				out.println(x);
		}
	}

	public static void main(String[] args)throws Exception
	{
		BigInteger2 a=new BigInteger2();
		a.run();
	}
}