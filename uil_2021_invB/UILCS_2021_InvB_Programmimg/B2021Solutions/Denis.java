import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Denis
{

    public static class Rational
    {
        int numerator;
        int denominator;

        public Rational(String num)
        {
            int n,d;
            n=Integer.parseInt(num.substring(0,num.indexOf('/')));
            d=Integer.parseInt(num.substring(num.indexOf('/')+1));
            numerator=n;
            denominator=d;
        }

        public void reduce()
        {
            int myGCD = gcd(numerator, denominator);
    
            if (denominator < 0)
                myGCD = myGCD * -1;
    
            numerator = numerator / myGCD;
            denominator = denominator / myGCD;
        }

        public String toString()
        {
            return ""+numerator+"/"+denominator;
        }
    }

    public static int gcd(int u, int v)
    {
        if (u == 0 && v == 0)
            return 0;
        
        if (v == 0)
            return Math.abs(u);
        
        if (u==0)
            return Math.abs(v);
        
        int divisor = Math.min(Math.abs(v), Math.abs(u));
        
        while ((u % divisor) != 0 || (v % divisor) != 0)
            divisor--;
        
        return divisor;
    }

	public static void main(String args[]) throws FileNotFoundException
	{
        Scanner s;
		if(args.length==0)
            s = new Scanner(new File("denis.dat"));
        else
            s = new Scanner(new File(args[0]));

        int numCases=s.nextInt();
        for(int caseNum=0;caseNum<numCases;caseNum++)
        {
            String num;
            num=s.next();

            Rational r1=new Rational(num);
            System.out.print(r1+" reduced is ");
            r1.reduce();
            System.out.println(r1);
        }

        s.close();
    }
}