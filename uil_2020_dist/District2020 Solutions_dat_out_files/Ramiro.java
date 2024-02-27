/*
 *UIL Computer Science 2020
 *District Packet Solution
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
public class Ramiro
{
	public static void main(String args[]) throws FileNotFoundException
	{
		
		Scanner s = new Scanner(new File("ramiro.dat"));
        
        int N = s.nextInt();
       	s.nextLine();
        for ( int n = 0; n < N; n++ )
        {
            String s1=s.next();
            String s2=s.next();
            long num1=Long.parseLong(s1,16);
            long num2=Long.parseLong(s2,16);

            int count=0;

            for(int i=0;i<s1.length()*4;i++)//four bits for every hex digit
            {
                if((num1&1)!=(num2&1))
                    count++;
                num1=num1>>1;
                num2=num2>>1;
            }

            System.out.println(count);
        }

        s.close();
        
	}
}