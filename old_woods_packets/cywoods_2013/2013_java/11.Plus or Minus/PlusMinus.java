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


class PlusMinus
{

	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("plus.dat"));
		int times = file.nextInt();
		file.nextLine();
		
		for(int i=0;i<times;i++)
		{
			String[] data=file.nextLine().split(" ");
			int num1 = Integer.parseInt(data[0]);
			String action = data[1];
			int num2 = Integer.parseInt(data[2]);
			
			if(action.equals("plus"))
			{
				System.out.println(num1+num2);
			}
			else if(action.equals("minus"))
			{
				System.out.println(num1-num2);
			}
			else if(action.equals("times"))
			{
				System.out.println(num1*num2);
			}
			else
			{
				System.out.println(num1/num2);
			}
		}
	}

	public static void main(String[] args)throws Exception
	{
		PlusMinus a=new PlusMinus();
		a.run();
	}
}