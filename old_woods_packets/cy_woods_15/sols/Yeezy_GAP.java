import java.util.*;
import java.io.*;

public class Yeezy_GAP {

    public static void main(String[] args) throws Exception
    {
		Scanner file = new Scanner(new File("yeezy.dat"));
		int t = file.nextInt();
		file.nextLine();
		for(int i = 0; i < t; i++)
		{
			double money = file.nextDouble();
			double x = 20 * 43;
			double y = x * money;
			double f = y * .25;
			if( f >= 2000)
			{
				System.out.println("True");
			} else
			System.out.println("False");
		}
    }
}
