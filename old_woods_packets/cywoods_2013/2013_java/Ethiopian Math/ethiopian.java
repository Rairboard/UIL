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


class ethiopian
{
	public void run()throws Exception
	{
		PrintWriter out = new PrintWriter(new FileWriter("ethiopian.out"));
		Scanner file=new Scanner(new File("ethiopian.in"));
		int cases = file.nextInt();
		for(int x = 0; x<cases; x++){
			int n = file.nextInt(), p = file.nextInt();
			ArrayList<Integer> row1 = new ArrayList<Integer>();
			ArrayList<Integer> row2 = new ArrayList<Integer>();
			while(n>0){
				row1.add(n);
				n/=2;
			}
			for(int y = 0; y<row1.size(); y++){
				row2.add(p);
				p*=2;
			}
			out.println((""+row1).replaceAll("[\\[\\]]",""));
			out.println((""+row2).replaceAll("[\\[\\]]",""));
			if(x!=cases-1)out.println();
		}
		out.close();
	}

	public static void main(String[] args)throws Exception
	{
		ethiopian a=new ethiopian();
		a.run();
	}
	
	public void generate()throws Exception{
		PrintWriter out = new PrintWriter(new FileWriter("ethiopian.in"));
		out.println(20);
		for(int x= 0; x<20; x++){
			out.println(((int)(Math.random()*200)+1)+" "+((int)(Math.random()*200)+1));
		}
		out.close();
	}
}