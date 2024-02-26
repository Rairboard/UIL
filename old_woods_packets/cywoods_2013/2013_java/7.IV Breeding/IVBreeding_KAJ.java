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

public class IVBreeding {
    private String[] stats = new String[6];
    public IVBreeding() {
    }
    public String IVBreed(int[] par1, int[] par2, String[] stat, int[] pick)
    {
    	String[] stats = new String[6];
    	for(int i = 0; i < 5; i++)
    	{
    		switch(stat[i])
    		{
    			case "HP": if(pick[i] == 1){stats[0] = par1[0] + "";}else {stats[0] = par2[0] + "";}; break;
				case "ATK": if(pick[i] == 1){stats[1] = par1[1] + "";}else {stats[1] = par2[1] + "";}; break;
				case "DEF": if(pick[i] == 1){stats[2] = par1[2] + "";}else {stats[2] = par2[2] + "";}; break;
				case "SPA": if(pick[i] == 1){stats[3] = par1[3] + "";}else {stats[3] = par2[3] + "";}; break;
				case "SPD": if(pick[i] == 1){stats[4] = par1[4] + "";}else {stats[4] = par2[4] + "";}; break;
				case "SPE": if(pick[i] == 1){stats[5] = par1[5] + "";}else {stats[5] = par2[5] + "";}; break;
				default :
    		}
				
		}
		for(int i = 0; i < 6; i++)
    	{
    		if(stats[i] == null)
    		{
    			stats[i] = "?";
    		}
		}
		String temp = "";
    	for(int i = 0; i < 6; i++)
    	{
    		if(i < 5)
    		{
    			temp += stats[i] + "-";
    		}
    		else
    		{
    			temp += stats[i];
    		}
    		
		}
		return temp;
    	
    }

    
    public void run()throws Exception
	{
		Scanner file=new Scanner(new File("breeding.in"));
		int cases = file.nextInt();
		file.nextLine();
		for(int i = 0; i < cases; i++)
		{
			String[] temp1 = file.nextLine().split("-");
			String[] temp2 = file.nextLine().split("-");
			String[] temp3 = file.nextLine().split(",");
			String[] temp4 = file.nextLine().split(",");
			int[] new1 = new int[6];
			int[] new2 = new int[6];
			int[] new3 = new int[5];
			for(int j = 0; j < new1.length; j++)
			{
				new1[j] = Integer.parseInt(temp1[j]);
			}
			for(int j = 0; j < new2.length; j++)
			{
				new2[j] = Integer.parseInt(temp2[j]);
			}
			for(int j = 0; j < new3.length; j++)
			{
				new3[j] = Integer.parseInt(temp4[j]);
			}
			IVBreeding test =new IVBreeding();
			System.out.println(test.IVBreed(new1, new2, temp3, new3));
			if(i < cases-1)
			{
				file.nextLine();
			}
		}
	}

	public static void main(String[] args)throws Exception
	{
		IVBreeding a=new IVBreeding();
		a.run();
	}
}
