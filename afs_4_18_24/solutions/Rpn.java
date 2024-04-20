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


public class Rpn
{
	public void run()throws Exception
	{
		Scanner file = new Scanner(new File("Rpn.dat"));
		int zz = file.nextInt();file.nextLine();
		for(int z = 0;z<zz;z++)
		{
			Stack<Integer> st = new Stack<Integer>();
			String[] line = file.nextLine().split(" ");
			for(String s:line)
			{
				switch(s)
				{
					case "+":st.add(st.pop()+st.pop());break;
					case "-":st.add(-st.pop()+st.pop());break;
					case "*":st.add(st.pop()*st.pop());break;
					case "/":int a = st.pop();st.add(st.pop()/a);break;
					case "%":int b = st.pop();st.add(st.pop()%b);break;
					default:st.add(Integer.parseInt(s));
				}
			}
			System.out.println(st.pop());
		}
	}

	public static void main(String[] args)throws Exception
	{
		Rpn a=new Rpn();
		a.run();
	}

}