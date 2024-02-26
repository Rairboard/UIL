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
	//instance variables go here

	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("breeding.in"));
		int plxstopthis=file.nextInt();file.nextLine();
		for(int times=plxstopthis;times>0;times--){
			String[] p1=file.nextLine().split("-");//out.println(p1[0]);
			String[] p2=file.nextLine().split("-");//out.println(p2[0]);
			String[] inherit=file.nextLine().split(",");//out.println(inherit[0]);
			String[] t=file.nextLine().split(","); int[] whichp=new int[t.length];//out.println(t[0]);
			String[] keys={"HP","ATK","DEF","SPA","SPD","SPE"};
			for(int x=0;x<t.length;x++){
				whichp[x]=Integer.parseInt(t[x]);
			}
			TreeMap<String,String> stats=new TreeMap<String,String>();
			int othercntr=0;
			for(int x=0;x<keys.length;x++){
				if(keys[x].contains(inherit[othercntr])){
					if(whichp[othercntr]==1){
						stats.put(keys[x],p1[x]);
					}
					else if(whichp[othercntr]==2){
						stats.put(keys[x],p2[x]);
					}
					othercntr++;
				}
				else{
					stats.put(keys[x],"?");
				}
			}
			out.print(stats.get("HP")+"-"+stats.get("ATK")+"-"+stats.get("DEF")+"-"+stats.get("SPA")+"-"+stats.get("SPD")+"-"+stats.get("SPE")+"\n");
		}
	}

	public static void main(String[] args)throws Exception
	{
		breeding a=new breeding();
		a.run();
	}
}