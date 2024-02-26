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


class breeding
{
	public void run()throws Exception
	{
		PrintWriter out = new PrintWriter(new FileWriter("breeding.out"));
		Scanner file=new Scanner(new File("breeding.in"));
		int cases = file.nextInt();file.nextLine();
		List<String> stats = Arrays.asList("HP,ATK,DEF,SPA,SPD,SPE".split(","));
		for(int x = 0; x<cases; x++){
			String[][] parents= new String[2][];
			parents[0] = file.nextLine().split("-");
			parents[1] = file.nextLine().split("-");
			String[] statsinh = file.nextLine().split(",");
			boolean[] inherited = new boolean[6];
			for(String a: statsinh)
				inherited[stats.indexOf(a)] = true;
				
			String[] pif = file.nextLine().split(",");
			String[] child = new String[6];
			Arrays.fill(child,"?");
			int pos = 0;
			for(int y = 0; y<6; y++)
				if(inherited[y])
						child[y] = parents[Integer.parseInt(pif[pos++])-1][y];
			out.printf("%s-%s-%s-%s-%s-%s\n",child[0],child[1],child[2],child[3],child[4],child[5]);
			if(file.hasNext())file.nextLine();
		}
		out.close();
	}

	public static void main(String[] args)throws Exception
	{
		breeding a=new breeding();
		a.run();
	}
	
	
	public void generate()throws Exception{
		PrintWriter out = new PrintWriter(new FileWriter("breeding.in"));
		out.println(10);
		String[] stats = ("HP,ATK,DEF,SPA,SPD,SPE").split(",");
		for(int x = 0; x<10; x++){
			for(int y = 0; y<2; y++){
				for(int z = 0; z<6; z++){
					out.print((Math.random()<.5?"0":"1"));	
					if(z!=5)out.print("-");
				}
				out.println();
			}
			int skip = (int)(Math.random()*6);
			String stp = "", pf = "";
			for(int y = 0; y<6; y++){
				if(y!=skip)
				{
					stp+=stats[y]+",";
					pf+=((int)(Math.random()*2)+1)+",";
				}
			}
			out.println(stp.substring(0,stp.length()-1));
			out.println(pf.substring(0,pf.length()-1));
			if(x!=9)out.println();
		}
		out.close();
	}
}