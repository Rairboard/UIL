/*
 *UIL Computer Science 2020
 *Invitational B Packet Solution
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Brianna
{
	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner s = new Scanner(new File("brianna.dat"));
        int minValue, maxValue, range;
        minValue=s.nextInt();
        maxValue=minValue;
        while(s.hasNextInt())
        {
            int temp=s.nextInt();
            if(temp<minValue)
                minValue=temp;
            if(temp>maxValue)
                maxValue=temp;
        }
        range=maxValue-minValue;
        System.out.println(minValue+" "+maxValue+" "+range);
	}
}