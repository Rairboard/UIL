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
import java.math.*;


public class Primes
{
	public void run()throws Exception
	{
		String[] strs = "first second third fourth fifth sixth seventh eighth ninth tenth".split(" ");
		int found = 0;
		BigInteger i = new BigInteger("4");
		while(true){
			if(i.subtract(new BigInteger("1")).isProbablePrime(100))
				System.out.println("the "+strs[found++]+" mersenne prime is "+i.subtract(new BigInteger("1")));
			if(found==10)
				break;
			i = i.multiply(new BigInteger("2"));
		}
	}

	public static void main(String[] args)throws Exception
	{
		Primes a=new Primes();
		a.run();
	}

}