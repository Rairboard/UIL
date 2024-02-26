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


class Derivative
{
	//instance variables go here
	
	public void run()throws Exception
	{
		Scanner file = new Scanner(new File("judgesDerivative.dat"));
		
		int times = file.nextInt();
		
		file.nextLine();
		
		for(int asdf = 0; asdf < times; asdf++)
		{
			int d = file.nextInt();
			file.nextLine();
			String[] s = file.nextLine().split(" ");
			ArrayList<String[]> terms = new ArrayList<>();
			String[] temp = {s[0],"+"};
			terms.add(temp);
			for(int q = 1; q < s.length-1; q+=2)
			{
				String[] t = {s[q+1],s[q]}; 
				terms.add(t);
			}
			
			for(int r = 0; r < terms.size(); r++)
			{
				String q = terms.get(r)[0];
				if(q.contains("x"))
				{
					if(q.contains("^"))
					{
						q = q.replaceAll("x\\^", " ");
						Scanner chop = new Scanner(q);
						int coeff = chop.nextInt();
						int exp = chop.nextInt();
						coeff *= exp--;
						String t = "";
						if(exp > 1)
						{
							t = coeff + "x^" + exp;
						}else
						{
							t = coeff + "x";
						}
						terms.get(r)[0] = t;
						continue;
					}else
					{
						q = q.replaceAll("x", " ");
						Scanner chop = new Scanner(q);
						int coeff = chop.nextInt();
						terms.get(r)[0] = "" + coeff;	
					}
					
				}else
				{
					terms.remove(r);
				}
			}
			System.out.print("f'(x)=" + (terms.get(0)[1].equals("-") ? "-" + terms.get(0)[0] : terms.get(0)[0]));
			for(int x = 1; x < terms.size(); x++)
			{
				
				System.out.print(terms.get(x)[1].equals("+") ? "+" + terms.get(x)[0] : "-" + terms.get(x)[0]);
			}
			System.out.println();
		}

	}
	


	public static void main(String[] args)throws Exception
	{
		Derivative a=new Derivative();
		a.run();
	}
}