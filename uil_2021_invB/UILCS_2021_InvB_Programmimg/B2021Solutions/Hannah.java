import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class Hannah
{
	public static void main(String args[]) throws FileNotFoundException
	{
        Scanner s;
		if(args.length==0)
            s = new Scanner(new File("hannah.dat"));
        else
            s = new Scanner(new File(args[0]));

        int numCases=s.nextInt();
        for(int caseNum=0;caseNum<numCases;caseNum++)
        {
            int base=0, result=0;
            String num1, num2;
            char sign;
            base=s.nextInt();
            num1=s.next();
            sign=s.next().charAt(0);
            num2=s.next();
            int i1,i2;
            i1=Integer.parseInt(num1, base);
            i2=Integer.parseInt(num2, base);
            switch(sign)
            {
                case '+':
                    result=i1+i2;
                    break;
                case '-':
                    result=i1-i2;
                    break;
                case '*':
                    result=i1*i2;
                    break;
                case '/':
                    result=i1/i2;
                    break;    
            }
            System.out.println(num1+" "+sign+" "+num2+" = "+Integer.toString(result,base).toUpperCase());
        }

        s.close();
    }
}